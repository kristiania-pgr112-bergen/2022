package Solutions.step14.src;

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
    @Override
    public String toString() {
        return String.format("Customer info: name is %s, age is %d",
                name, age);
    }
    //Assignment 3. Overriding equals (inherited from Object)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return name == customer.name &&
                age == customer.age ;
    }

    //Assignment 3. When overriding equals, we must also override hashCode (also from Object)
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
