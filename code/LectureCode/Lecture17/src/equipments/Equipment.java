package LectureCode.Lecture17.src.equipments;

public class Equipment {
    private int id;
    private int needsAir;
    private Locker location;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNeedsAir() {
        return needsAir;
    }

    public void setNeedsAir(int needsAir) {
        this.needsAir = needsAir;
    }

    public Locker getLocation() {
        return location;
    }

    public void setLocation(Locker location) {
        this.location = location;
    }
}
