package LectureCode.Lecture11.src;

import java.util.HashMap;
import java.util.Iterator;

public class IteratorExample {
    public void run() {
        Animal myPig = new Pig(1); // Create a Pig object
        myPig.animalSound();
        myPig.sleep();

        Cat cat = new Cat(2);
        cat.animalSound();
        cat.sleep();

        /**
         * HashMap implements iterable interface
         */
        HashMap<Integer, Animal> animals = new HashMap<>();
        animals.put(myPig.id, myPig);
        animals.put(cat.id, cat);
        System.out.println("Printing animals using enhanced for loop:");
        for (Animal animal :
                animals.values()) {
            animal.animalSound();
            animal.sleep();
            System.out.println(animal);
        }
        System.out.println("Printing animals using forEach loop:");
        animals.values().forEach(
                (animal -> {
                    animal.animalSound();
                    animal.sleep();
                    System.out.println(animal);
                })
        );
        System.out.println("Printing animals using Iterator:");
        Iterator<Integer> it = animals.keySet().iterator();
        while(it.hasNext())
        {
            int key=(int)it.next();
            animals.get(key).animalSound();
            animals.get(key).sleep();
            System.out.println(animals.get(key).toString());
        }
    }
}