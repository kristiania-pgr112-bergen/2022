package LectureCode.Lecture17.src.equipments;

public class Locker {
    private int id;
    private String location;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return String.format("id=%d, location=%s, address=%s", id, location, address);
    }
}
