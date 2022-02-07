package LectureCode.Session9;

public interface Animal {
    void makeSound();
}

abstract class Mammal implements Animal {
    String sound;

    Mammal(String sound) {
        this.sound = sound;
    }
}

class Dog extends Mammal {
    Dog() {
        super("Bjeff");
    }

    @Override
    public void makeSound() {
        System.out.println(this.sound);
    }
}

class Cat extends Mammal {
    Cat() {
        super("Meow");
    }

    @Override
    public void makeSound() {
        System.out.println(this.sound);
    }
}