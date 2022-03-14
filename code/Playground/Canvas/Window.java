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
            16
    );

    public static Color defaultTextColor = Color.black;

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

        this.canvas.graphics.setBackground(Color.WHITE);
        this.canvas.clear();

        System.out.printf("Rendering %d plugins ...%n", this.order.size());

        for (String plugin : this.order) {
            System.out.printf("Processing class[%s]-plugin ...%n", plugin);
            this.plugins.get(plugin).render(this.canvas);
        }
    };

    public Window(JFrame frame, int width, int height, ArrayList<String> pluginOrder) {
        frame.setSize(width, height);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);

        this.canvas = new Canvas(frame.getContentPane().getWidth(), frame.getContentPane().getHeight());
        this.order = new ArrayList<>();

        if (pluginOrder != null) {
            this.order.addAll(pluginOrder);
        }

        this.addMouseListener(new Canvas.CanvasMouseListener(this.canvas));
    };

    Window(JFrame frame, int width, int height) {
        this(frame, width, height, null);
    }

    public void initialize() {
        try {
            File folder = new File("%splugins".formatted(Window.folderPath));
            File loadOrder = new File("%s.plugins".formatted(Window.folderPath));
            Scanner scanner = new Scanner(loadOrder);

            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();

                this.order.add(line);
                this.plugins.put(line, null);
            };

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

                        System.out.printf("Initializing class[%s]%n", className);

                        if (this.order.contains(className)) {
                            this.plugins.replace(className, (Canvas.Plugin) plugin);
                        }
                        else {
                            this.order.add(className);
                            this.plugins.put(className, (Canvas.Plugin) plugin);
                        }
                    }
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        };
    };

    public static class Canvas {
        protected HashMap<Rectangle, Function<Canvas, Boolean>> mouseClicks = new HashMap<>();

        public void onMouseClick(Rectangle area, Function<Canvas, Boolean> o) {
            if (!(this.mouseClicks.containsKey(area))) {
                this.mouseClicks.put(area, o);
            }
        }

        public static abstract class Plugin {
            protected abstract void render(Canvas canvas);
        };

        public static class CanvasMouseListener implements MouseListener {
            Canvas canvas;

            CanvasMouseListener(Canvas canvas) {
                this.canvas = canvas;
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                for (Rectangle area : this.canvas.mouseClicks.keySet()) {
                    Point click = e.getPoint();

                    if (click.x >= area.x
                     && click.x <= area.width
                     && click.y >= area.y
                     && click.y <= area.height
                    ) {
                        boolean result = this.canvas.mouseClicks.get(area).apply(this.canvas);

                        if (!result) {
                            System.out.println("Mouse click event return false");
                        }
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
            BOTTOM_RIGHT;
        };

        public static float[] getAnchorDisplacement(Anchor anchor) {
            switch (anchor) {
                case CENTER                 -> { return new float[] { 0.5f, 0.5f }; }
                case TOP, TOP_LEFT          -> { return new float[] { 0.0f, 0.0f }; }
                case TOP_RIGHT              -> { return new float[] { 1.0f, 0.0f }; }
                case BOTTOM_LEFT            -> { return new float[] { 0.0f, 1.0f }; }
                case BOTTOM, BOTTOM_RIGHT   -> { return new float[] { 1.0f, 1.0f }; }
                default                     -> { return Canvas.getAnchorDisplacement(Anchor.TOP_LEFT); }
            }
        };

        public static class Cache<T> {
            protected HashMap<String, T> data = new HashMap<>();
        }

        protected Graphics2D graphics = null;
        protected Cache<BufferedImage> cacheImages = new Cache<>();

        private boolean fillMode = false;

        private final int width;
        private final int height;

        Canvas(int width, int height) {
            System.out.printf("Width[%d] x Height[%d]%n", width, height);

            this.width = width;
            this.height = height;
        };

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public boolean isFillMode() {
            return this.fillMode;
        }

        public void setFillMode() {
            this.fillMode = true;
        }

        public void setFillMode(boolean mode) {
            this.fillMode = mode;
        }

        public void clearFillMode() {
            this.fillMode = false;
        }

        protected void setGraphics(Graphics2D graphics) {
            this.graphics = graphics;
        };

        public void clear() {
            this.graphics.clearRect(0, 0, this.width, this.height);

            this.mouseClicks.clear();
        };

        //# HELPER METHODS
        public float getAngle(Point A, Point B) {
            return (float) Math.atan2(A.y - B.y, A.x - B.x);
        }

        //# COLOR
        public void setColor(Color color) {
            this.graphics.setColor(color);
        }

        public void resetColor() {
            this.graphics.setColor(Window.defaultTextColor);
        }

        //# SHAPES
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
        };

        public void drawRectangle(Rectangle r) {
            this.drawRectangle(r.x, r.y, r.width, r.height);
        }

        public void drawRectangle(Point point, Dimension size) {
            this.drawRectangle(point.x, point.y, size.width, size.height);
        }

        public void drawRectangle(Point point, int w, int h) {
            this.drawRectangle(point.x, point.y, w, h);
        }

        public void drawRectangle(int x, int y, int w, int h) {
            if (this.isFillMode()) {
                this.graphics.fillRect(x, y, w, h);
            }
            else {
                this.graphics.drawRect(x, y, w, h);
            }
        };
        public void drawCircle(int x, int y, float r) {
            this.drawCircle(new Point(x, y), r);
        }
        public void drawCircle(Point p, float r) {
            if (this.isFillMode()) {
                this.graphics.fillOval(p.x, p.y, (int)(p.x + (r * 2)), (int)(p.y + (r * 2)));
            }
            else {
                this.graphics.drawOval(p.x, p.y, (int)(p.x+(r*2)), (int)(p.y+(r*2)));
            }
        };
        public void drawLine(int startX, int startY, int endX, int endY) {
            this.drawLine(new Point(startX, startY), new Point(endX, endY));
        };
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
        };

        public void drawImage(String fileName, int x, int y, Anchor anchor) {
            this.drawImage(fileName, new Point(x, y), anchor);
        }

        public void drawImage(String fileName, int x, int y) {
            this.drawImage(fileName, x, y, Anchor.TOP_LEFT);
        };

        //# IMAGE RELATIVE
        public void drawImage(String fileName, float x, float y, Anchor anchor) {
            this.drawImage(fileName, (int)(this.width*x), (int)(this.height*y), anchor);
        };

        public void drawImage(String fileName, float x, float y) {
            this.drawImage(fileName, x, y, Anchor.TOP_LEFT);
        };

        //# TEXT
        public void drawText(Font font, String text, int x, int y, Anchor anchor) {
            this.drawText(font, text, new Point(x, y), anchor);
        }

        public void drawText(Font font, String text, Point point, Anchor anchor) {
            float[] transform = Canvas.getAnchorDisplacement(anchor);

            this.graphics.setFont(font);

            int textWidth = this.graphics.getFontMetrics().stringWidth(text);
            int textX = Math.max(0, point.x - (int)(textWidth*transform[0]));

            this.graphics.drawString(text, textX, point.y);

            this.graphics.setFont(Window.defaultFont);
        };

        public void drawText(Font font, String text, int x, int y) {
            this.drawText(font, text, x, y, Anchor.CENTER);
        };

        public void drawText(String text, int x, int y, Anchor anchor) {
            drawText(Window.defaultFont, text, x, y, anchor);
        }

        public void drawText(String text, int x, int y) {
            this.drawText(Window.defaultFont, text, x, y);
        };

        //# TEXT RELATIVE
        public void drawText(Font font, String text, float x, float y, Anchor anchor) {
            this.drawText(font, text, (int)(this.width*x), (int)(this.height*y), anchor);
        };

        public void drawText(Font font, String text, float x, float y) {
            this.drawText(font, text, x, y, Anchor.CENTER);
        };

        public void drawText(String text, float x, float y) {
            this.drawText(Window.defaultFont, text, x, y);
        };
    };
};
