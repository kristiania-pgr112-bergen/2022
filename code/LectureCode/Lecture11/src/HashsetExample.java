package LectureCode.Lecture11.src;

import java.util.HashSet;
import java.util.Iterator;

public class HashsetExample {
    public void run() {
        Animal myPig = new Pig(1); // Create a Pig object
        Cat cat = new Cat(2);
        HashSet<Animal> animals=new HashSet<>();
        /**
         * hashset can contain duplicate elements, but during iterating,
         * duplicated elements will be ignored
         */
        animals.add(myPig);
        animals.add(myPig);
        animals.add(cat);
        /**
         * hashset can contain null element
         */
        animals.add(null);
        Iterator<Animal> i=animals.iterator();
        /**
         * The elements iterate in an unordered collection
         */
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
        /**
         * remove element from hashset
         */
        animals.remove(cat);
        System.out.println(animals);
        /**
         * using lambda expression in removeIf
         */
        animals.removeIf(animal -> animal instanceof Pig);
        System.out.println(animals);
        /**
         * Java HashSet from another Collection
         */
        HashSet<Animal> newanimals=new HashSet<>();
        newanimals.add(new Pig(3));
        newanimals.add(new Cat(4));
        animals.addAll(newanimals);
        System.out.println(animals);
        animals.removeIf(animal -> animal!=null && animal.id==4);
        System.out.println(animals);
        /**
         * removeAll and clear
         */
        animals.removeAll(newanimals);
        System.out.println(animals);
        animals.clear();
        System.out.println(animals);

    }
}
