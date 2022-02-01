package LectureCode.Session8.src.AbstractExample;

abstract class Shape {
    private Color color;
    private boolean filled;

    public int getId() {
        return Id;
    }

    private final int Id;
    private static double lineOfWeight;
    public static double getLineOfWeight() {
        return lineOfWeight;
    }
    public static void setLineOfWeight(double lineOfWeight) {
        Shape.lineOfWeight = lineOfWeight;
    }
    /**
     * abstract class can also have constructor
     */
    public Shape(int Id) {
        this.Id = Id;
        setColor(Color.Green);
    }
    public Color getColor() {
        return color;
    }
    /**
     * regular, non-abstract method (method with body)
     */
    public void setColor(Color color) {
        this.color = color;
    }
    public boolean isFilled() {
        return filled;
    }
    /**
     * final method, not to be overriden
     */
    final public void setFilled(boolean filled) {
        this.filled = filled;
    }
    /**
     * abstract method
     */
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public String toString() {
        return String.format("A shape is created, and its id is " + Id);
    }
}
