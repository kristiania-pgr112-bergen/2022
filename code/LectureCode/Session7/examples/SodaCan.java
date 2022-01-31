package LectureCode.Session7.examples;

public class SodaCan {
    private boolean open = false;

    boolean isOpen() {
        return this.open;
    }

    void open() {
        if (!this.isOpen()) {
            this.open = true;
        }
    }
}
