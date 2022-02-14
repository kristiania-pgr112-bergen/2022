package Solutions.step10.CoffeeMaker;

import java.util.ArrayList;
import java.util.Map;

public class BasicCoffeeMaker extends AbstractCoffeeMaker{
    protected Grinder grinder;
    protected BrewingUnit brewingUnit;

    public BasicCoffeeMaker(){
        super();
        this.configMap.put(CoffeeType.Filter, new CoffeeConfiguration(30, 180));
        this.grinder = new Grinder();
        this.brewingUnit = new BrewingUnit();
    }
    @Override
    public Coffee brewCoffee(CoffeeType coffeeType) throws CoffeeException {
        switch (coffeeType)  {
            case Filter:
                return brewFilterCoffee();

            default:
                throw new CoffeeException("Coffee type ["+coffeeType+"] not supported!");
        }
    }
    public ArrayList<Coffee> brewCoffee(CoffeeType coffeeType, int number) throws CoffeeException {
        ArrayList<Coffee> coffees = new ArrayList<>(number);
        for (int i=0; i<number; i++) {
            coffees.add(brewCoffee(coffeeType));
        }
        return coffees;
    }

    private Coffee brewFilterCoffee() throws CoffeeException {
        CoffeeConfiguration config = configMap.get(CoffeeType.Filter);
        // grind the coffee beans
        GroundCoffee groundCoffee = this.grinder.grind(CoffeeType.Filter, config.getQuantityCoffee());

        // brew a filter coffee
        return this.brewingUnit.brew(CoffeeType.Filter, groundCoffee, config.getQuantityWater());
    }
}
