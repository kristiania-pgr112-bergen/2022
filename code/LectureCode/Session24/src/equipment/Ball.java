package LectureCode.Session24.src.equipment;

import java.util.Random;

public class Ball extends Equipment{
    private boolean hasAir;
    private String type;

    public Ball(){
        this.type = "Handball";
        this.hasAir = false;
    }

    public Ball(int id){
        super(id);
        this.type = "Handball";
        this.hasAir = false;
    }

    public Ball(int id, String type){
        super(id);
        this.type = type;
        this.hasAir = false;
    }

    public boolean needsAir() {
        return hasAir;
    }

    public void setNeedsAir(boolean needsAir) {
        this.hasAir = needsAir;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /***
     *
     * @return one of the types randomly
     *
     * THis is only used for data generation, to make it easier for me to test.
     */
    public static String getRandomType(){
        String[] options = {"Handball", "Volleyball", "Football", "Basketball"};
        Random random = new Random();

        int index = random.nextInt(options.length);
        return options[index];

    }

    @Override
    public String toString(){
        return String.format("type is %s, hasAir is %b, location is %d", type, hasAir, getLocation().getId());
    }
}
