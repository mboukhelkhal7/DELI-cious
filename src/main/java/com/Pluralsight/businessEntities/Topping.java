package com.Pluralsight.businessEntities;

import com.Pluralsight.interfaces.PriceItem;
import com.Pluralsight.types.ToppingType;

public class Topping implements PriceItem {

    private String name;
    private String type;
    private boolean isExtra;

    public Topping(String name, String type, boolean isExtra) {
        this.name = name;
        this.type = type;
        this.isExtra = isExtra;
    }

    public String getName() {return name;}

    public String getType() {return type;}

    public boolean isExtra() {return isExtra;}

    @Override
    public double getPrice() {
        double price = 0;
        if (isExtra) {
            if (type.equals(ToppingType.MEAT)) {
                price = 1.00;
            } else if (type.equals(ToppingType.CHEESE)) {
                price = 0.75;
            } else if (type.equals(ToppingType.SAUCE)) {
                price = 0.50;
            } else {
                price = 0.25; // any other extra topping
            }
        }

        return price;
    }

    public String toString() {
        return name + " (" + type + ")" + (isExtra ? " [extra]" : "");
    }

}
