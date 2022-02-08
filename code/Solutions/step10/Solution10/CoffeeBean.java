package Solutions.step10.Solution10;

public class CoffeeBean {
    private BeanType beanType;

    private double quantity;

    public CoffeeBean(BeanType beanType, double quantity) {
        this.beanType = beanType;
        this.quantity = quantity;
    }

    public BeanType getBeanType() {
        return beanType;
    }

    public void setBeanType(BeanType beanType) {
        this.beanType = beanType;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
