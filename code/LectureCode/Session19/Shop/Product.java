package LectureCode.Session19.Shop;


public record Product(
        int id,
        String name,
        float price,
        Product.Type type
) {
    public enum Type {
        Physical,
        Digital
    }
}
