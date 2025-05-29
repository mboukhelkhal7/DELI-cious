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
        double basePrice;
        if (type.equals(ToppingType.MEAT)) basePrice = 1.50;
        else if (type.equals(ToppingType.CHEESE)) basePrice = 1.00;
        else basePrice = 0.50;

        return isExtra ? basePrice * 2 : basePrice;
    }

    public String toString() {
        return name + (isExtra ? " (extra)" : "");
    }

}
