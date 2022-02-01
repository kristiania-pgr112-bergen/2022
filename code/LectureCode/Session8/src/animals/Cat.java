package LectureCode.Session8.src.animals;


public class Cat extends Mammal{

    public Cat(int id){
        super(id);
    }
    @Override
    public void provideMilkForBaby() {
        System.out.println("Providing milk through one of my 6-11 teats.");
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
    public void CatActivities(){
        super.regulateBodyHeat();
        animalSound();
    }
}
