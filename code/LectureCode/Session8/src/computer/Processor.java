package LectureCode.Session8.src.computer;

abstract public class Processor {
    protected String model;

    public Processor(String model) {
        this.model = model;
    }
    abstract public String toString();
}

