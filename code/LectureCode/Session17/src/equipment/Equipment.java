package LectureCode.Session17.src.equipment;

public abstract class Equipment {
    private int equipId;
    private Locker location;
    private boolean replace;

    public Equipment(){
        this.replace = false;
    }

    public Equipment(int id){
        this.equipId = id;
    }

    public int getEquipId() {
        return equipId;
    }

    public Locker getLocation() {
        return location;
    }

    public void setLocation(Locker location) {
        this.location = location;
    }

    public boolean isReplace() {
        return replace;
    }

    public void setReplace(boolean replace) {
        this.replace = replace;
    }
}
