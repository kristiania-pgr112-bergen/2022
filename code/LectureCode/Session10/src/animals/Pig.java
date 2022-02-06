package LectureCode.Session10.src.animals;


class Pig extends Mammal {
    public static void regulateBodyHeat(){
        System.out.println("Change in temp. " +
                "Regulating body heat of a pig.");
    }
    protected int numberOfLegs;
    public Pig(int id){
        super(id);
    }

    @Override
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("The pig says: wee wee");
    }

    @Override
    public void provideMilkForBaby() {
        System.out.println("Providing milk through one of my 10-14 teats.");
    }

    @Override
    public String toString() {
        return "Pig{" +
                "id=" + id +
                '}';
    }
    @Override
    public void MammalActivities(){
        regulateBodyHeat();
        animalSound();
    }
    public void pigActivity() {
        System.out.println("The pig is smart");
    }

}
