package LectureCode.Lecture11.src;

abstract class Animal {
    int id;

    public Animal(int id) {
        this.id = id;
    }

    // Abstract method (does not have a body)
    public abstract void animalSound();

    // Regular method
    public void sleep() {
        System.out.println("Zzz");
    }
}
