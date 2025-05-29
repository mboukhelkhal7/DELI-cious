package com.Pluralsight.screens;

import com.Pluralsight.businessEntities.Chip;
import com.Pluralsight.businessEntities.Drink;
import com.Pluralsight.businessEntities.Order;
import com.Pluralsight.service.ReceiptWriter;

import java.util.Scanner;

public class OrderMenu {
    public static void show(Order order) {

        Scanner scanner = new Scanner(System.in);
         while (true) {

             System.out.println("\n============================================");
             System.out.println("            BUILD YOUR ORDER MENU");
             System.out.println("============================================");
             System.out.println("1) Add Sandwich");
             System.out.println("2) Add Drink");
             System.out.println("3) Add Chips");
             System.out.println("4) View Order Summary");
             System.out.println("5) Save Receipt");
             System.out.println("0) Return to Home Screen");
             System.out.println("--------------------------------------------");
             System.out.print("Enter your choice: ");

             String choice = scanner.nextLine();

             switch (choice) {
                 case "1":
                     System.out.println("\n [ Add Sandwich ]");
                     SandwichBuilder.show(order);

                     break;
                 case "2":
                     System.out.println("\n[ add Drink]");
                     addDrink(order, scanner);
                     break;
                 case "3":
                     System.out.println("\n[ add chips ]");
                     addChip(order, scanner);

                     break;
                 case "4":
                     System.out.println("\n====== CHECKOUT ======");
                     System.out.println(order.getSummary());

                     System.out.print("\nDo you want to confirm this order? (yes/no): ");
                     String confirm = scanner.nextLine().trim().toLowerCase();

                     if (confirm.startsWith("y")) {
                         ReceiptWriter.saveOrderToFile(order);
                         System.out.println(" Order saved. Returning to Home Screen...");
                         return;
                     } else {
                         System.out.println(" Order canceled. Returning to Home Screen...");
                         return;
                     }

                 case "5":
                     System.out.println("\n[ Saving Receipt ]");
                     ReceiptWriter.saveOrderToFile(order);
                     break;
                 case "0":
                     System.out.print("Are you sure you want to cancel this order? (yes/no): ");
                     String cancelInput = scanner.nextLine().trim().toLowerCase();

                     if (cancelInput.startsWith("y")) {
                         order.clear();
                         System.out.println("Order canceled. Returning to Home Screen...");
                         return;
                     } else {
                         System.out.println("Returning to order menu...");
                     }
                     return;
                 default:
                     System.out.println("Invalid input. Please enter a number between 0 and 5.");
             }
             System.out.println("\nPress Enter to continue...");
             scanner.nextLine();
         }
    }

    private static void addDrink(Order order, Scanner scanner) {
        System.out.println("\n--- Add a Drink ---");
        System.out.print("Enter drink size (small / medium / large): ");
        String size = scanner.nextLine().trim();
        System.out.print("Enter drink flavor (e.g. Coke, Sprite): ");
        String flavor = scanner.nextLine().trim();

        order.addDrink(new Drink(size, flavor));
        System.out.println(" Drink added to your order.");
    }

    private static void addChip(Order order, Scanner scanner) {
        System.out.println("\n--- Add Chips ---");
        System.out.print("Enter chip type (e.g. Lays, Doritos): ");
        String type = scanner.nextLine().trim();

        order.addChip(new Chip(type));
        System.out.println(" Chip added to your order.");
    }

}
