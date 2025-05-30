package com.Pluralsight.businessEntities;

import com.Pluralsight.interfaces.PriceItem;

public class Chip implements PriceItem {

    private String type;

    public Chip(String type) {
        this.type = type;
    }
    public String getType() {return type;}

    @Override
    public double getPrice() {
        return 1.5;
    }
    public String getSummary() {
        return type + " Chips - $" + getPrice();
    }
    public String toString() {
        return type;
    }
}
