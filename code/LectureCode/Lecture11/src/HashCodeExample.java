package LectureCode.Lecture11.src;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HashCodeExample {
    public void run() {
        Person person = new Person(20, "Joe Doe", new Address("street1", "5000"));
        Person person2 = new Person(20, "Joe Doe", new Address("street1", "5000"));
        boolean isEqual = person.equals(person2);
        System.out.println(isEqual);
        /**
         * here person and person2 have different hashCode
         */
        System.out.println(person.hashCode());
        System.out.println(person2.hashCode());


        Map<Person,String> leaders = new HashMap<>();
        leaders.put(new Person(20, "Tom", new Address("street1", "5000")), "Tom");
        leaders.put(new Person(20, "Jerry", new Address("street2", "5300")), "Jerry");
        Person myPerson = new Person(20, "Tom", new Address("street1", "5000"));
        String leaderName = leaders.get(myPerson);
        System.out.println(leaderName);
    }
}
