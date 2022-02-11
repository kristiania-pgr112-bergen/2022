package Solutions.step10.CoffeeMaker;

public class Coffee {
    private CoffeeType type;

    private double quantity;

    public Coffee(CoffeeType type, double quantity) throws CoffeeException {
        this.type = type;
        this.quantity = quantity;
        if(quantity<0) throw new CoffeeException();
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
