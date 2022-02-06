package LectureCode.Session10.src.animals;


public abstract class Mammal extends Animal{

    public Mammal(int id){
        super(id);
    }

    public static void regulateBodyHeat(){
        System.out.println("Change in temp. " +
                "Regulating body heat.");
    }
    public abstract void provideMilkForBaby();
    public void MammalActivities(){
        regulateBodyHeat();
    }
}
