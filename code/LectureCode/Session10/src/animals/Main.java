package LectureCode.Session10.src.animals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /**
         * Create a Mammal object, and the reference variable of Parent class refers to the object of Child class.
         * It is known upcasting
         */
        Mammal myPig = new Pig(1);
        myPig.animalSound();
        myPig.sleep();
        myPig.provideMilkForBaby();
        myPig.regulateBodyHeat();
        myPig.MammalActivities();
        /**
         * myPig can not call pigActivity, why?
         * Because at compile time, the system only knows about it is a Mammal object
         * Only those overriden methods defined in Mammal object are accessible
         */
        //myPig.pigActivity();
        /**
         * myPig instance is not able to access variable of Pig class since it has been
         * upcasted to Mammal class
         */
        //System.out.println(myPig.numberOfLegs);
        /**
         * now we are downcasting
         * newPig instance can access methods and variables provided by Pig class now
         */
        Pig newPig = (Pig) myPig;
        System.out.println(newPig.numberOfLegs);
        newPig.pigActivity();
        newPig.MammalActivities();

        /**
         * Create an Animal object, and the reference variable of Parent class refers to the object of Child class.
         * It is known upcasting
         */
        Animal cat = new Cat(2);
        /**
         * at compiler time, the system does not know abstract method animalSound is not implemented
         * but at runtime, here is the error: java: LectureCode.Session10.src.animals.Cat is not abstract and does not
         * override abstract method animalSound() in LectureCode.Session10.src.animals.Animal
         */
        cat.animalSound();
        cat.sleep();
        /**
         * provideMilkForBaby and regulateBodyHeat are defined in Mammal while not animal
         * so the compiler does not know about these two methods
         */
/*        cat.provideMilkForBaby();
        cat.regulateBodyHeat();*/

        /**
         * multi-level polymorphism
         * here MainecoonBabyCat does not override catActivity(), so
         * the method in its immediate parent class BabyCat is called
         */
        Cat cat1, cat2, cat3;
        cat1 = new Cat(101);
        cat2 = new BabyCat(102);
        cat3 = new MainecoonBabyCat(103);
        Animal myanimal = cat3;
        Object myobject = cat2;
        cat1.catActivity();
        cat2.catActivity();
        cat3.catActivity();
        /**
         * data member is not overriden, but method does
         */
        System.out.println("The weight of a MainecoonBabyCat is " + cat3.weight);

        /**
         * it is possible to access sub class method but not super class method
         */
        BabyCat babyCat = new MainecoonBabyCat(200);
        babyCat.printBabyCat();
        /**
         * runtime error: class LectureCode.Session10.src.animals.BabyCat cannot be cast
         * to class LectureCode.Session10.src.animals.MainecoonBabyCat
         */
/*        MainecoonBabyCat mainecoonBabyCat = (MainecoonBabyCat) new BabyCat(100);
        mainecoonBabyCat.printBabyCat();
        mainecoonBabyCat.printMainecoonBabyCat();*/
        /**
         * this is the right way to do downcasting.
         * You first do upcasting, then downcasting         *
         */
        MainecoonBabyCat mainecoonBabyCat2 = (MainecoonBabyCat) babyCat;
        mainecoonBabyCat2.printBabyCat();
        mainecoonBabyCat2.printMainecoonBabyCat();

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
