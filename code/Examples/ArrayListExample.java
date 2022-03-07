package Examples;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        //# add elements
        arrayList.add(1);
        arrayList.add(2);

        //# remove elements
        arrayList.remove(1);

        //# loop through elements
        for (Number element : arrayList) {
            System.out.println(element);
        }

        arrayList.forEach(System.out::println);
    }

}