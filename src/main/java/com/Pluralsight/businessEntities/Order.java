package com.Pluralsight.businessEntities;

import com.Pluralsight.interfaces.PriceItem;
import com.Pluralsight.service.OrderUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Order implements PriceItem {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chip>chips = new ArrayList<>();

    public Order(List<Sandwich> sandwiches, List<Drink> drinks, List<Chip> chips) {
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
    }
    public Order() {
    }
    public List<Sandwich> getSandwiches() {return sandwiches;}

    public List<Drink> getDrinks() {return drinks;}

    public List<Chip> getChips() {return chips;}

    public void addSandwich(Sandwich sandwich){
        sandwiches.add(sandwich);
    }
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChip(Chip chip) {
        chips.add(chip);
    }

    @Override
     public double getPrice() {
        double total = 0.0;
        for (Sandwich s : sandwiches) total += s.getPrice();
        for (Drink d : drinks) total += d.getPrice();
        for (Chip c : chips) total += c.getPrice();
        return total;
    }

    public String getSummary() {
        StringBuilder summary = new StringBuilder();

        summary.append("\n============================================\n");
        summary.append("               ORDER SUMMARY\n");
        summary.append("============================================\n");

        // SANDWICHES
        if (!sandwiches.isEmpty()) {
            summary.append("\nSandwiches:\n");
            summary.append(String.format("%-15s %-10s %-10s %-10s\n", "Size", "Bread", "Toasted", "Price"));
            summary.append("----------------------------------------------------\n");
            for (int i = sandwiches.size() - 1; i >= 0; i--) {
                Sandwich s = sandwiches.get(i);
                summary.append(String.format("%-15s %-10s %-10s $%-9.2f\n",
                        s.getSize() + " inch",
                        s.getBread(),
                        s.isToasted() ? "Yes" : "No",
                        s.getPrice()));
                if (!s.getToppings().isEmpty()) {
                    summary.append("  Toppings:\n");
                    for (Topping t : s.getToppings()) {
                        summary.append("    - ").append(t.getName())
                                .append(t.isExtra() ? " (extra)" : "")
                                .append("\n");
                    }
                }
                summary.append("\n");
            }
        }

        // DRINKS
        if (!drinks.isEmpty()) {
            summary.append("Drinks:\n");
            summary.append(String.format("%-10s %-15s %-10s\n", "Size", "Flavor", "Price"));
            summary.append("----------------------------------------\n");
            for (int i = drinks.size() - 1; i >= 0; i--) {
                Drink d = drinks.get(i);
                summary.append(String.format("%-10s %-15s $%-9.2f\n",
                        d.getSize(),
                        d.getFlavor(),
                        d.getPrice()));
            }
            summary.append("\n");
        }

        // CHIPS
        if (!chips.isEmpty()) {
            summary.append("Chips:\n");
            summary.append(String.format("%-15s %-10s\n", "Type", "Price"));
            summary.append("------------------------------\n");
            for (int i = chips.size() - 1; i >= 0; i--) {
                Chip c = chips.get(i);
                summary.append(String.format("%-15s $%-9.2f\n", c.getType(), c.getPrice()));
            }
            summary.append("\n");
        }

        summary.append("============================================\n");
        summary.append(String.format("TOTAL: $%.2f\n", getPrice()));
        summary.append("============================================\n");

        return summary.toString();
    }


    public void clear() {
        sandwiches.clear();
        drinks.clear();
        chips.clear();
    }
}
