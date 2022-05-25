package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer id;
    private String time;
    private int tableNumber;
    private List<Product> products;
    private int discountPercent;

    public String getUidString() {
        return Integer.toString(getId());
    }

    public String getTime() {
        return this.time + "h";
    }

    public List<Product> getProducts() {
        return products;
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
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
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
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(getProductPrice()) + " BGN";
    }
}
