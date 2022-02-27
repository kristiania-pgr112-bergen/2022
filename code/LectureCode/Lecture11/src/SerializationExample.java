package LectureCode.Lecture11.src;

import java.io.*;

public class SerializationExample {
    public void run() throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setAge(20);
        person.setName("Joe Doe");
        person.setAddress(new Address("street1", "5000"));
        FileOutputStream fileOutputStream = new FileOutputStream("person.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(person);
        objectOutputStream.flush();
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("person.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Person person2= (Person) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(person2);
        boolean isEqual = person.equals(person2);
        System.out.println(isEqual);
    }
}
