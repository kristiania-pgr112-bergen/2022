package LectureCode.Session9;

public abstract class Polygon {
    int corners;

    Polygon(int corners) {
        this.corners = corners;
    }

    void display() {
        System.out.println("Display Polygon: " + this.corners);
    }

    public static void main(String[] args) {
        Polygon square = new Square();
        Polygon triangle = new Triangle();

        square.display();
        triangle.display();
    }
}


class Square extends Polygon {
    Square() {
        super(4);
    }

    @Override
    void display() {
        super.display();

        // Code here should be specific to squares
        System.out.println("Display Square");
    }
}

class Triangle extends Polygon {
    Triangle() {
        super(3);
    }

    @Override
    void display() {
        super.display();

        System.out.println("Display Triangle");
    }
}
