package LectureCode.Lecture11.src;

import java.io.Serializable;
import java.util.Objects;


public class Person implements Serializable {
    private int age;
    private String name;
    private Address address;
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
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person() {
    }

    public Person(int age, String name, Address address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("age:%d, name:%s, address:%s", age, name, address.toString());
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Person))
            return false;
        // type check and cast
        if (this.getClass() != o.getClass())
            return false;
        Person other = (Person)o;
        return Objects.equals(age, other.age)
                && Objects.equals(name, other.name)
                && Objects.equals(address, other.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, address);
    }
}

/*    boolean nameEquals = (this.name == null && other.name == null)
            || (this.name != null && this.name.equals(other.name));
        return this.age == other.age && nameEquals;*/



