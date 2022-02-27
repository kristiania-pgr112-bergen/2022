package LectureCode.Lecture11.test;

import LectureCode.Lecture11.src.Person;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SerializableExampleTest {
    @Test
    public void serializable_deserializable_objectIsTheSame() throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setAge(20);
        person.setName("Joe Doe");
        FileOutputStream fileOutputStream = new FileOutputStream("person.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("person.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person person2= (Person) objectInputStream.readObject();
        objectInputStream.close();

        assertTrue(person2.getAge() == person.getAge());
        assertTrue(person2.getName().equals(person.getName()));
        assertFalse(person2.equals(person));
    }
}
