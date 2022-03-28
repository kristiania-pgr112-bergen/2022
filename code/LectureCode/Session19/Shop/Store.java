package LectureCode.Session19.Shop;

import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    protected final static HashMap<Integer, Store.Registration> registrar = new HashMap<>();

    //# Fields
    private Store.Registration registration;
    private final Inventory inventory = new Inventory();
    private final HashMap<Integer, Customer> customers = new HashMap<>();

    ArrayList<Transaction> transactions = new ArrayList<>();

    private int customerCount = 0;

    //# Store.Registration record
    record Registration(
            int id,
            String name,
            long orgNumber,
            Store.Type type
    ) {}

    //# Store.Type enum
    enum Type {
        Physical,
        Digital
    }

    private Store(Store.Registration registration) {
        this.registration = registration;
    }

    //# Methods
    void addCustomer(Customer customer) {
        if (!this.customers.containsValue(customer)) {
            this.customers.put(++this.customerCount, customer);
        }
    }

    void removeCustomer(int customerId) {
        this.customers.remove(customerId);
    }

    boolean productQuantityInStock(Product product, int quantity) {
        int stock = this.inventory.stock.get(product);

        return quantity <= stock;
    }

    void buyProduct(int customerId, Product product, int quantity) {
        Customer customer = this.customers.get(customerId);

        if (this.productQuantityInStock(product, quantity)) {
            System.out.printf("Customer bought %d of the following product: %s%n", quantity, product);

            this.inventory.stock.replace(product, this.inventory.stock.get(product) - quantity);
        }
    }

    //# Main
    public static void main(String[] args) {
        Store.Registration registration = new Store.Registration(
                1,
                "Java Coffee and Tea",
                1234567890,
                Type.Physical
        );

        Store store = new Store(registration);

        Product P1 = new Product(1, "Kaffe", 10, Product.Type.Physical);
        Product P2 = new Product(2, "Tea", 10, Product.Type.Physical);
        Product P3 = new Product(3, "Coffee Super Deluce VIP-pass", 1000, Product.Type.Digital);

        store.inventory.stock.put(P1, 50);
        store.inventory.stock.put(P2, 50);
        store.inventory.stock.put(P2, 1);

        Customer A = new Customer("a@abc.no", "Aaaaaaaaa");
        Customer B = new Customer("b@abc.no", "Bbbbbbbbb");

        store.addCustomer(A);
        store.addCustomer(B);

        System.out.printf("Current stock of Coffee: %d (now)%n", store.inventory.stock.get(P1));

        store.buyProduct(1, P1, 1);

        System.out.printf("Current stock of Coffee: %d (after)%n", store.inventory.stock.get(P1));
    }
}
