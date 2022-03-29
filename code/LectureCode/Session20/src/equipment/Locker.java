package LectureCode.Session20.src.equipment;

public class Locker {
    private int id = -1;
    private String location;
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    @Override
    public String toString(){
        return String.format("id is %d, location is %s", getId(), getLocation());
    }
}
