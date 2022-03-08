package LectureCode.Session14.src;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class OptionalExample {
    private final Set<Person> persons = new HashSet<>();

    public boolean ageIsValid(Person person) {
        boolean isvalid = false;

        if (person != null
                && (person.getAge() >= 10
                && person.getAge() <= 15)) {
            isvalid = true;
        }
        return isvalid;
    }
    public boolean ageIsValid2(Person person) {
        return Optional.ofNullable(person)
                .map(Person::getAge)
                .filter(a -> a >= 10)
                .filter(a -> a <= 15)
                .isPresent();
    }

    public Optional<Integer> ageIsValid3(Person person) {
        return Optional.ofNullable(person)
                .map(Person::getAge)
                .filter(a -> a >= 10)
                .filter(a -> a <= 15);
    }

    public Optional<Person> getPerson(String name) {
        for (Person p :
                persons) {
            if (p.getName().equalsIgnoreCase(name)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public void addPerson(Person person) {
        Optional<Integer> ageIsValid = ageIsValid3(person);
        if(ageIsValid.isPresent()){
            persons.add(person);
        }
    }

    public void run() {
        /**
        add person
         */
        addPerson(new Person(12, "Tom"));
        addPerson(new Person(20, "Jerry"));
        addPerson(null);
        /**
         * print out each person
         */
        persons.forEach(System.out::println);
        /**
         * get person by name
         */
        Optional<Person> person = getPerson("Test user");
        if(person.isPresent()){
            System.out.println("you found me");
        }else{
            System.out.println("Nothing was found");
        }
    }
}
