package Solutions.step10.CoffeeMaker;

import java.util.Map;

public class PremiumCoffeeMaker extends BasicCoffeeMaker{
    public PremiumCoffeeMaker() {
        super();
        this.configMap.put(CoffeeType.Filter, new CoffeeConfiguration(30, 180));
        this.configMap.put(CoffeeType.Espresso, new CoffeeConfiguration(30, 30));
        this.configMap.put(CoffeeType.Americano, new CoffeeConfiguration(30, 100));
    }

    @Override
    public Coffee brewCoffee(CoffeeType coffeeType) throws CoffeeException {
        switch (coffeeType) {
            case Espresso:
                return brewEspresso();
            case Americano:
                return brewAmericano();
            default:
                return super.brewCoffee(coffeeType);
        }
    }

    private Coffee brewEspresso() throws CoffeeException {
        CoffeeConfiguration config = configMap.get(CoffeeType.Espresso);

        // grind the coffee beans
        GroundCoffee groundCoffee = this.grinder.grind(CoffeeType.Espresso, config.getQuantityCoffee());

        // brew an Espresso coffee
        return this.brewingUnit.brew(CoffeeType.Espresso, groundCoffee, config.getQuantityWater());
    }

    private Coffee brewAmericano() throws CoffeeException {
        CoffeeConfiguration config = configMap.get(CoffeeType.Americano);

        // grind the coffee beans
        GroundCoffee groundCoffee = this.grinder.grind(CoffeeType.Americano, config.getQuantityCoffee());

        // brew an Americano coffee
        return this.brewingUnit.brew(CoffeeType.Americano, groundCoffee, config.getQuantityWater());
    }

}
