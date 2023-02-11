package com.techelevator.ui;

import com.techelevator.application.*;
import com.techelevator.models.Item;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("       Welcome To vending Machine MEGATRON");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayLevel1Options() {
        System.out.println("(D) Display Vending Items");
        System.out.println("(P) Purchase");
        System.out.println("(E) Exit");
    }

    public static void displayInventory(List<Item> items) {
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public static void displayLevel2Options(double totalBalance) {
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction");
        System.out.println();
        System.out.println("Current Balance: " + "$" + df.format(totalBalance));
    }

    public static void moneyAdded() {
        System.out.println("Insert money; $1.00, $5.00, $10.00, or $20.00");
    }
}
