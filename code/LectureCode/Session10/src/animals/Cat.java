package LectureCode.Session10.src.animals;


public class Cat extends Mammal{
    public String weight = "0.5kg";

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
    @Override
    public void MammalActivities(){
        regulateBodyHeat();
        animalSound();
    }
    public void catActivity() {
        System.out.println("The cat can chase a mouse");
    }

    public static void regulateBodyHeat(){
        System.out.println("Change in temp. Regulating body heat of a cat.");
    }
}
