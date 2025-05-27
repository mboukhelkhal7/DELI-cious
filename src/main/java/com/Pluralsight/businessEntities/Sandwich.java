package com.Pluralsight.businessEntities;

import com.Pluralsight.interfaces.PriceItem;

import java.util.ArrayList;
import java.util.List;

public class Sandwich implements PriceItem {

    private String size;
    private String bread;
    private boolean toasted;
    private List<String> meats = new ArrayList<>();
    private List<String> cheeses = new ArrayList<>();
    private List<String> toppings = new ArrayList<>();
    private List<String> sauces = new ArrayList<>();

    public Sandwich(String size, String bread, boolean toasted) {
        this.size = size;
        this.bread = bread;
        this.toasted = toasted;
    }

    public String getSize() {return size;}

    public String getBread() {return bread;}

    public boolean isToasted() {return toasted;}

    public List<String> getMeats() {return meats;}

    public List<String> getCheeses() {return cheeses;}

    public List<String> getToppings() {return toppings;}

    public List<String> getSauces() {return sauces;}

    public void addMeat(String meat) {meats.add(meat);}

    public void addCheese(String cheese) {cheeses.add(cheese);}

    public void addTopping(String topping) {toppings.add(topping);}

    public void addSauce(String sauce) {sauces.add(sauce);}

    @Override
    public double getPrice() {
        double basePrice = 0;

        if (size.equals("4")) basePrice = 5.50;
        else if (size.equals("8")) basePrice = 7.00;
        else if (size.equals("12")) basePrice = 8.50;

        if (size.equals("4")) basePrice += meats.size() * 1.00;
        else if (size.equals("8")) basePrice += meats.size() * 2.00;
        else if (size.equals("12")) basePrice += meats.size() * 3.00;

        if (size.equals("4")) basePrice += cheeses.size() * 0.75;
        else if (size.equals("8")) basePrice += cheeses.size() * 1.50;
        else if (size.equals("12")) basePrice += cheeses.size() * 2.25;

        return basePrice;
    }
    public String getSummary() {
        return size + "\" " + bread + (toasted ? " (Toasted)" : "") +
                "\nMeats: " + meats +
                "\nCheeses: " + cheeses +
                "\nToppings: " + toppings +
                "\nSauces: " + sauces +
                "\nTotal: $" + getPrice();
    }
    public String toString() {
        return getSummary();
    }
}
