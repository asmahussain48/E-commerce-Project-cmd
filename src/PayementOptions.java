package MainPanel;

import java.util.Scanner;

public class PayementOptions {
    static Scanner sc = new Scanner(System.in);
    static void paymentOptions() {
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
