package LectureCode.Session7.src;

import java.util.ArrayList;

public class ShoppingCart {
    ArrayList<ProductLine> productLines = new ArrayList<>();

    void addProductLine(ProductLine input) {
        // check if product line already exists within shopping cart

        for (ProductLine productLine : productLines) {
            Product product = productLine.getProduct();

            if (product.getName().equals(input.getProduct().getName())
             && product.getPrice() == input.getProduct().getPrice()) {
                productLine.increaseQuantity(input.getQuantity());

                return;
            }
        }

        this.productLines.add(input);
    }

    void removeProductLine(Product input) {
        for (int i = 0; i < this.productLines.size(); i ++) {
            Product product = this.productLines.get(i).getProduct();

            if (product.getName().equals(input.getName())
             && product.getPrice() == input.getPrice()) {
                this.productLines.remove(i);

                break;
            }
        }
    }

    float calculateTotal() {
        float output = 0.0f;

        for (ProductLine productLine : this.productLines) {
            output += productLine.getProduct().getPrice() * productLine.getQuantity();
        }

        return output;
    }
}

