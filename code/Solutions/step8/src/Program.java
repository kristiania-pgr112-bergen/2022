package Solutions.step8.src;

import java.awt.Color;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Program {

    HashMap<Integer, Shape> shapes = new HashMap<>();

    public void checkCircles(){
        System.out.println("Checking circles");
        System.out.println("------------");
        Circle c1 = new Circle(1);
        System.out.printf("Circle with id=1:%s%n", c1);
        shapes.put(1, c1);
        Circle c2 = new Circle(2, 2.0);
        System.out.printf("Circle with id=2 and r=2:%s%n", c2);
        shapes.put(2, c2);
        Circle c3 = new Circle(3, 3.0, Color.BLUE, false);
        System.out.printf("Blue non-filled circle with id= 3 and r=3:%s%n", c3);
        shapes.put(3, c3);
        System.out.printf("Area:%s, Perimeter:%s%n", c3.getArea(), c3.getPerimeter());
        System.out.println("Checking circles done");
        System.out.println("------------");
    }

    public void checkSquares(){
        System.out.println("Checking squares");
        System.out.println("------------");
        Square s1 = new Square(4);
        System.out.printf("Square with id=4:%s%n", s1);
        shapes.put(4, s1);
        Square s2 = new Square(5, 5);
        System.out.printf("Square with id=5 and side=5:%s%n", s2);
        shapes.put(5, s2);
        Square s3 = new Square(6, 5, Color.BLUE, true);
        System.out.printf("Blue filled square with id=6 and side=5:%s%n", s3);
        shapes.put(6, s3);
        System.out.printf("Area:%s, Perimeter:%s%n", s3.getArea(), s3.getPerimeter());
        System.out.println("Checking square done");
        System.out.println("------------");
    }

    public void checkRectangles(){
        System.out.println("Checking rectangles");
        System.out.println("------------");
        Rectangle r1 = new Rectangle(7);
        System.out.printf("Rectangle with id=7:%s%n", r1);
        shapes.put(7, r1);
        Rectangle r2 = new Rectangle(8, 3, 4);
        System.out.printf("Rectangle with id=8, width=3 and length=4:%s%n", r2);
        shapes.put(8, r2);
        Rectangle r3 = new Rectangle(9, 3, 4, Color.LIGHT_GRAY, false);
        System.out.printf("Blue non-filled rectangle with id=9, width=3 and length=4:%s%n", r3);
        shapes.put(9, r3);
        System.out.printf("Area:%s, Perimeter:%s%n", r3.getArea(), r3.getPerimeter());
        System.out.println("Checking rectangle done");
        System.out.println("------------");
    }

    public void printHashMapContentUsingToString(){
        System.out.println("Printing HashMap content using toString:");
        System.out.println(shapes);
        System.out.println("Done printing HashMap content using toString");
        System.out.println("-----------------");
    }

    public void printHashMapContentUsingForEachLoop() {
        System.out.println("Printing HashMap content using for-each:");
        for (Shape shape : shapes.values()) {
            System.out.println(shape.toString());
        }
        System.out.println("Done printing HashMap content using for-each");
        System.out.println("-----------------");
    }

    public void printHashMapElement(int id) {
        Shape s = shapes.get(id);
        if(s!=null){
            System.out.printf("Look what I found with id =%s:%n%s%n", id, s);
        } else {
            System.out.printf("Sorry, can't find shape with id =%s:%n", id);
        }
    }

    /*
    Ekstra-oppgaver
     */

    public void printHashMapContentUsingIterator() {
        Iterator<Map.Entry<Integer, Shape>> it = shapes.entrySet().iterator();
        System.out.println("Printing HashMap content using iterator:");
        while(it.hasNext()){
            System.out.println(it.next().getValue());
        }
        System.out.println("Done printing HashMap content using iterator");
        System.out.println("-----------------");
    }

    public void printHashMapContentUsingForEachEntry() {
        System.out.println("Printing HashMap content retrieving both key and value:");
        for(Map.Entry<Integer, Shape> mapElement : shapes.entrySet()){
            int key = mapElement.getKey();
            Shape value = mapElement.getValue();
            System.out.printf("Cool, I have both id(%s) and value:%n%s%n", key, value);
        }
        System.out.println("Done printing HashMap content retrieving both key and value");
        System.out.println("-----------------");
    }

    public void printHashMapContentUsingAnotherForEach() {
        System.out.println("Printing HashMap using lambda:");
        shapes.forEach((k,v) -> System.out.printf("Hello lambda! I have both id(%s) and value:%n%s%n", k, v));
        System.out.println("Done printing HashMap content using lambda");
        System.out.println("-----------------");
    }

    public void printShapesWithAreaGreaterThanCertainValue(double area) {
        for (Shape shape : shapes.values()) {
            if(shape.getArea() > area){
                System.out.printf("Shape bigger than %s:%n:%s%n", area, shape);
            }
        }
        System.out.println("-----------------");
    }

    public List<Shape> getShapesWithPerimeterGreaterThanCertainValue(double perimeter) {
        return shapes.values().stream().filter((s)->s.getPerimeter()>perimeter).collect(Collectors.toList());
    }
}
