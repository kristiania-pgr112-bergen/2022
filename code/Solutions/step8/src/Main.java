package Solutions.step8.src;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Program p = new Program();
        p.checkCircles();
        p.checkRectangles();
        p.checkSquares();
        p.printHashMapContentUsingToString();
        p.printHashMapContentUsingForEachLoop();
        p.printHashMapElement(1);

        //Extraoppgaver (vanskelig)
        p.printHashMapContentUsingIterator();
        p.printHashMapContentUsingForEachEntry();
        p.printHashMapContentUsingAnotherForEach();
        p.printShapesWithAreaGreaterThanCertainValue(3);
        List<Shape> bigShapes =  p.getShapesWithPerimeterGreaterThanCertainValue(19);
        System.out.printf("Big perimeter shapes:%n%s%n", bigShapes);
    }
}
