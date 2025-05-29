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
       double total = 0;
        for (Sandwich s : sandwiches)
            total += s.getPrice();
        for (Drink d : drinks)
            total += d.getPrice();
        for (Chip c : chips)
            total += c.getPrice();
        return total;
    }

    public String getSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("=== ORDER SUMMARY ===\n");

        List<Sandwich> sandwichList = new ArrayList<>(sandwiches);
        Collections.reverse(sandwichList);
        for (Sandwich s : sandwichList) {
            summary.append("\n").append(s.toString()).append("\n");
        }

        List<Drink> drinkList = new ArrayList<>(drinks);
        Collections.reverse(drinkList);
        for (Drink d : drinkList) {
            summary.append("\nDrink: ").append(d.toString()).append("\n");
        }

        List<Chip> chipList = new ArrayList<>(chips);
        Collections.reverse(chipList);
        for (Chip c : chipList) {
            summary.append("\nChips: ").append(c.toString()).append("\n");
        }

        summary.append("\nTotal: $").append(getPrice());
        return summary.toString();
    }

    public void clear() {
        sandwiches.clear();
        drinks.clear();
        chips.clear();
    }
}
