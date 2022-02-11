package Solutions.step10.CoffeeMaker;

public class Grinder {
    public GroundCoffee grind(CoffeeType coffeeType, double quantityCoffee) {
        System.out.println(String.format("You have chosen to make a %s with coffee quantity %f",
                coffeeType, quantityCoffee));
        return new GroundCoffee(quantityCoffee);
    }
}
