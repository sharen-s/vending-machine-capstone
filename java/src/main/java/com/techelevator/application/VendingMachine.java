package com.techelevator.application;
import com.techelevator.models.Item;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.*;

import static com.techelevator.ui.UserOutput.*;

public class VendingMachine {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    public static double totalBalance = 0.00;
    private static List<Item> items = new ArrayList<>();

    public static void loadFile() {
        File file = new File("catering.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] lineArr = line.split("\\,");
                String itemLocation = lineArr[0];
                String name = lineArr[1];
                double price = Double.parseDouble(lineArr[2]);
                String type = lineArr[3];
                if (type.equals("Candy")) {
                    Item candy = new Candy(itemLocation, name, price, type);
                    items.add(candy);
                } else if (type.equals("Drink")) {
                    Item drinks = new Drinks(itemLocation, name, price, type);
                    items.add(drinks);
                } else if (type.equals("Gum")) {
                    Item gum = new Gum(itemLocation, name, price, type);
                    items.add(gum);
                } else if (type.equals("Munchy")) {
                    Item munchy = new Munchy(itemLocation, name, price, type);
                    items.add(munchy);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Problem with file");
        }
    }

    public void run() {
        loadFile();
        while (true) {
            UserOutput.displayHomeScreen();
            UserOutput.displayLevel1Options();
            String choice = UserInput.getHomeScreenOption();
            if (choice.equals("display")) {
                System.out.println("display vending items");
                for (Item item : items) {
                    System.out.println(item);
                }
            } else if (choice.equals("purchase")) {
                secondMenuOption();
            } else if (choice.equals("exit")) {
                System.exit(1);
            }
        }
    }

    public static void secondMenuOption() {
        boolean stay = true;
        while (stay) {
            UserOutput.displayLevel2Options(totalBalance);
            String choice = UserInput.getSecondMenuOption();
            if (choice.equals("Feed Money")) {
                feedingMoney();
            } else if (choice.equals("Select Item")) {
                itemSelection();
            } else if (choice.equals("Finish Transaction")) {
                finishTransaction();
            }
        }
    }

    public static Item findItem(String slotLocationInput) {
        Item itemFound = null;
        for (Item item : items) {
            String slotLocation = item.getLocation();
            if (slotLocation.equals(slotLocationInput)) {
                itemFound = item;
                break;
            }
        }
        return itemFound;
    }

    public static void feedingMoney() {
        moneyAdded();
        String moneyInput = UserInput.getFeedMoney();
        double total = Double.parseDouble(moneyInput);
        totalBalance += total;
    }

    public static void itemSelection() {
        displayInventory(items);
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Please make your selection by entering the slot number: ");
        String slotInput = scanner.nextLine();
        Item findItem = findItem(slotInput);
        if (items.contains(findItem)) {
            Scanner input = new Scanner(System.in);
            System.out.println("QTY: ");
            String qty = input.nextLine();
            int newQty = Integer.parseInt(qty);
            double price = findItem.getPrice();
            double calculatedPrice = price * newQty;            //This represents $$ being subtracted ($1
            int discount = (newQty/2);
            if (newQty <= findItem.getQuantity() && totalBalance >= calculatedPrice) {
                if (newQty >= 2 && newQty <= 6) {
                    System.out.println("Decepticon Thanksgiving Discount!");
                    System.out.println();
                    System.out.println("-" + "$" + discount + " Off your purchase!");
                    System.out.println();
                    calculatedPrice -= discount;
                    int quantity = findItem.getQuantity();
                    findItem.setQuantity(quantity - newQty);
                    totalBalance -= calculatedPrice;
                }
                AuditLog.write(findItem.getName() + " " + findItem.getLocation() + ", " + "MONEY FED: $" + df.format(totalBalance) + "\n");
                System.out.println("Dispensing Items: " + findItem.getName() + ", " + "Total: "  + "$" + df.format(calculatedPrice));
                if (Objects.equals(findItem.getType(), "Candy")) {
                    System.out.println("Sugar, Sugar, so Sweet!");
                    System.out.println();
                } if (Objects.equals(findItem.getType(), "Drink")) {
                    System.out.println("Drinky, Drinky, Slurp Slurp!");
                    System.out.println();
                } if (Objects.equals(findItem.getType(), "Gum")) {
                    System.out.println("Chewy, Chewy, Lots O Bubbles!");
                    System.out.println();
                } if (Objects.equals(findItem.getType(), "Munchy")) {
                    System.out.println("Munchy, Munchy, so Good!");
                    System.out.println();
                }
            } else if (totalBalance < calculatedPrice) {
                System.out.println("Not enough funds");
                System.out.println();
            } else if (newQty > findItem.getQuantity()) {
                System.out.println("Items out of stock");
                System.out.println();
            }
        } if (!items.contains(findItem)) {
            System.out.println("Item not found, please choose the correct slot number: ");
            System.out.println();
            itemSelection();
            System.out.println();
        }
    }

    public static void finishTransaction (){
        System.out.println("Please take your change: " + "$" + df.format(totalBalance));
        AuditLog.write("CHANGE GIVEN: $" + df.format(totalBalance) + " " + "$" + df.format(totalBalance*0.00) + "\n");
        System.out.println("New Balance: " + "$" + df.format(totalBalance*0.00));
        UserInput.getFinishTransaction();
    }
}








