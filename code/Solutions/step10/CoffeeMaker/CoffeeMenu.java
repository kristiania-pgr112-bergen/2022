package Solutions.step10.CoffeeMaker;

public class CoffeeMenu {
    public static void main(String[] args) {
        BasicCoffeeMaker basicCoffeeMaker = new BasicCoffeeMaker();
        try {
            basicCoffeeMaker.brewCoffee(CoffeeType.Filter);
        } catch (CoffeeException e) {
            e.printStackTrace();
        }

        PremiumCoffeeMaker premiumCoffeemaker = new PremiumCoffeeMaker();
        try {
            premiumCoffeemaker.brewCoffee(CoffeeType.Espresso, 2);
        } catch (CoffeeException e) {
            e.printStackTrace();
        }

    }
}
