package models;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Order {
    private int uid = 0;
    private String time;
    private int tableNumber;
    private ArrayList<Product> products;
    private int discountPercent;
    private DecimalFormat decimalFormat;

    public Order(int uid, String time, int tableNumber, ArrayList<Product> products) {
        this.uid = uid;
        this.time = time;
        this.tableNumber = tableNumber;
        this.products = products;
    }

    public int getUid() {
        return uid;
    }

    public String getUidString() {
        return Integer.toString(getUid());
    }

    public String getTime() {
        return this.time + "h";
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Product product : this.products) {
            totalAmount += product.getTotalPrice();
        }
        if (this.discountPercent > 0) {
            totalAmount -= totalAmount * (this.discountPercent / 100.00);
        }
        return totalAmount;
    }

    public String getTotalAmountString() {
        decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(getTotalAmount()) + " BGN";
    }

    public String getProductsCount() {
        int totalProductCount = 0;
        for (Product product : this.products) {
            totalProductCount += product.getCount();
        }
        return Integer.toString(totalProductCount);
    }

    public String getProductFullName() {
        String productFullName = "";
        for (Product product : products) {
            productFullName = product.getSubtype() + " " + product.getBrand();
        }
        return productFullName;
    }

    public double getProductPrice () {
        double productPrice = 0;
        for (Product product : products) {
            productPrice = product.getPrice();
        }
        return productPrice;
    }

    public String getProductPriceString () {
        decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(getProductPrice()) + " BGN";
    }
}
