package MainPanel;

import MainPanel.BuyerPanel;//package MainPanel;
import MainPanel.SellerPanel;

import java.util.Scanner;

//
//import entities.user;
//import Login;
//import java.util.Scanner;
//
//public class BuyerSellerLogin {
//    static Scanner sc = new Scanner(System.in);
//    public static void login() {
//        System.out.println("\n===== Login =====");
//        System.out.println("1. Buyer Login");
//        System.out.println("2. Seller Login");
//        System.out.println("3. Back to Main Menu");
//        System.out.print("Choose an option: ");
//        int choice=Integer.parseInt(sc.nextLine());
//
//        switch (choice) {
//            case 1: // Buyer Login
//                user buyer=Login.loginUserAndReturnUser();  // Call the Login class method
//                if (buyer != null && buyer.isBuyer()) {  // Assuming 'isBuyer' checks if the user is a buyer
//                    BuyerPanel.buyerPanel();  // Navigate to Buyer Panel
//                } else {
//                    System.out.println("Invalid credentials or not a buyer.");
//                }
//                break;
//            case 2: // Seller Login
//                user seller=Login.loginUserAndReturnUser();  // Call the Login class method
//                if (seller != null && seller.isSeller()) {  // Assuming 'isSeller' checks if the user is a seller
//                    SellerPanel.sellerPanel();  // Navigate to Seller Panel
//                } else {
//                    System.out.println("Invalid credentials or not a seller.");
//                }
//                break;
//            case 3: // Back to Main Menu
//                return;
//            default:
//                System.out.println("Invalid option. Try again.");
//        }
//    }
//}
public class BuyerSellerLogin {
    static Scanner sc = new Scanner(System.in);
    private static void login() {
        System.out.println("\n===== Login =====");
        System.out.println("1. Buyer Login");
        System.out.println("2. Seller Login");
        System.out.println("3. Back to Main Menu");
        System.out.print("Choose an option: ");
        int choice=Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1: // Buyer Login
                BuyerPanel.buyerPanel();
                break;
            case 2: // Seller Login
                SellerPanel.sellerPanel();
                break;
            case 3: // Back to Main Menu
                return;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }
}