package Solutions.step9;

public class MovablePoint implements Movable {
    private double x = 0;
    private double y = 0;

    MovablePoint() {}

    MovablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp(double distance) {
        this.y += distance;
    }

    public void moveDown(double distance) {
        this.y -= distance;
    }

    public void moveLeft(double distance) {
        this.x -= distance;
    }

    public void moveRight(double distance) {
        this.x += distance;
    }

    public String toString() {
        return String.format("MovablePoint[x=%f, y=%f]", this.x, this.y);
    }
}
