package LectureCode.Session4.src.extra;
public enum Genre {
    CRIME("CRIME"), ACTION("ACTION"), FANTASY("FANTASY"),
    CLASSIC("CLASSIC"), OTHER("OTHER");
    private String name;
    /**
     * Enum can contain a construtor
     * @param name
     */
    Genre(String name) {
        this.name = name;
    }
    /**
     * Enum can contain methods
     * @return
     */
    public String getModifiedName() {
        return "Category-"+this.name;
    }
}
