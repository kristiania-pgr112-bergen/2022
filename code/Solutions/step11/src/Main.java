package Solutions.step11.src;

import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Program p = new Program();
        p.addTwoPersons();
        // Assignment 4. Testing getting existing person
        Optional<Person> person = p.getSamplePerson("Anton Antonsen");
        if(person.isPresent()){
            System.out.println("A person found:)");
        }else{
            System.out.println("Strange. Expecting Anton to be present!");
        }
        // Assignment 4. Testing getting non-existing person
        // Look how I reuse the object reference person
        person = p.getSamplePerson("Tulle Tullebukk");
        if(person.isPresent()){
            System.out.println("What?!? How could I possibly find Tullebukk?");
        }else{
            System.out.println("As I though: Tullebukk not found");
        }
        // Assignment 5. Trying to add invalid person
        try{
            p.addPerson(new Person(12, null));
        } catch(IllegalArgumentException iae){
            System.out.println("Catching IAE as expected:)");
        }

        // Assignment 5. Trying to add valid person
        try{
            p.addPerson(new Person(12, "Kasper Kaspersen"));
        } catch(IllegalArgumentException iae){
            System.out.println("What?!? Why was this exception thrown?!?");
        }

        //Assignment 6
        p.addTenPersons();
        Set<Person> persons = p.getPersonsByAge(20);
        System.out.println("People found above 20:");
        for (Person pers :
                persons) {
            System.out.println(pers);
        }
        //Assignment 6, fancy
        persons = p.getPersonsByAgeAlternative(20);
        // fancier way of printing the information:
        System.out.println("People found above 20 using fancier approach:");
        persons.forEach(System.out::println); // using forEach and method referencing (not pensum)
    }
}
