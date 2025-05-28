package com.Pluralsight.screens;

import com.Pluralsight.businessEntities.Order;

import java.time.LocalDate;
import java.util.Scanner;

public class HomeScreen {
    public static void show() {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("\n\n");

            System.out.println("===========================================");
            System.out.println("         WELCOME TO DELI-Cious!");
            System.out.println("       Custom Sandwiches Made Fresh");
            System.out.println("===========================================");
            System.out.println("Date: " + LocalDate.now());
            System.out.println("-------------------------------------------");

            System.out.println("1) Start New Order");
            System.out.println("0) Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("\nStarting a new order...");
                    Order order = new Order();
                    OrderMenu.show(order);
                    System.out.println("Order building coming soon...");
                    break;
                case "0":
                    System.out.println("Thank you for visiting DELI-cious. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter 1 or 0.");
            }
            System.out.println("\nPress Enter to return to the main menu...");
            scanner.nextLine();
        }
    }
}
