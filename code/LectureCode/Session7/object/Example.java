package LectureCode.Session7.object;

import java.util.ArrayList;

public class Example {
    public static void main(String[] args) {
        /* A shopping cart and three products */

        Product pencil = new Product();
        Product eraser = new Product();
        Product paper = new Product();

        pencil.setName("Pencil");
        pencil.setPrice(20);

        eraser.setName("Eraser");
        eraser.setPrice(10);

        paper.setName("Paper");
        paper.setPrice(2);

        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(pencil, 3);
        cart.addProduct(eraser);
        cart.addProduct(paper);

        System.out.printf("Total: %.2f%n", cart.getTotal());

        cart.removeProduct(eraser);

        System.out.printf("Total: %.2f%n", cart.getTotal());
    }
}

class ShoppingCart {
    ArrayList<Product> products = new ArrayList<>();

    void addProduct(Product product) {
        this.products.add(product);
    }

    void addProduct(Product product, int quantity) {
        for (int i = 0; i < quantity; i ++) {
            addProduct(product);
        }
    }

    void removeProduct(Product product) {
        for (int i = 0; i < this.products.size(); i ++) {
            if (this.products.get(i).getName().equals(product.getName())
             && this.products.get(i).getPrice() == product.getPrice()) {
                this.products.remove(i);

                break;
            }
        }
    }

    float getTotal() {
        float output = 0.0f;

        for (Product product : this.products) {
            output = output +  product.getPrice();
        }

        return output;
    }
}

class Product {
    private String name = "Product Name";
    private float price = 0.0f;

    String getName() {
        return this.name;
    }

    float getPrice() {
        return this.price;
    }

    void setName(String value) {
        this.name = value.trim();
    }

    void setPrice(float price) {
        if (price >= 0) {
            this.price = price;
        }
    }
}