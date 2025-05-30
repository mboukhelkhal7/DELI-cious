DELI-cious 🥪 - Java CLI Sandwich Shop
DELI-cious is a customizable sandwich shop experience built as a Java CLI application. It allows users to build and order sandwiches with a variety of toppings, drinks, and chips — all from the terminal!

📦 Features
Build your own sandwich:
Choose size (4", 8", 12")
Select bread type
Add meats, cheeses, sauces, and veggies
Mark toppings as "extra"
Toasted or not
Add drinks and chips
View order summary with prices
Save receipt to file
User-friendly text-based interface
🧠 Concepts Demonstrated
Object-Oriented Programming (OOP)
Classes: Sandwich, Order, Topping, Drink, Chip
Interface: PriceItem
Polymorphism and encapsulation
Java Collections and String formatting
File I/O (saving receipts)
Clean project architecture with packages:
businessEntities, screens, service, types
💻 Sample Screenshot
=========================================== WELCOME TO DELI-Cious! Custom Sandwiches Made Fresh Date: 2025-05-30 Start New Order

Exit Enter your choice:

shell Copy Edit

💾 Receipt Example
============================================ ORDER SUMMARY Sandwiches: Size Bread Toasted Price 8 inch wheat Yes $7.50 Toppings:

steak (extra)
cheddar
lettuce
mayo
Drinks: Size Flavor Price medium Coca-Cola $2.50

Chips: Type Price Lays $1.50

============================================ TOTAL: $11.50 csharp Copy Edit

💡 Highlight Code Snippet
public double getPrice() {
    double total = 0.0;
    for (Sandwich s : sandwiches) total += s.getPrice();
    for (Drink d : drinks) total += d.getPrice();
    for (Chip c : chips) total += c.getPrice();
    return total;
}
This logic calculates the total cost for the entire order, showcasing use of loops and encapsulation.

📚 Class Diagram
  +------------------------+
               |        PriceItem       |  <<interface>>
               +------------------------+
               | + getPrice(): double   |
               +------------------------+
                          ▲
                          |
        ---------------------------------------
        |                 |                  |
+--------------+  +-------------+     +-------------+
|   Sandwich   |  |    Drink    |     |    Chip     |
+--------------+  +-------------+     +-------------+
| - size: String      | - size: String     | - type: String  |
| - bread: String     | - flavor: String   |                 |
| - toasted: boolean  |                   |                 |
| - toppings: List<T> |                   |                 |
+--------------+  +-------------+     +-------------+
| + getPrice()  |  | + getPrice() |     | + getPrice() |
| + toString()  |  | + toString() |     | + toString() |
+--------------+  +-------------+     +-------------+

                     ▲
                     |
              +---------------+
              |   Topping     |
              +---------------+
              | - name: String |
              | - type: String |
              | - isExtra: bool|
              +---------------+
              | + getPrice()   |
              | + toString()   |
              +---------------+

                    ▲
                    |
        +--------------------------+
        |       Order              |
        +--------------------------+
        | - sandwiches: List       |
        | - drinks: List           |
        | - chips: List            |
        +--------------------------+
        | + addSandwich()          |
        | + addDrink()             |
        | + addChip()              |
        | + getSummary(): String   |
        | + getPrice(): double     |
        +--------------------------+

        +---------------------------+
        |      ReceiptWriter        |
        +---------------------------+
        | + saveOrderToFile(Order)  |
        +---------------------------+

        +---------------------------+
        |      OrderUtils (opt)     |
        +---------------------------+
        | (helper static methods)   |
        +---------------------------+

✅ How to Run
Clone the repository:

bash
Copy
Edit
git clone https://github.com/mboukhelkhal7/DELI-cious
Open in IntelliJ or VSCode

Run the HomeScreen.java main method

📂 Project Structure
css
Copy
Edit
src/
├── com.Pluralsight
│   ├── businessEntities/
│   ├── screens/
│   ├── service/
│   └── types/
