package LectureCode.Session8.src.AbstractExample;

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(1, 2.0);
        circle.setLineOfWeight(1.5);
        System.out.println(circle);
        System.out.println("The color is "+circle.getColor());
        System.out.println("The area is " + circle.getArea());
        System.out.println("The Perimeter is " + circle.getPerimeter());


        Shape rectangle = new Rectangle(2, 4.0, 3.0);
        rectangle.setColor(Color.Red);
        System.out.println(rectangle);
        System.out.println("The color is "+rectangle.getColor());
        System.out.println("The area is " + rectangle.getArea());
        System.out.println("The Perimeter is " + rectangle.getPerimeter());
        System.out.println("The line of weight is " + rectangle.getLineOfWeight());


    }
}
