package com.Pluralsight.screens;

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
                     //
                     System.out.println("Sandwich builder coming soon...");
                     break;
                 case "2":
                     System.out.println("\n[ add Drink]");
                     //
                     System.out.println("Drink selector coming soon...");
                     break;
                 case "3":
                     System.out.println("\n[ add chips ]");
                     //
                     System.out.println("Chip selector coming soon...");
                     break;
                 case "4":
                     System.out.println("\n[ Order Summary ]");
                     System.out.println(order.getSummary());
                     break;
                 case "5":
                     System.out.println("\n[ Saving Receipt ]");
                     ReceiptWriter.saveOrderToFile(order);
                     break;
                 case "0":
                     System.out.println("\nReturning to Home Screen...");
                     return;
                 default:
                     System.out.println("Invalid input. Please enter a number between 0 and 5.");
             }
             System.out.println("\nPress Enter to continue...");
             scanner.nextLine();
         }
    }

}
