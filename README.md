# Vending Machine Capstone


This application allows customers to purchase beverages, candy, chips, and gum from the comfort of their own computer. The vending machine is restocked from an input file each time the application runs and provides a main menu with options to display vending machine items, purchase items, and exit the application.

**Application Requirements**

Main menu with options to display vending machine items, purchase items, and exit the application.
Vending machine items with a name and price.
Option to display vending machine items with a list of all items and their quantity remaining. Out of stock items are indicated as "SOLD OUT".
Purchase process with options to feed money, select product, and finish transaction. The current money provided by the customer is displayed during the purchasing process.
Dispense product with the item name, cost, and money remaining displayed. Different products generate different "Yum!" messages.
Return change using the smallest amount of coins possible.
Audit all purchases in a file called "Log.txt".
Option to write a sales report showing the total sales since the machine was started.
Input file stocks the vending machine products in a pipe-delimited format with the following columns: Slot Location, Product Name, Price, and Type.
Sales report is a pipe-delimited file with each line indicating the number of sales for a specific product and the total sales amount at the end of the report.

**Unit Tests**

Unit tests have been provided to demonstrate the correct functionality of the code.

The vending machine program was built as a capstone project with Allan Treat during a 14 week coding bootcamp at Tech Elevator.
