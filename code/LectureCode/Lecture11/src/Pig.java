package LectureCode.Lecture11.src;

class Pig extends Animal {

    public Pig(int id) {
        super(id);
    }

    @Override
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }

    @Override
    public String toString() {
        return "Pig{" +
                "id=" + id +
                '}';
    }
}
