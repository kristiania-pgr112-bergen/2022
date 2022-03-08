package Solutions.step14codebasis.src;

import java.util.Objects;

public class Customer {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Customer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Task 1. Overriding toString, equals and hashCode
     */

}