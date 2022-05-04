package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private String id;
    private ProductType type;
    private String subtype;
    private String brand;
    private double price;
    private double quantity;
    private int count = 1;

    public String getTypeString() {
        return getType().toString();
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
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(this.price) + " BGN";
    }

    public double getTotalPrice() {
        return getPrice() * getCount();
    }

    public String getTotalPriceString() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        return decimalFormat.format(getTotalPrice()) + " BGN";
    }

    public void increaseCount() {
        count++;
    }

    public void decreaseCount() {
        count--;
    }

}
