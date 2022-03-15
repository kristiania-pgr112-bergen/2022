package Playground.Canvas;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;
import java.util.Objects;
import java.util.Scanner;

public class Window extends JPanel {
    public static final String folderPath = "code/Playground/Canvas/";
    public static final String classPackage = Window.class.getPackageName();

    public static Font defaultFont = new Font(
            "Consolas",
            Font.PLAIN,
            24
    );

    public static Color defaultTextColor = Color.BLACK;

    public static Color defaultBackgroundColor = Color.WHITE;

    public static void setDefaultFont(Font font) {
        Window.defaultFont = font;
    }

    public static void setDefaultTextColor(Color color) {
        Window.defaultTextColor = color;
    }

    Canvas canvas;
    ArrayList<String> order;
    HashMap<String, Canvas.Plugin> plugins = new HashMap<>();

    @Override
    public void paint(Graphics graphics) {
        this.canvas.setGraphics((Graphics2D) graphics);

        this.canvas.graphics.setBackground(Window.defaultBackgroundColor);
        this.canvas.clear();

        // System.out.printf("Rendering %d plugins ...%n", this.order.size());

        for (String pluginName : this.order) {
            // System.out.printf("Processing class[%s]-plugin ...%n", plugin);
            this.plugins.get(pluginName).render(this.canvas);
        }
    }

    public Window(JFrame frame, int width, int height, ArrayList<String> pluginOrder) {
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);

        this.canvas = new Canvas(
                this,
                frame.getContentPane().getWidth(),
                frame.getContentPane().getHeight()
        );
        this.order = new ArrayList<>();

        if (pluginOrder != null) {
            this.order.addAll(pluginOrder);
        }

        this.addMouseListener(new Canvas.CanvasMouseListener(this.canvas));
    }

    Window(JFrame frame, int width, int height) {
        this(frame, width, height, null);
    }

    public void initialize() {
        this.initialize(true);
    }

    public void initialize(boolean loadOrderOnly) {
        if (loadOrderOnly) {
            for (String pluginName : this.order) {
                try {
                    String pkg = "%s.%s".formatted(classPackage, pluginName);

                    Class<?> cls = Class.forName(
                            pkg,
                            false,
                            this.getClass().getClassLoader()
                    );

                    Object plugin = cls.getDeclaredConstructor().newInstance();

                    System.out.printf("Initializing class[%s] plugin%n", pluginName);

                    this.plugins.put(pluginName, (Canvas.Plugin) plugin);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            try {
                File folder = new File("%splugins".formatted(Window.folderPath));
                File loadOrder = new File("%s.plugins".formatted(Window.folderPath));
                Scanner scanner = new Scanner(loadOrder);

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    this.order.add(line);
                    this.plugins.put(line, null);
                }

                for (final File file : Objects.requireNonNull(folder.listFiles())) {
                    if (file.isFile()) {
                        String fileName = file.getName();

                        if (fileName.endsWith(".java")) {
                            String className = fileName.substring(0, fileName.length() - 5);

                            Class<?> cls = Class.forName(
                                    "%s.plugins.%s".formatted(classPackage, className),
                                    false,
                                    this.getClass().getClassLoader()
                            );

                            Object plugin = cls.getDeclaredConstructor().newInstance();

                            System.out.printf("Initializing class[%s] plugin%n", className);

                            if (this.order.contains(className)) {
                                this.plugins.replace(className, (Canvas.Plugin) plugin);
                            } else {
                                this.order.add(className);
                                this.plugins.put(className, (Canvas.Plugin) plugin);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class Canvas {
        protected HashMap<Rectangle, Function<Point, Boolean>> mouseClicks = new HashMap<>();

        public void onMouseClick(Rectangle area, Function<Point, Boolean> o) {
            if (!(this.mouseClicks.containsKey(area))) {
                this.mouseClicks.put(area, o);
            }
        }

        public static abstract class Plugin {
            protected abstract void render(Canvas canvas);
        }

        public static class CanvasMouseListener implements MouseListener {
            Canvas canvas;

            CanvasMouseListener(Canvas canvas) {
                this.canvas = canvas;
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                Point click = e.getPoint();

                for (Rectangle area : this.canvas.mouseClicks.keySet()) {
                    if (click.x >= area.x
                     && click.x <= (area.x + area.width)

                     && click.y >= area.y
                     && click.y <= (area.y + area.height)
                    ) {
                        this.canvas.mouseClicks.get(area).apply(click);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }
        }

        public enum Anchor {
            CENTER,
            TOP,
            BOTTOM,
            LEFT,
            RIGHT,
            TOP_LEFT,
            TOP_RIGHT,
            BOTTOM_LEFT,
            BOTTOM_RIGHT
        }

        public static float[] getAnchorDisplacement(Anchor anchor) {
            switch (anchor) {
                case CENTER                 -> { return new float[] { 0.5f, 0.5f }; }
                case TOP                    -> { return new float[] { 0.5f, 0.0f }; }
                case TOP_LEFT               -> { return new float[] { 0.0f, 0.0f }; }
                case TOP_RIGHT              -> { return new float[] { 1.0f, 0.0f }; }
                case BOTTOM                 -> { return new float[] { 0.5f, 1.0f }; }
                case BOTTOM_LEFT            -> { return new float[] { 0.0f, 1.0f }; }
                case BOTTOM_RIGHT           -> { return new float[] { 1.0f, 1.0f }; }
                case LEFT                   -> { return new float[] { 0.0f, 0.5f }; }
                case RIGHT                  -> { return new float[] { 1.0f, 0.5f }; }
                default                     -> { return Canvas.getAnchorDisplacement(Anchor.CENTER); }
            }
        }

        public static class Cache<T> {
            protected HashMap<String, T> data = new HashMap<>();
        }

        protected Window window;
        protected Graphics2D graphics = null;
        protected Cache<BufferedImage> cacheImages = new Cache<>();

        private boolean fillMode = false;

        private final int width;
        private final int height;

        Canvas(Window window, int width, int height) {
            this.window = window;
            System.out.printf("Canvas width[%d] x height[%d]%n", width, height);

            this.width = width;
            this.height = height;
        }

        public void redraw() {
            this.window.repaint();
        }

        public int getWidth() {
            return this.width;
        }

        public int getHalfWidth() {
            return (int)(this.getWidth()/2.0d);
        }

        public int getHeight() {
            return this.height;
        }

        public int getHalfHeight() {
            return (int)(this.getHeight()/2.0d);
        }

        public boolean isFillMode() {
            return this.fillMode;
        }

        public void setFillMode() {
            this.setFillMode(true);
        }

        public void setFillMode(boolean mode) {
            this.fillMode = mode;
        }

        public void clearFillMode() {
            this.fillMode = false;
        }

        protected void setGraphics(Graphics2D graphics) {
            this.graphics = graphics;
        }

        public void clear() {
            this.graphics.clearRect(0, 0, this.width, this.height);

            this.mouseClicks.clear();
        }

        //# HELPER METHODS
        public float getAngle(Point A, Point B) {
            return (float) Math.atan2(A.y - B.y, A.x - B.x);
        }

        public Point getCenterPoint() {
            return new Point(this.getHalfWidth(), this.getHalfHeight());
        }

        public Point getRelativePoint(float x, float y) {
            return new Point((int)(this.getWidth()*x), (int)(this.getHeight()*y));
        }

        public Point getRandomPoint() {
            return new Point(
                    (int)(Math.random()*(this.getWidth() + 1)),
                    (int)(Math.random()*(this.getHeight() + 1))
            );
        }

        //# COLOR
        public void setColor(Color color) {
            this.graphics.setColor(color);
        }

        public void clearColor() {
            this.graphics.setColor(Window.defaultTextColor);
        }

        public void setBackgroundColor(Color color) {
            Window.defaultBackgroundColor = color;
        }

        //# SHAPES
        public void drawTriangle(int... coordinates) {
            assert coordinates.length == 6;

            ArrayList<Point> points = new ArrayList<>();

            points.add(new Point(coordinates[0], coordinates[1]));
            points.add(new Point(coordinates[2], coordinates[3]));
            points.add(new Point(coordinates[4], coordinates[5]));

            this.drawTriangle(points);
        }

        public void drawTriangle(ArrayList<? extends Point> points) {
            if (this.isFillMode()) {
                this.graphics.drawPolygon(
                        new int[] {
                                points.get(0).x,
                                points.get(1).x,
                                points.get(2).x,
                                points.get(0).x
                        },
                        new int[] {
                                points.get(0).y,
                                points.get(1).y,
                                points.get(2).y,
                                points.get(0).y
                        },
                        4
                );
            }
            else {
                this.graphics.drawPolyline(
                        new int[]{
                                points.get(0).x,
                                points.get(1).x,
                                points.get(2).x,
                                points.get(0).x
                        },
                        new int[]{
                                points.get(0).y,
                                points.get(1).y,
                                points.get(2).y,
                                points.get(0).y
                        },
                        4
                );
            }
        }

        public void drawSquare(Point point, int size, Anchor anchor) {
            this.drawRectangle(point, new Dimension(size, size), anchor);
        }

        public void drawSquare(Point point, int size) {
            this.drawRectangle(point, new Dimension(size, size));
        }

        public void drawRectangle(Rectangle r, Anchor anchor) {
            this.drawRectangle(new Point(r.x, r.y), new Dimension(r.width, r.height), anchor);
        }

        public void drawRectangle(Rectangle r) {
            this.drawRectangle(new Point(r.x, r.y), new Dimension(r.width, r.height), Anchor.CENTER);
        }

        public void drawRectangle(Point point, Dimension size) {
            this.drawRectangle(point, size, Anchor.CENTER);
        }

        public void drawRectangle(Point point, int w, int h) {
            this.drawRectangle(point, new Dimension(w, h));
        }

        public void drawRectangle(int x, int y, int w, int h) {
            this.drawRectangle(new Point(x, y), new Dimension(w, h), Anchor.CENTER);
        }

        public void drawRectangle(Point point, Dimension size, Anchor anchor) {
            float[] transform = Canvas.getAnchorDisplacement(anchor);

            if (this.isFillMode()) {
                this.graphics.fillRect(
                        (int)(point.x - (size.width*transform[0])),
                        (int)(point.y - (size.height*transform[1])),
                        size.width,
                        size.height
                );
            }
            else {
                this.graphics.drawRect(
                        (int)(point.x - (size.width*transform[0])),
                        (int)(point.y - (size.height*transform[1])),
                        size.width,
                        size.height
                );
            }
        }

        public void drawCross(int x, int y, float r) {
            this.drawCross(new Point(x, y), r);
        }

        public void drawCross(Point p, float r) {
            this.drawCross(p, r, Anchor.CENTER);
        }

        public void drawCross(Point p, float r, Anchor anchor) {
            double angle = Math.PI/4.0d;

            this.drawLine(
                    p.x - (int)(Math.cos(angle)*r),
                    p.y - (int)(Math.sin(angle)*r),

                    p.x - (int)(Math.cos(angle + Math.PI)*r),
                    p.y - (int)(Math.sin(angle + Math.PI)*r)
            );

            this.drawLine(
                    p.x - (int)(Math.cos(angle + Math.PI/2)*r),
                    p.y - (int)(Math.sin(angle + Math.PI/2)*r),

                    p.x - (int)(Math.cos(angle - Math.PI/2)*r),
                    p.y - (int)(Math.sin(angle - Math.PI/2)*r)
            );
        }


        public void drawCircle(int x, int y, float r) {
            this.drawCircle(new Point(x, y), r);
        }

        public void drawCircle(Point p, float r) {
            this.drawCircle(p, r, Anchor.CENTER);
        }

        public void drawCircle(Point p, float r, Window.Canvas.Anchor anchor) {
            float[] transform = Canvas.getAnchorDisplacement(anchor);

            if (this.isFillMode()) {
                this.graphics.fillOval(
                        (int)(p.x - ((r*2)*transform[0])),
                        (int)(p.y - ((r*2)*transform[1])),
                        (int)(r * 2),
                        (int)(r * 2)
                );
            }
            else {
                this.graphics.drawOval(
                        (int)(p.x - ((r*2)*transform[0])),
                        (int)(p.y - ((r*2)*transform[1])),
                        (int)(r * 2),
                        (int)(r * 2)
                );
            }
        }

        public void drawLine(int startX, int startY, int endX, int endY) {
            this.drawLine(new Point(startX, startY), new Point(endX, endY));
        }

        public void drawLine(float startX, float startY, float endX, float endY) {
            this.drawLine(
                    (int)(this.getWidth()*startX),
                    (int)(this.getHeight()*startY),
                    (int)(this.getWidth()*endX),
                    (int)(this.getHeight()*endY)
            );
        }

        public void drawLine(Point start, Point end) {
            this.graphics.drawLine(
                    start.x,
                    start.y,
                    end.x,
                    end.y
            );
        }

        public void drawArrow(int startX, int startY, int endX, int endY) {
            this.drawArrow(new Point(startX, startY), new Point(endX, endY));
        }

        public void drawArrow(Point start, Point end) {
            this.drawLine(start, end);

            float angle = this.getAngle(end, start);
            ArrayList<Point> triangle = new ArrayList<>();

            triangle.add(end);
            triangle.add(new Point(
                    (int)(end.x - Math.cos(angle + Math.PI/4.0d)*16),
                    (int)(end.y - Math.sin(angle + Math.PI/4.0d)*16)
            ));
            triangle.add(new Point(
                    (int)(end.x - Math.cos(angle - Math.PI/4.0d)*16),
                    (int)(end.y - Math.sin(angle - Math.PI/4.0d)*16)
            ));

            this.setFillMode();
            this.drawTriangle(triangle);
            this.clearFillMode();
        }

        //# IMAGE
        public void drawImage(String fileName, Point point, Anchor anchor) {
            try {
                if (!cacheImages.data.containsKey(fileName)) {
                    cacheImages.data.put(
                            fileName,
                            ImageIO.read(
                                    new File("%simages/%s".formatted(Window.folderPath, fileName))
                            )
                    );
                }

                BufferedImage image = cacheImages.data.get(fileName);

                float[] transform = Canvas.getAnchorDisplacement(anchor);

                int imageX = Math.max(0, point.x - (int)(image.getWidth()*transform[0]));
                int imageY = Math.max(0, point.y - (int)(image.getHeight()*transform[1]));

                this.graphics.drawImage(
                        image,
                        imageX,
                        imageY,
                        null
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void drawImage(String fileName, int x, int y, Anchor anchor) {
            this.drawImage(fileName, new Point(x, y), anchor);
        }

        public void drawImage(String fileName, int x, int y) {
            this.drawImage(fileName, x, y, Anchor.TOP_LEFT);
        }

        //# IMAGE RELATIVE
        public void drawImage(String fileName, float x, float y, Anchor anchor) {
            this.drawImage(fileName, (int)(this.width*x), (int)(this.height*y), anchor);
        }

        public void drawImage(String fileName, float x, float y) {
            this.drawImage(fileName, x, y, Anchor.TOP_LEFT);
        }

        //# TEXT
        public void drawText(Font font, String text, int x, int y, Anchor anchor) {
            this.drawText(font, text, new Point(x, y), anchor);
        }

        public void drawText(String text, Point point) {
            this.drawText(text, point, Anchor.CENTER);
        }

        public void drawText(Font font, String text, Point point, Anchor anchor) {
            float[] transform = Canvas.getAnchorDisplacement(anchor);

            this.graphics.setFont(font);

            int textWidth = this.graphics.getFontMetrics().stringWidth(text);
            int textX = Math.max(0, point.x - (int)(textWidth*transform[0]));

            this.graphics.drawString(text, textX, point.y);

            this.graphics.setFont(Window.defaultFont);
        }

        public void drawText(Font font, String text, int x, int y) {
            this.drawText(font, text, x, y, Anchor.CENTER);
        }

        public void drawText(String text, Point point, Anchor anchor) {
            this.drawText(Window.defaultFont, text, point, anchor);
        }

        public void drawText(String text, int x, int y, Anchor anchor) {
            drawText(Window.defaultFont, text, x, y, anchor);
        }

        public void drawText(String text, int x, int y) {
            this.drawText(Window.defaultFont, text, x, y);
        }

        //# TEXT RELATIVE
        public void drawText(Font font, String text, float x, float y, Anchor anchor) {
            this.drawText(font, text, (int)(this.width*x), (int)(this.height*y), anchor);
        }

        public void drawText(Font font, String text, float x, float y) {
            this.drawText(font, text, x, y, Anchor.CENTER);
        }

        public void drawText(String text, float x, float y) {
            this.drawText(Window.defaultFont, text, x, y);
        }
    }
}
