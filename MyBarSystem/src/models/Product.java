package models;

import java.text.DecimalFormat;

public class Product {

    private String uid;
    private ProductType type;
    private String subtype;
    private String brand;
    private double price;
    private double quantity;
    private int count;
    private DecimalFormat decimalFormat;

    public Product(String uid, ProductType type, String subtype, String brand, double price, double quantity) {

        this.uid = uid;
        this.type = type;
        this.subtype = subtype;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
        this.count = 1;
    }

    public String getUid() {
        return this.uid;
    }

    public ProductType getType() {
        return type;
    }

    public String getTypeString() {
        return getType().toString();
    }

    public String getSubtype() {
        return subtype;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return this.price;
    }

    public double getQuantity() {
        return quantity;
    }

    public int getCount() {
        return count;
    }

    public String getCountString() {
        return Integer.toString(getCount());
    }

    public String getProductName() {
        if (this.subtype.isEmpty()) {
            return this.brand;
        }
        return this.subtype + " " + this.brand;
    }

    public String getPriceString() {
        decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(this.price) + " лв.";
    }

    public double getTotalPrice() {
        return getPrice() * getCount();
    }

    public String getTotalPriceString() {
        decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(getTotalPrice()) + " лв";
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void increaseCount() {
        count++;
    }

    public void decreaseCount() {
        count--;
    }

}
