package Examples;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer, String> phoneBook = new HashMap<>();

        // Remember, we can use underscores to
        // split up our numbers for readability,
        // for example phone numbers or any number that are rather larger,
        // for example:
        // int oneMillion = 1_000_000;

        // HashMap is a key value store, meaning that
        // values are added mapped to a specific key
        phoneBook.put(41_41_81_53, "Marcus Alexander Dahl");
        phoneBook.put(22_59_60_00, "Høyskolen Kristiania");

        // Using that key we can retrieve data:
        int phone = 41418153;
        System.out.printf("The owner of the phone number %d is %s%n", phone, phoneBook.get(phone));
    }
}
