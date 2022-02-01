package LectureCode.Session8.src.animals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Pig myPig = new Pig(1); // Create a Pig object
        myPig.animalSound();
        myPig.sleep();
        myPig.provideMilkForBaby();
        myPig.regulateBodyHeat();

        Cat cat = new Cat(2);
        cat.animalSound();
        cat.sleep();
        cat.provideMilkForBaby();
        cat.regulateBodyHeat();

        HashMap<Integer, Animal> animals = new HashMap<>();
        animals.put(myPig.id, myPig);
        animals.put(cat.id, cat);
        System.out.println("Printing animals:");
        for (Animal animal :
                animals.values()) {
            animal.animalSound();
            animal.sleep();
            System.out.println(animal.toString());
        }
        System.out.println("Printing animals:");

        for (Map.Entry<Integer, Animal> animal :
                animals.entrySet()){
            animal.getValue().animalSound();
            animal.getValue().sleep();
            System.out.println(animal.getValue().toString());
        }
        System.out.println("Printing animals:");
        
        Iterator<Integer> it = animals.keySet().iterator();
        while(it.hasNext())
        {
            int key=(int)it.next();
            animals.get(key).animalSound();
            animals.get(key).sleep();
            System.out.println(animals.get(key).toString());
        }


        System.out.println("retrieving by id:");
        System.out.println(animals.get(1));
        System.out.println(animals.get(2));
    }
}
