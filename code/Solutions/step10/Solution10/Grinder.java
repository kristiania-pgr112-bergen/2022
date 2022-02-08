package Solutions.step10.Solution10;

public class Grinder {

    public GroundCoffee grind(CoffeeBean coffeeBean, CoffeeType coffeeType, double quantityCoffee) {
        System.out.println(String.format("You have chosen bean type %s, bean quantity %f to make a %s with coffee quantity %f",
                coffeeBean.getBeanType(), coffeeBean.getQuantity(), coffeeType, quantityCoffee));
        return new GroundCoffee(quantityCoffee);
    }
}
