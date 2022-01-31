package LectureCode.Session7.examples;

import java.util.ArrayList;

public class Coin {
    private final int value;

    Coin(int value) {
        this.value = value;
    }

    int getValue() {
        return this.value;
    }

    //# When Coin is run as an application ...
    public static void main(String[] args) {
        // Create a few coins and play around
        Coin copper = new Coin(1);
        Coin silver = new Coin(10);
        Coin gold = new Coin(100);

        ArrayList<Coin> pouch = new ArrayList<>();

        pouch.add(gold);
        pouch.add(silver);
        pouch.add(silver);
        pouch.add(copper);
        pouch.add(copper);
        pouch.add(copper);

        //# Total value of coins within pouch
        int total = 0;

        for (Coin coin : pouch) {
            total += coin.getValue();
        }

        System.out.printf("Total: %d%n", total);
    }
}
