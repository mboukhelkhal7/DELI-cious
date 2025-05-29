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
        order.addSandwich(sandwich);
        System.out.println("\nHere are the toppings you added:");
        for (Topping t : sandwich.getToppings()) {
            System.out.println(" - " + t.toString());
        }
        // Add to order
        System.out.println("\n Sandwich added to your order!");
    }
    private static String chooseSize(Scanner scanner) {
        System.out.println("\nChoose a sandwich size:");
        System.out.println("1) 4 inch");
        System.out.println("2) 8 inch");
        System.out.println("3) 12 inch");
        System.out.print("Enter your choice: ");
        String input = scanner.nextLine();

        return switch (input) {
            case "1" -> "4";
            case "2" -> "8";
            case "3" -> "12";
            default -> {
                System.out.println("Invalid choice. Defaulting to 8 inch.");
                yield "8";
            }
        };
    }
    private static String chooseBread(Scanner scanner) {
        System.out.println("\nChoose bread type:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.print("Enter your choice: ");
        String input = scanner.nextLine();

        return switch (input) {
            case "1" -> "white";
            case "2" -> "wheat";
            case "3" -> "rye";
            default -> {
                System.out.println("Invalid choice. Defaulting to white.");
                yield "white";
            }
        };
    }

    private static boolean askToasted(Scanner scanner) {
        System.out.print("\nDo you want it toasted? (yes/no): ");
        String input = scanner.nextLine().toLowerCase();
        return input.startsWith("y");
    }

    private static void addToppings(Sandwich sandwich, Scanner scanner) {
        System.out.println("\nAdd toppings (Press Enter to stop):");

        while (true) {
            System.out.print("Enter topping name (e.g. turkey, cheddar, lettuce): ");
            String name = scanner.nextLine().trim();
            if (name.isEmpty()) break;
            System.out.print("\"Enter topping type (meat/cheese/sauce/regular): ");
            String typeInput = scanner.nextLine().trim().toLowerCase();
            String type = ToppingType.REGULAR;
            switch (typeInput) {
                case "meat" -> {
                    displayMeatMenu();      // shows meat table
                    type = ToppingType.MEAT;
                }
                case "cheese" -> {
                    displayCheeseMenu();    // shows cheese table
                    type = ToppingType.CHEESE;
                }
                case "sauce" -> {
                    displaySauceMenu();     // shows sauce table
                    type = ToppingType.SAUCE;
                }
                default -> {
                    displayRegularToppingsMenu(); // shows regular toppings
                    type = ToppingType.REGULAR;
                }
            }
            //String type = switch (typeInput) {
               // case "meat" -> ToppingType.MEAT;
               // case "cheese" -> ToppingType.CHEESE;
                //case "sauce" -> ToppingType.SAUCE;
               // default -> ToppingType.REGULAR;
           // };

            System.out.print("Is it extra? (yes/no): ");
            String extraInput = scanner.nextLine().trim().toLowerCase();
            boolean isExtra = extraInput.startsWith("y");

            Topping topping = new Topping(name, type, isExtra);
            sandwich.addTopping(topping);
            System.out.println(" Added " + topping);
        }
    }

    public static void displayMeatMenu() {
        System.out.println("--------------------------------------------------");
        System.out.println("|                   Meats                        |");
        System.out.println("|  - steak                                        |");
        System.out.println("|  - ham                                          |");
        System.out.println("|  - salami                                       |");
        System.out.println("|  - roast beef                                   |");
        System.out.println("|  - chicken                                      |");
        System.out.println("|  - bacon                                        |");
        System.out.println("--------------------------------------------------");
        System.out.println("|              Extra Meat Pricing                 |");
        System.out.println("|        |   4in   |   8in   |   12in             |");
        System.out.println("|--------|---------|---------|--------------------|");
        System.out.println("| Extra  |  $0.50  |  $1.00  |  $1.50              |");
        System.out.println("--------------------------------------------------");
    }
    private static void displayCheeseMenu() {
        System.out.println("\n==============================");
        System.out.println("|        Cheese Menu        |");
        System.out.println("|----------------------------|");
        System.out.println("| - american                |");
        System.out.println("| - provolone               |");
        System.out.println("| - cheddar                 |");
        System.out.println("| - swiss                   |");
        System.out.println("==============================");
    }

    private static void displayRegularToppingsMenu() {
        System.out.println("\n==============================");
        System.out.println("|     Regular Toppings      |");
        System.out.println("|----------------------------|");
        System.out.println("| - lettuce    - cucumbers  |");
        System.out.println("| - peppers    - guacamole  |");
        System.out.println("| - onions     - mushrooms  |");
        System.out.println("| - tomatoes   - pickles    |");
        System.out.println("==============================");
    }

    private static void displaySauceMenu() {
        System.out.println("\n==============================");
        System.out.println("|        Sauce Menu         |");
        System.out.println("|----------------------------|");
        System.out.println("| - mayo     - mustard      |");
        System.out.println("| - ketchup  - ranch        |");
        System.out.println("| - thousand islands        |");
        System.out.println("| - vinaigrette             |");
        System.out.println("==============================");
    }

}
