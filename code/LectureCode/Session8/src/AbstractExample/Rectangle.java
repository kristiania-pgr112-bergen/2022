package LectureCode.Session8.src.AbstractExample;

abstract public class Rectangle extends Shape {
    public Rectangle(int Id) {
        super(Id);
    }

    /**
     * override non-abstract method
     */
    @Override
    public void colorMe() {
        this.color = Color.Red;
        System.out.println("my color is " + this.color);
    }

    public void myOperations() {
        drawMe();
        super.fillMe();
        colorMe();
        setLineWeightForMe(1.5);
    }
    @Override
    public String toString() {
        return String.format("A Rectangle with color = %s, fill = %b, lineWeight = %f is created", color, filled, weightOfLine);
    }
}
