package Solutions.step10.Solution10;

import java.util.ArrayList;
import java.util.Map;

public class PremiumCoffeemaker extends BasicCoffeeMaker{
    public PremiumCoffeemaker(Map<BeanType, CoffeeBean> beanContainer, Map<CoffeeType, Map<BeanType, CoffeeBean>> beans) {
        super(beanContainer, beans);
        this.configMap.put(CoffeeType.Filter, new CoffeeConfiguration(30, 180));
        this.configMap.put(CoffeeType.Espresso, new CoffeeConfiguration(30, 30));
        this.configMap.put(CoffeeType.Americano, new CoffeeConfiguration(30, 100));
    }

    @Override
    public Coffee brewCoffee(CoffeeType coffeeType, BeanType beanType) throws CoffeeException {
        switch (coffeeType) {
            case Espresso:
                return brewEspresso(beanType);
            case Americano:
                return brewAmericano(beanType);
            default:
                return super.brewCoffee(coffeeType, beanType);
        }
    }

    private Coffee brewEspresso(BeanType beanType) throws CoffeeException {
        CoffeeConfiguration config = configMap.get(CoffeeType.Espresso);

        // grind the coffee beans
        CoffeeBean coffeeBean = this.beans.get(CoffeeType.Espresso).get(beanType);

        super.addBeans(beanType, coffeeBean);
        GroundCoffee groundCoffee = this.grinder.grind(coffeeBean, CoffeeType.Espresso, config.getQuantityCoffee());

        // brew an Espresso coffee
        return this.brewingUnit.brew(CoffeeType.Espresso, groundCoffee, config.getQuantityWater());
    }

    private Coffee brewAmericano(BeanType beanType) throws CoffeeException {
        CoffeeConfiguration config = configMap.get(CoffeeType.Americano);

        // grind the coffee beans
        CoffeeBean coffeeBean = this.beans.get(CoffeeType.Americano).get(beanType);

        super.addBeans(beanType, coffeeBean);
        GroundCoffee groundCoffee = this.grinder.grind(coffeeBean, CoffeeType.Americano, config.getQuantityCoffee());

        // brew an Americano coffee
        return this.brewingUnit.brew(CoffeeType.Americano, groundCoffee, config.getQuantityWater());
    }

}
