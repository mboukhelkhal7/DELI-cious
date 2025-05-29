package com.Pluralsight.service;

import com.Pluralsight.businessEntities.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptWriter {

    public static void saveOrderToFile(Order order) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        String time = LocalDateTime.now().format(formatter);
        String fileName = "receipt_" + time.replace(":", "-").replace(" ", "_") + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("=== DELI-cious Sandwich Shop ===\n");
            writer.write("     Fresh. Fast. Friendly.\n");
            writer.write("-------------------------------\n");
            writer.write("Date: " + time + "\n\n");
            writer.write(order.getSummary());
            writer.write("\n\nThank you for your order!\n");
            writer.write("Have a delicious day!");
            System.out.println("Receipt saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing receipt: " + e.getMessage());
        }
    }
}
