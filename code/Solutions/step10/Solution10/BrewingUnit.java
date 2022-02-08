package Solutions.step10.Solution10;

public class BrewingUnit {
    public Coffee brew(CoffeeType coffeeType, GroundCoffee groundCoffee,
                       double quantityWater) {
        System.out.println(String.format("You have used %f ground coffee, adding %f water, to make coffee type %s of total quantity %f",
                groundCoffee.getQuantity(), quantityWater, coffeeType, groundCoffee.getQuantity() + quantityWater));

        return new Coffee(coffeeType, groundCoffee.getQuantity() + quantityWater);
    }
}
