import MainPanel.BuyerSellerLogin;
import MainPanel.BuyerSellerRegister;

import java.util.Scanner;

public class halfMain {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    BuyerSellerLogin.login();
                    break;
                case 2:
                    BuyerSellerRegister.register();
                    break;
                case 3:
                    System.out.println("Thank you for using the Mobile Store App!");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Register method (simplified)
    // Payment System (for buyers)


    // Payment System (options for buyers)

}
