package Solutions.step11.src;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Program {

    // Assignment 2
    private final Set<Person> persons = new HashSet<>();

    public void checkInitialCode() {
        System.out.println(new Person(20, "Anton Antonsen"));
    }

    // Assignment 2
    public void addTwoPersons() {
        persons.add(new Person(20, "Anton Antonsen"));
        persons.add(new Person(20, "Anton Antonsen"));
        System.out.println(persons);
        // You see that both objects are present in the set...
    }

    // Assignment 4
    public Optional<Person> getSamplePerson(String name) {
        for (Person p :
                persons) {
            if (p.getName().equalsIgnoreCase(name)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    /*Assignment 5. Look how I describe possible exception in JavaDoc.
    That is considered a better approach than defining the method to
    throw the runtime exception in the method signature
    (public void addPerson(Person p) throws IllegalArgumentException)
     */

    /**
     * Adding person to set of persons
     *
     * @param p the person to add
     * @throws IllegalArgumentException if p is null, p.age < 0 or p.name is null
     */
    public void addPerson(Person p) {
        validatePerson(p);
        persons.add(p);
    }

    /*
    I think addPerson is more readable if I delegate the validation to
    a separate helper method like this. Agree?
     */
    private void validatePerson(Person p) {
        if (p == null) {
            throw new IllegalArgumentException("Null input when Person excepted");
        }
        if (p.getAge() < 0) {
            throw new IllegalArgumentException("Please ensure valid age (>0) when adding person");
        }
        if (p.getName() == null) {
            throw new IllegalArgumentException("Please ensure valid name (not null) when adding person");
        }
    }

    //Assignment 6, part 1
    public void addTenPersons() {
        persons.add(new Person(20, "Jens Jensen"));
        persons.add(new Person(19, "Anders Andersen"));
        persons.add(new Person(17, "Julie Jensen"));
        persons.add(new Person(25, "Magne Breivoll"));
        persons.add(new Person(29, "Anne Anka"));
        persons.add(new Person(30, "Margrethe Munthe"));
        persons.add(new Person(33, "Oda Odasen"));
        persons.add(new Person(33, "Lars Larsen"));
        persons.add(new Person(99, "Jenny Jensen"));
        persons.add(new Person(2, "Baby Doc"));
    }

    //Assignment 6, part 2. Standard solution
    public Set<Person> getPersonsByAge(int age) {
        Set<Person> personsToReturn = new HashSet<>();
        for (Person p :
                persons) {
            if (p.getAge() > age) {
                personsToReturn.add(p);
            }
        }
        return personsToReturn;
    }

    //Assignment 6, part 2. Fancier approach (not on pensum:-)
    public Set<Person> getPersonsByAgeAlternative(int age) {
        return persons.stream().filter(p->p.getAge()>age).collect(Collectors.toSet());
    }

    // Assignment 7. Open assignment, so no solution:)
}
