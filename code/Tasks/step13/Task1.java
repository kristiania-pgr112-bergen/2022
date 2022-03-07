package Tasks.step13;

/*
 *  It is recommended to copy this Java-code into your own Java, for example as a new project in IntelliJ,
 *  and adjust the package above to match your file structure.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Task1 {
    public static void main(String[] args) {
        /*
            In this task you will implement several variations on a PhoneBook-class
            which keeps track of your contacts.

            You will make three classes using the different data structures below:

            ArrayList
                - Uses an array so elements are stored in order
                - Indexed the same way as arrays, easy to loop through
                - Dynamic sizing, this class will handle the size of the array for you

            HashMap
                - Uses a dictionary (values are mapped to a key)
                - Indexed using the key, so easy to retrieve values if you know the key

            HashSet
                - Only contains unique elements, no duplicates
                - A generic collection of unique elements
                - Cannot expect to be read out in order, for example when looping over values

            All of these are different data structures, where ArrayList<E> and HashSet<E> expects one type which tells
            us the _data type of each element within the Collection_, while HashMap<K, V> expects two types,
            one for the key and one for the value within the Map.

            ---

            Part 1)

            The task is as follows: For each data structure (ArrayList<E>, HashSet<E> and HashMap<K, V>) finish
            the implementation below in the respective class.

            The Contact-class is already made for you, and can be used to represent each contact within your
            PhoneBook-class.

            You should at least have the following functionality per PhoneBook*-class:

            - Method for adding contacts
            - Method for removing contacts
            - Method to list all contacts
            - Method to check if contact already exists
            - Method to import all contacts from another PhoneBook

        */
    }
}

/*
    Part 2)

        Are you able to create one interface which all the PhoneBook* classes can implement?

*/
interface IPhoneBook {
}

/**
 * PhoneBook implementation using ArrayList to store contacts
 */
class PhoneBookArrayList {
    ArrayList<Contact> contacts = new ArrayList<>();

    PhoneBookArrayList() {}
}

/**
 * PhoneBook implementation using HashMap to store contacts
 */
class PhoneBookHashMap {
    HashMap<Integer, Contact> contacts = new HashMap<>();

    PhoneBookHashMap() {}
}

/**
 * PhoneBook implementation using HashSet to store contacts
 */
class PhoneBookHashSet {
    HashSet<Contact> contacts = new HashSet<>();

    PhoneBookHashSet() {}
}

/**
 * Represents a contact within a phone book.
 *
 * Each contact has a number and a name, with an optional email.
 */
class Contact {
    private int number;
    private String name;
    private String email = null;

    Contact(int number, String name, String email) {
        this(number, name);

        this.email = email;
    }

    Contact(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }
}
