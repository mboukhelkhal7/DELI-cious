package com.Pluralsight.businessEntities;

import com.Pluralsight.interfaces.PriceItem;

public class Drink implements PriceItem {

    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {return size;}

    public String getFlavor() {return flavor;}

    @Override
    public double getPrice() {
        switch (size.toLowerCase()) {
            case "small": return 2.00;
            case "medium": return 2.50;
            case "large": return 3.00;
            default: return 0.0;
        }
    }
    public String getSummary() {
        return size + " " + flavor + " - $" + getPrice();
    }
    public String toString() {
        return size + " " + flavor;
    }
}
