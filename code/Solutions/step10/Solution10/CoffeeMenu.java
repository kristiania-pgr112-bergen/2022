package Solutions.step10.Solution10;

import java.util.HashMap;
import java.util.Map;

public class CoffeeMenu {
    public static void main(String[] args) {
        HashMap<CoffeeType, Map<BeanType, CoffeeBean>> beans = new HashMap<>();
        HashMap<BeanType, CoffeeBean> subBeans = new HashMap<>();
        subBeans.put(BeanType.Arabica, new CoffeeBean(BeanType.Arabica, 200));
        subBeans.put(BeanType.Excelsa, new CoffeeBean(BeanType.Excelsa, 200));
        beans.put(CoffeeType.Filter, subBeans);
        beans.put(CoffeeType.Espresso, subBeans);

        Map<BeanType, CoffeeBean> beanContainer = new HashMap<>();
        beanContainer.put(BeanType.Arabica, new CoffeeBean(BeanType.Arabica, 100));
/*        BasicCoffeeMaker basicCoffeeMaker = new BasicCoffeeMaker(beanContainer, beans);
        try {
            basicCoffeeMaker.brewCoffee(CoffeeType.Filter, BeanType.Arabica, 2);
        } catch (CoffeeException e) {
            e.printStackTrace();
        }*/

        PremiumCoffeemaker premiumCoffeemaker = new PremiumCoffeemaker(beanContainer, beans);
        try {
            premiumCoffeemaker.brewCoffee(CoffeeType.Espresso, BeanType.Arabica, 2);
        } catch (CoffeeException e) {
            e.printStackTrace();
        }

    }

}
