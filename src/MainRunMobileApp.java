import java.util.Scanner;

import static entities.Cart.reviewCart;

public class MainRunMobileApp {

static Scanner sc = new Scanner(System.in);
    static int userId = Login.getLoggedInUserId();  // Assuming this method exists in your Login class

public static void main(String[] args) {
    while (true) {
        System.out.println("\n===== Main Menu =====");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1: // Login
                login();
                break;
            case 2: // Register
                register();
                break;
            case 3: // Exit
                System.out.println("Thank you for using the Mobile Store App!");
                return; // Exit the program
            default:
                System.out.println("Invalid option. Try again.");
        }
    }
}

// Login method (simplified)
private static void login() {
    System.out.println("\n===== Login =====");
    System.out.println("1. Buyer Login");
    System.out.println("2. Seller Login");
    System.out.println("3. Back to Main Menu");
    System.out.print("Choose an option: ");
    int choice = Integer.parseInt(sc.nextLine());

    switch (choice) {
        case 1:
            BuyerSellerLogin.handleBuyerLogin();  // Call the buyer login method
            break;
        case 2:
            BuyerSellerLogin.handleSellerLogin();  // Call the seller login method
            break;
        case 3:
            System.out.println("Returning to main menu...");
            break;
        default:
            System.out.println("Invalid option. Try again.");
    }
}


// Register method (simplified)
private static void register() {
    System.out.println("\n===== Register =====");
    System.out.println("1. Buyer Register");
    System.out.println("2. Seller Register");
    System.out.println("3. Back to Main Menu");
    System.out.print("Choose an option: ");
    int choice = Integer.parseInt(sc.nextLine());

    switch (choice) {
        case 1: // Buyer Register
            BuyerSellerRegister.buyerRegister();
            break;
        case 2: // Seller Register
            BuyerSellerRegister.sellerRegister();
            break;
        case 3: // Back to Main Menu
            return;
        default:
            System.out.println("Invalid option. Try again.");
    }
}
// Payment System (for buyers)
private static void placeOrder() {
    System.out.println("\n===== Place Order =====");
    System.out.println("1. Review Cart");
    System.out.println("2. Enter Address");
    System.out.println("3. Payment Options");
    System.out.print("Choose an option: ");
    int choice = Integer.parseInt(sc.nextLine());

    switch (choice) {

        case 1: // Review Cart
            userId=Login.getLoggedInUserId();
            System.out.println("Review Cart");
            reviewCart(userId);  // Call the reviewCart method, passing the user ID
            break;
        case 2:
            // Implement Enter Address
            System.out.println("Enter Address");
            break;
        case 3:
            // Implement Payment Options
            paymentOptions();
            break;
        default:
            System.out.println("Invalid option. Try again.");
    }
}

// Payment System (options for buyers)
private static void paymentOptions() {
    System.out.println("\n===== Payment Options =====");
    System.out.println("1. Cash on Delivery (COD)");
    System.out.println("2. Credit/Debit Card");
    System.out.println("3. Mobile Wallets (Easypaisa/JazzCash)");
    System.out.print("Choose a payment method: ");
    int choice = Integer.parseInt(sc.nextLine());

    switch (choice) {
        case 1:
            // Implement Cash on Delivery
            System.out.println("Cash on Delivery selected");
            break;
        case 2:
            // Implement Credit/Debit Card Payment
            System.out.println("Credit/Debit Card selected");
            break;
        case 3:
            // Implement Mobile Wallets Payment
            System.out.println("Mobile Wallet selected");
            break;
        default:
            System.out.println("Invalid option. Try again.");
    }
}

}
