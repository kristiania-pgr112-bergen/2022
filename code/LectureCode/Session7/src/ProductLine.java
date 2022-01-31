package LectureCode.Session7.src;

class ProductLine {
    private final Product product;
    private int quantity = 1;

    ProductLine(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    Product getProduct() {
        return this.product;
    }

    void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }
}
