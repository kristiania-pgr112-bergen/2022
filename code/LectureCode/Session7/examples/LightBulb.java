package LectureCode.Session7.examples;

public class LightBulb {
    private boolean state = false;

    void turnOn() {
        this.state = true;
    }

    void turnOff() {
        this.state = false;
    }

    void toggle() {
        this.state = !this.state;
    }
}
