package Solutions.step10.CoffeeMaker;

public class CoffeeConfiguration {
    private double quantityCoffee;
    private double quantityWater;

    public CoffeeConfiguration(double quantityCoffee, double quantityWater) {
        this.quantityCoffee = quantityCoffee;
        this.quantityWater = quantityWater;
    }

    public double getQuantityCoffee() {
        return quantityCoffee;
    }

    public void setQuantityCoffee(double quantityCoffee) {
        this.quantityCoffee = quantityCoffee;
    }

    public double getQuantityWater() {
        return quantityWater;
    }

    public void setQuantityWater(double quantityWater) {
        this.quantityWater = quantityWater;
    }
}
