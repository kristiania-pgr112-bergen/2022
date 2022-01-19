package LectureCode.step4.src.org.pgr112.lecture;

public enum Campus {
    BERGEN("Hansa Bryggen"), OSLO("Kirkegata");


    private String location;

    Campus(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }
}
