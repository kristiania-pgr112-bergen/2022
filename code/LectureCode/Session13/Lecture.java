package LectureCode.Session13;

import java.util.*;

public class Lecture {
    public static void main(String[] args) {
        ArrayList<Number> numbers = new ArrayList<>();

        Number[] tall = new Number[1];

        numbers.add(1);
        numbers.add(1.0f);
        numbers.add(1.0d);

        Value<Integer> X = new Value<>(1);
        Value<String> text = new Value<>("Text");

        CacheSet<String> cache1 = new CacheSet<>();
        CacheMap<String> cache2 = new CacheMap<>();

        cache1.add("test");
        cache2.add("test");

        //# Set = List of unique elements

        HashSet<String> listOfStrings = new HashSet<>();

        listOfStrings.add("Test 1 2 3");
        listOfStrings.add("Test 1 2 3 4");
        listOfStrings.add("Test 1 2 3 4 5");

        // Will not print the elements in the order they were inserted!
        listOfStrings.forEach((element) -> {
            System.out.println(element);
        });
    }
}

class Test {
    public static void main(String[] args) {
        CacheSet<String> users = new CacheSet<>();

        users.add("mada051");

        if (users.contains("mada051")) {
            System.out.println("That user is in the cache!");
        }

        //# HashMap
        HashMap<String, Integer> hashmap = new HashMap<>();
        hashmap.put("mada051", 123);

        System.out.println(hashmap.get("mada051"));
    }
}

interface ICache<T> {
    void add(T element);
    void remove(T element);
    boolean contains(T element);
}

class CacheMap<T> implements ICache<T> {
    private final HashMap<Integer, T> map = new HashMap<>();

    static private int counter = 0;

    public void add(T element) {
        this.map.put(CacheMap.counter ++, element);
    }

    public void remove(T element) {
        this.map.remove(element);
    }

    public boolean contains(T element) {
        return this.map.containsValue(element);
    }
}

class CacheSet<T> implements ICache<T> {
    private final HashSet<T> set = new HashSet<>();

    CacheSet() {}

    public void add(T element) {
        set.add(element);
    }

    public void remove(T element) {
        set.remove(element);
    }

    public boolean contains(T element) {
        return set.contains(element);
    }
}

class Value<T> {
    private T data;

    Value(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}
