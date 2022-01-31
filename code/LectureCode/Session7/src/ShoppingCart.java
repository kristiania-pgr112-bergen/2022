package LectureCode.Session7.src;

import java.util.ArrayList;


public class ShoppingCart {
    ArrayList<ProductLine> productLines = new ArrayList<>();

    void addProductLine(ProductLine input) {
        // check if product line already exists within shopping cart
        for (ProductLine productLine : productLines) {
            Product product = productLine.getProduct();

            // product line already exists
            if (product.getName().equals(input.getProduct().getName())
             && product.getPrice() == input.getProduct().getPrice()) {
                productLine.increaseQuantity(input.getQuantity());

                // return here to skip running code after the loop
                return;
            }
        }

        // if no product line that already exists, add it
        this.productLines.add(input);
    }

    void removeProductLine(Product input) {
        // go through each product line to check if product given is a part of one of them
        for (int i = 0; i < this.productLines.size(); i ++) {
            Product product = this.productLines.get(i).getProduct();

            // if product is found within a product line that exists, remove it
            if (product.getName().equals(input.getName())
             && product.getPrice() == input.getPrice()) {
                this.productLines.remove(i);

                break;
            }
        }
    }

    float calculateTotal() {
        float output = 0.0f;

        // sum the price of all products within each product line
        for (ProductLine productLine : this.productLines) {
            output += productLine.getProduct().getPrice() * productLine.getQuantity();
        }

        return output;
    }
}

