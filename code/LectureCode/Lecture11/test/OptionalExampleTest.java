package LectureCode.Lecture11.test;
import LectureCode.Lecture11.src.Address;
import LectureCode.Lecture11.src.Person;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalExampleTest {
    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
        assertTrue(empty.isEmpty());
    }
    @Test
    public void givenNonNull_whenCreatesNonNullable_thenCorrect() {
        String name = "Høyskolen Kristiania";
        Optional<String> opt = Optional.of(name);
        assertTrue(opt.isPresent());
    }
    @Test(expected = NullPointerException.class)
    public void givenNull_whenCreatesNonNullable_thenException() {
        String name = null;
        Optional<String> opt = Optional.of(name);
    }
    @Test
    public void givenNonNull_whenCreatesNullable_thenCorrect() {
        String name = "Høyskolen Kristiania";
        Optional<String> opt = Optional.ofNullable(name);
        assertTrue(opt.isPresent());
    }
    @Test
    public void givenNull_whenCreatesNullable_thenCorrect() {
        String name = null;
        Optional<String> opt = Optional.ofNullable(name);
        assertFalse(opt.isPresent());
    }
    @Test
    public void givenOptional_whenIfPresentWorks_thenCorrect() {
        Optional<String> opt = Optional.of("Høyskolen Kristiania");
        /**
         * lambda function here: name -> System.out.println(name.length())
         */
        opt.ifPresent(name -> System.out.println(name.length()));
    }
    @Test
    public void whenOrElseWorks_thenCorrect() {
        String nullName = null;
        /**
         * returns the wrapped value if it is present, and its argument as default otherwise
         */
        String name = Optional.ofNullable(nullName).orElse("Høyskolen Kristiania");
        assertEquals("Høyskolen Kristiania", name);

    }
    public String getMyDefault() {
        System.out.println("Getting Default Value");
        return "Høyskolen Kristiania";
    }
    @Test
    public void whenOrElseGetWorks_thenCorrect() {
        String nullName = null;
        /**
         * lambda function here:() -> "Høyskolen Kristiania"
         */
        String name = Optional.ofNullable(nullName).orElseGet(() -> "Høyskolen Kristiania");
        assertEquals("Høyskolen Kristiania", name);
        /**
         * or take functional interface this::getMyDefault as argument and invoked it
         */
        String name2 = Optional.ofNullable(nullName).orElseGet(this::getMyDefault);
        assertEquals("Høyskolen Kristiania", name2);
    }

    @Test
    public void givenOptional_whenGetsValue_thenCorrect() {
        Optional<String> opt = Optional.of("Høyskolen Kristiania");
        String name = opt.get();
        assertEquals("Høyskolen Kristiania", name);
    }

    @Test(expected = NoSuchElementException.class)
    public void givenOptionalWithNull_whenGetThrowsException_thenCorrect() {
        Optional<String> opt = Optional.ofNullable(null);
        String name = opt.get();
    }
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
    @Test
    public void whenFiltersWithOptional_thenCorrect() {
        assertTrue(ageIsValid(new Person(12, "Tom", new Address("street1", "5000"))));
        assertFalse(ageIsValid2(new Person(20, "Jerry", new Address("street2", "3330"))));
        assertFalse(ageIsValid2(null));
    }

}
