package LectureCode.Session14.src;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable {
    private int age;
    private String name;

    /**
     * Getters/Setters
     */
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("age:%d, name:%s", age, name);
    }

    @Override
    public boolean equals(Object o) {
        if(o==this)
            return true;
        if(!(o instanceof LectureCode.Lecture11.src.Person))
            return false;
        if(o.getClass() != this.getClass())
            return false;
        /**
         * our own equality
         */
        Person person = (Person) o;
        return Objects.equals(age, person.age) &&
                Objects.equals(name, person.name);
    }

    @Override
    public  int hashCode() {
        return Objects.hash(age, name);
    }

}