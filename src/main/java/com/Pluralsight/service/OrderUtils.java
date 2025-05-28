package com.Pluralsight.service;

import com.Pluralsight.interfaces.PriceItem;

import java.util.List;

public class OrderUtils {

    public static <T extends PriceItem> double calculateTotal(List<T> items) {
        double total = 0;

        for (T item : items) {
            total += item.getPrice();  // polymorphism
        }
        return total;
    }
}
