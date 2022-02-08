package Solutions.step10.Solution10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BasicCoffeeMaker extends AbstractCoffeeMaker{
    protected Map<CoffeeType, Map<BeanType, CoffeeBean>> beans;
    protected Map<BeanType, CoffeeBean> beanContainer;
    protected Grinder grinder;
    protected BrewingUnit brewingUnit;
    protected double maxBeanQuantity = 1000;
    protected double newBeanQuantity = 500;

    public BasicCoffeeMaker(Map<BeanType, CoffeeBean> beanContainer, Map<CoffeeType, Map<BeanType, CoffeeBean>> beans){
        super();
        this.configMap.put(CoffeeType.Filter, new CoffeeConfiguration(30, 180));
        this.beanContainer = beanContainer;
        this.beans = beans;
        this.grinder = new Grinder();
        this.brewingUnit = new BrewingUnit();
    }

    @Override
    public Coffee brewCoffee(CoffeeType coffeeType, BeanType beanType) throws CoffeeException {
        switch (coffeeType) {
            case Filter:
                return brewFilterCoffee(beanType);

            default:
                throw new CoffeeException("Coffee type ["+coffeeType+"] not supported!");
        }
    }

    public ArrayList<Coffee> brewCoffee(CoffeeType coffeeType, BeanType beanType, int number) throws CoffeeException {
        ArrayList<Coffee> coffees = new ArrayList<>(number);
        for (int i=0; i<number; i++) {
            coffees.add(brewCoffee(coffeeType, beanType));
        }
        return coffees;
    }

    private Coffee brewFilterCoffee(BeanType beanType) throws CoffeeException {
        CoffeeConfiguration config = configMap.get(CoffeeType.Filter);
        // grind the coffee beans
        CoffeeBean coffeeBean = this.beans.get(CoffeeType.Filter).get(beanType);

        addBeans(beanType, coffeeBean);
        GroundCoffee groundCoffee = this.grinder.grind(coffeeBean, CoffeeType.Filter, config.getQuantityCoffee());

        // brew a filter coffee
        return this.brewingUnit.brew(CoffeeType.Filter, groundCoffee, config.getQuantityWater());
    }

    public void addBeans(BeanType beanType, CoffeeBean coffeeBean) throws CoffeeException {
        CoffeeBean newBeans = new CoffeeBean(beanType, newBeanQuantity);

        if(this.beanContainer.isEmpty()) {
            this.beanContainer.put(beanType, newBeans);
            System.out.println(String.format("You put bean type of %s with quantity %f", beanType, newBeans.getQuantity()));
        } else {
            CoffeeBean existingBeans = this.beanContainer.get(beanType);
            if (existingBeans != null) {
                if(existingBeans.getQuantity() > coffeeBean.getQuantity()) {
                    System.out.println(String.format("You have %f beans, which is enough to make %s of %s", existingBeans.getQuantity(), coffeeBean.getBeanType(), coffeeBean.getQuantity()));
                    existingBeans.setQuantity(existingBeans.getQuantity() - coffeeBean.getQuantity());
                    System.out.println(String.format("The remaining beans is now %f", existingBeans.getQuantity()));
                }  else {
                    System.out.println(String.format("You have %f beans, which is not enough to make %s of %s, so you add %f new beans", existingBeans.getQuantity(),
                            coffeeBean.getBeanType(), coffeeBean.getQuantity(), newBeans.getQuantity()));
                    double finalBeanQuantity = existingBeans.getQuantity() + newBeans.getQuantity() - coffeeBean.getQuantity();
                    existingBeans.setQuantity(finalBeanQuantity > maxBeanQuantity ? maxBeanQuantity : finalBeanQuantity);
                    System.out.println(String.format("The remaining beans is now %f", existingBeans.getQuantity()));
                }
            } else {
                throw new CoffeeException("Only one kind of beans supported for each Coffee Selection.");
            }
        }
    }
}
