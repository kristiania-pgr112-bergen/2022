package LectureCode.Session14.src;

import LectureCode.Lecture11.src.Address;
import LectureCode.Lecture11.src.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

@FunctionalInterface
interface Drawable {
    public void draw();
}
class LambdaExample2 {
    public static void run() {
        int width = 10;
        /**
         * with lambda. We don’t need to define the method for providing the implementation.
         * We just write implementation code. Why? because the functional interface has only one method
         */
        Drawable drawable = ()->{
            System.out.println("Drawing "+width);
        };
        drawable.draw();
    }
}
class LambdaExample {
    public static void run() {
        int width = 10;
        /**
         * without lambda, Drawable implementation using anonymous class
         */
        Drawable drawable = new Drawable() {
            public void draw() {
                System.out.println("Drawing "+width);
            }
        };
        drawable.draw();
    }
}


interface Addable{
    int add(int a,int b);
}
class LambdaExample3 {
    public static void run() {
        /**
         * lambda expressions without return keyword
         */
        Addable addable = (a, b)->(a+b);
        System.out.println(addable.add(5,6));
        /**
         * lambda expressions with return keyword
         */
        Addable addable2 = (a, b)->{
            return a+b;
        };
        System.out.println(addable.add(5,6));
    }
}
class LambdaExample4{
    public static void run() {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(20, "ole", new Address("street1", "1234")));
        persons.add(new Person(23, "jerry", new Address("street101", "5000")));
        persons.add(new Person(21, "kari", new Address("street2", "4321")));
        /**
         * use lambda to iterate through collection and to filter data
         */
        Stream<Person> filtered_data = persons.stream().filter(p -> p.getAge() == 20);
        filtered_data.forEach((person)->System.out.println(person));
        /**
         *
         */
        Collections.sort(persons,(p1,p2)-> {
            return Integer.compare(p1.getAge(), p2.getAge());
        });
        persons.forEach((person)->System.out.println(person));
    }
}
