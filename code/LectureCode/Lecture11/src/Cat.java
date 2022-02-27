package LectureCode.Lecture11.src;

class Cat extends Animal {

    public Cat(int id) {
        super(id);
    }

    @Override
    public void animalSound() {
        System.out.println("The cat says: miaaauuu");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                '}';
    }
}
