package LectureCode.Session7.examples;

import java.util.ArrayList;

public class Bottle {
    /** Max volume this bottle can contain */
    float volume;
    ArrayList<Liquid> liquid = new ArrayList<>();

    Bottle(float volume) {
        this.volume = volume;
    }

    /** Get total volume of all liquid combined */
    float getLiquidVolume() {
        float output = 0.0f;

        for (Liquid liquid : this.liquid) {
            output += liquid.getVolume();
        }

        return output;
    }

    void addLiquid(Liquid liquid) {
        if (this.volume >= liquid.getVolume() + this.getLiquidVolume()) {
            this.liquid.add(liquid);
        }
        else {
            System.out.println("The bottle can not contain more liquid!");
        }
    }

    boolean isFull() {
        return this.getLiquidVolume() == this.volume;
    }

    public static void main(String[] args) {
        Bottle bottle = new Bottle(1.5f);

        Liquid water = new Liquid("Water", 1.0f);
        Liquid syrup = new Liquid("Syrup", 0.5f);

        bottle.addLiquid(water);
        bottle.addLiquid(syrup);

        if (bottle.isFull()) {
            System.out.println("The bottle is completely full!");
        }
        else {
            System.out.println("The bottle is not full yet!");
        }
    }
}

class Liquid {
    String name;
    float volume;

    Liquid(String name, float volume) {
        this.name = name;
        this.volume = volume;
    }

    float getVolume() {
        return this.volume;
    }
}