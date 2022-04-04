package LectureCode.Session24.src.equipment;

import LectureCode.Session14.src.Person;

import java.util.Objects;

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

    public boolean equals(Object o) {
        if(o==this)
            return true;
        if(!(o instanceof Locker))
            return false;
        if(o.getClass() != this.getClass())
            return false;
        /**
         * our own equality
         */
        Locker locker = (Locker) o;
        return Objects.equals(id, locker.id) &&
                Objects.equals(location, locker.location);
    }

    @Override
    public  int hashCode() {
        return Objects.hash(id, location);
    }
}
