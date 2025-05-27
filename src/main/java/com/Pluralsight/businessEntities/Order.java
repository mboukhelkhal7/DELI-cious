package com.Pluralsight.businessEntities;

import com.Pluralsight.interfaces.PriceItem;

import java.util.List;


public class Order implements PriceItem {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chip>chips;

    public Order(List<Sandwich> sandwiches, List<Drink> drinks, List<Chip> chips) {
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
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
       double total = 0;

        for (Sandwich s : sandwiches) {
            total += s.getPrice();
        }

        for (Drink d : drinks) {
            total += d.getPrice();
        }

        for (Chip c : chips) {
            total += c.getPrice();
        }

        return total;
    }

    public String getSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("=== Order Summary ===\n");

        for (Sandwich s : sandwiches) {
            summary.append("\n--- Sandwich ---\n");
            summary.append(s.getSummary()).append("\n");
        }

        for (Drink d : drinks) {
            summary.append("\n--- Drink ---\n");
            summary.append(d.getSummary()).append("\n");
        }

        for (Chip c : chips) {
            summary.append("\n--- Chips ---\n");
            summary.append(c.getSummary()).append("\n");
        }

        summary.append("\nTotal Order Price: $").append(getPrice());
        return summary.toString();
    }
}
