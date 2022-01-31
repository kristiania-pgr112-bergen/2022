package LectureCode.Session7.examples;


public class Pizza {
    private final int slices;
    int taken = 0;

    Pizza(int slices) {
        this.slices = slices;

        System.out.printf("Created a pizza with %d slices!%n", this.getSlicesTotal());
    }

    int getSlicesTotal() {
        return this.slices;
    }

    int getSlicesTaken() {
        return this.taken;
    }

    int getSlicesLeft() {
        return this.getSlicesTotal() - this.getSlicesTaken();
    }

    boolean areThereSlicesLeft() {
        return this.taken < this.slices;
    }

    void takeSlice() {
        if (this.areThereSlicesLeft()) {
            this.taken ++;

            System.out.println("A pizza slice was taken!");
            this.printStatus();
        }
        else {
            System.out.println("There are no pizza slices left to take!");
        }
    }

    void printStatus() {
        System.out.printf("There are %d slices left!%n", this.getSlicesLeft());
    }

    public static void main(String[] args) {
        Pizza pizza = new Pizza(4);

        pizza.takeSlice();
        pizza.takeSlice();
        pizza.takeSlice();
        pizza.takeSlice();

        pizza.takeSlice();
    }
}
