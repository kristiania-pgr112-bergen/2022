package Solutions.step10.Solution10;

public class Coffee {
    private CoffeeType type;

    private double quantity;

    public Coffee(CoffeeType type, double quantity) {
        this.type = type;
        this.quantity = quantity;
    }

    public CoffeeType getType() {
        return type;
    }

    public void setType(CoffeeType type) {
        this.type = type;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
