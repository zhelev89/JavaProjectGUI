package models;

public class Category {

    private ProductType type;
    private String title;

    public Category(ProductType type, String title) {
        this.type = type;
        this.title = title;
    }

    public ProductType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }
}
