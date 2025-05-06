package MainPanel;

import java.util.Scanner;
import entities.user; // Assuming you have a User class that saves users to the database

public class BuyerSellerRegister {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        register();
    }

    // Main register method
    private static void register() {
        System.out.println("\n===== Register =====");
        System.out.println("1. Buyer Register");
        System.out.println("2. Seller Register");
        System.out.println("3. Back to Main Menu");
        System.out.print("Choose an option: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1: // Buyer Register
                buyerRegister(); // Call buyer register method
                break;
            case 2: // Seller Register
                sellerRegister(); // Call seller register method
                break;
            case 3: // Back to Main Menu
                return; // Go back to the main menu
            default:
                System.out.println("Invalid option. Try again.");
        }
    }

    // Method for buyer registration
    public static void buyerRegister() {
        System.out.println("Enter buyer registration details:");

        // Ask for user details
        String buyerUsername = getInput("Enter username: ");
        String buyerEmail = getInput("Enter email: ");
        String buyerPassword = getInput("Enter password: ");
        String buyerFullName = getInput("Enter full name: ");
        String buyerPhone = getInput("Enter phone number: ");
        String buyerAddress = getInput("Enter address: ");

        // Create buyer object and save to database
        user buyer = new user(buyerUsername, buyerEmail, buyerPassword, "buyer", buyerFullName, buyerPhone, buyerAddress);
        buyer.saveToDatabase();  // Assuming this method saves the buyer details to the database

        System.out.println("Buyer registered successfully.");
    }

    // Method for seller registration
    public static void sellerRegister() {
        System.out.println("Enter seller registration details:");

        // Ask for user details
        String sellerUsername = getInput("Enter username: ");
        String sellerEmail = getInput("Enter email: ");
        String sellerPassword = getInput("Enter password: ");
        String sellerFullName = getInput("Enter full name: ");
        String sellerPhone = getInput("Enter phone number: ");
        String sellerAddress = getInput("Enter address: ");

        // Create seller object and save to database
        user seller = new user(sellerUsername, sellerEmail, sellerPassword, "seller", sellerFullName, sellerPhone, sellerAddress);
        seller.saveToDatabase();  // Assuming this method saves the seller details to the database

        System.out.println("Seller registered successfully.");
    }

    // Helper method to get user input
    private static String getInput(String prompt) {
        System.out.print(prompt);
        return sc.nextLine();
    }
}
