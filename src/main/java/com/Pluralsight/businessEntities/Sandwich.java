package com.Pluralsight.businessEntities;

import com.Pluralsight.interfaces.PriceItem;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements PriceItem {

    private String size;
    private String bread;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();

    public Sandwich(String size, String bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
    }

    public String getSize() {return size;}

    public String getBread() {return bread;}

    public boolean isToasted() {return toasted;}

    public List<Topping> getToppings() { return toppings; }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }


    @Override
    public double getPrice() {
        double basePrice;

        switch (size) {
            case "4": basePrice = 5.50; break;
            case "8": basePrice = 7.00; break;
            case "12": basePrice = 8.50; break;
            default: basePrice = 7.00; // Default to 8 inch
        }

        for (Topping topping : toppings) {
            basePrice += topping.getPrice();
        }

        return basePrice;
    }

    public String getSummary() {
        StringBuilder builder = new StringBuilder();
        builder.append(size).append("\" ").append(bread);
        if (toasted) builder.append(" (Toasted)");
        builder.append("\nToppings:");
        for (Topping t : toppings) {
            builder.append("\n - ").append(t.toString());
        }
        builder.append("\nTotal: $").append(getPrice());
        return builder.toString();
    }

    @Override
    public String toString() {
        return getSummary();
    }

}
