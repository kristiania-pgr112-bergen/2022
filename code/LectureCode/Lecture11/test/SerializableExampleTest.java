package LectureCode.Lecture11.test;

import LectureCode.Lecture11.src.Person;

import java.io.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        assertEquals(person2.getAge(), person.getAge());
        assertEquals(person2.getName(), person.getName());
        assertNotEquals(person2, person);
    }
}
