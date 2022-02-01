package LectureCode.Session8.src.AbstractExample;

abstract class Shape {
    protected int Id;
    protected boolean filled;
    protected Color color;
    static double weightOfLine;

    /**
     * abstract class can also have constructor
     *
     * @param Id
     */
    public Shape(int Id) {
        this.Id = Id;
        System.out.println("A shape is created, and its id is " + Id);
    }

    /**
     * abstract method
     */
    abstract public void drawMe();

    /**
     * non-abstract method (method with body)
     */
    public void colorMe() {
        this.color = Color.Green;
    }

    /**
     * final method, not to be overriden
     */
    final public void fillMe() {
        this.filled = true;
        System.out.println("I am filled");
    }

    /**
     * static method
     *
     * @param weightOfLine
     */
    static public void setLineWeightForMe(double weightOfLine) {
        Shape.weightOfLine = weightOfLine;
        System.out.println("The weight of line is " + weightOfLine);
    }
}
