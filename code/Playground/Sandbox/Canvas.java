package Playground.Sandbox;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class Canvas {
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

    public void clearRectangle(Rectangle rectangle) {
        this.graphics.clearRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
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

    public Point[] getCurvePath(int n, Point... points) {
        return null;
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
    public void drawDot(int x, int y) {
        this.drawDot(new Point(x, y));
    }

    public void drawDot(Point point) {
        this.drawDot(point, 3.0f);
    }

    public void drawDot(Point point, float r) {
        this.drawDot(point, r, Anchor.CENTER);
    }

    public void drawDot(Point point, float r, Anchor anchor) {
        float[] offset = Canvas.getAnchorDisplacement(anchor);

        int offsetX = (int)((r * offset[0])/2.0f);
        int offsetY = (int)((r * offset[1])/2.0f);

        this.graphics.fillOval(point.x - offsetX, point.y - offsetY, (int) r, (int) r);
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
        this.drawCircle(p, r, Canvas.Anchor.CENTER);
    }

    public void drawCircle(Point p, float r, Canvas.Anchor anchor) {
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

    //# Graphical helpers
    public Graphics getGraphics() {
        return this.window.getGraphics();
    }

    public Graphics getCurrentGraphics() {
        return this.graphics;
    }

    public void setGraphics(Graphics g) {
        this.graphics = (Graphics2D) g;
    }

    public BufferedImage getImage(String fileName) {
        if (!cacheImages.data.containsKey(fileName)) {
            try {
                cacheImages.data.put(
                        fileName,
                        ImageIO.read(
                                new File("%simages/%s".formatted(Window.folderPath, fileName))
                        )
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return cacheImages.data.get(fileName);
    }

    //# IMAGE (PART)
    public void drawImagePart(String fileName, Point point, Rectangle part) {
        this.drawImagePart(fileName, point, part, Anchor.TOP_LEFT);
    }

    public void drawImagePart(String fileName, Point point, Rectangle part, Anchor anchor) {
        this.drawImagePart(this.getImage(fileName), point, part, anchor);
    }

    public void drawImagePart(BufferedImage image, Point point, Rectangle part, Anchor anchor) {
        float[] scale = Canvas.getAnchorDisplacement(anchor);

        int offsetX = (int)(part.width  * scale[0]);
        int offsetY = (int)(part.height * scale[1]);

        System.out.println(part);

        this.graphics.drawImage(
                image,
                point.x - offsetX,
                point.y - offsetY,
                point.x - offsetX + part.width,
                point.y - offsetY + part.height,

                part.x,
                part.y,
                part.x + part.width,
                part.y + part.height,

                null
        );
    }

    //# IMAGE
    public void drawImage(String fileName, Point point, Anchor anchor) {
        BufferedImage image = this.getImage(fileName);

        float[] transform = Canvas.getAnchorDisplacement(anchor);

        int imageX = Math.max(0, point.x - (int)(image.getWidth()*transform[0]));
        int imageY = Math.max(0, point.y - (int)(image.getHeight()*transform[1]));

        this.graphics.drawImage(
                image,
                imageX,
                imageY,
                null
        );
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
        this.drawText(font, text, new Point((int)(this.width*x), (int)(this.height*y)), anchor);
    }

    public void drawText(Font font, String text, float x, float y) {
        this.drawText(font, text, x, y, Anchor.CENTER);
    }

    public void drawText(String text, float x, float y) {
        this.drawText(Window.defaultFont, text, x, y);
    }
}