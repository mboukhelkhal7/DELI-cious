package com.Pluralsight.screens;

import com.Pluralsight.businessEntities.Order;
import com.Pluralsight.businessEntities.Sandwich;
import com.Pluralsight.businessEntities.Topping;
import com.Pluralsight.types.ToppingType;

import java.util.Scanner;

public class SandwichBuilder {

    public static void show(Order order) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n====================================");
        System.out.println("         BUILD YOUR SANDWICH");
        System.out.println("====================================");

        String size = chooseSize(scanner);
        String bread = chooseBread(scanner);
        boolean toasted = askToasted(scanner);

        //Create sandwich
        Sandwich sandwich = new Sandwich(size, bread, toasted);
        // Ask for toppings
        addToppings(sandwich, scanner);
        // Add to order
        order.addSandwich(sandwich);

        System.out.println("\n Sandwich added to your order!");

    }

    private static String chooseSize(Scanner scanner) {
        System.out.println("\nChoose a sandwich size:");
        System.out.println("1) 4 inch");
        System.out.println("2) 8 inch");
        System.out.println("3) 12 inch");
        System.out.print("Enter your choice: ");
        String input = scanner.nextLine();

        switch (input) {
            case "1": return "4";
            case "2":return "8";
            case "3": return "12";
            default:
                System.out.println("Invalid choice. Defaulting to 8 inch.");
                return "8";
        }
    }

    private static String chooseBread(Scanner scanner) {
        System.out.println("\nChoose bread type:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.print("Enter your choice: ");
        String input = scanner.nextLine();

        switch (input) {
            case "1": return "white";
            case "2": return "wheat";
            case "3": return "rye";
            default:
                System.out.println("Invalid choice. Defaulting to white.");
                return "white";
        }
    }

    private static boolean askToasted(Scanner scanner) {
        System.out.print("\nDo you want it toasted? (yes/no): ");
        String input = scanner.nextLine().toLowerCase();
        return input.startsWith("y");
    }

    private static void addToppings(Sandwich sandwich, Scanner scanner) {
        System.out.println("\nAdd toppings (Press Enter to stop):");

        while (true) {
            System.out.print("Topping name (e.g. Turkey, Lettuce): ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) break;

            System.out.print("Topping type (meat, cheese, regular, sauce): ");
            String typeInput = scanner.nextLine().trim().toLowerCase();
            String type;
            switch (typeInput) {
                case "meat": type = ToppingType.MEAT; break;
                case "cheese": type = ToppingType.CHEESE; break;
                case "sauce": type = ToppingType.SAUCE; break;
                default: type = ToppingType.REGULAR; break;
            }

            System.out.print("Is it extra? (yes/no): ");
            String extraInput = scanner.nextLine().trim().toLowerCase();
            boolean isExtra = extraInput.startsWith("y");

            Topping topping = new Topping(name, type, isExtra);
            sandwich.addTopping(topping);
            System.out.println(" Added " + topping);
        }
    }

}
