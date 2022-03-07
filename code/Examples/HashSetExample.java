package Examples;

import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        // Create a HashSet of strings
        HashSet<String> setOfStrings = new HashSet<>();

        // Add elements to the set
        setOfStrings.add("foo");
        setOfStrings.add("bar");
        setOfStrings.add("baz");

        // Remove elements from the set
        setOfStrings.remove("bar");

        // if set contains baz, remove foo
        if (setOfStrings.contains("baz")) {
            setOfStrings.remove("foo");
        }

        // if size of set is 1, clear it
        if (setOfStrings.size() == 1) {
            setOfStrings.clear();
        }

        // if the set is empty, add foo
        if (setOfStrings.isEmpty()) {
            setOfStrings.add("foo");
        }
    }
}
