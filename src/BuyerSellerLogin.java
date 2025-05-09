
import entities.user;
import java.util.Scanner;

public class BuyerSellerLogin {
    static Scanner sc = new Scanner(System.in);
    public static void handleBuyerLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Buyer Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Buyer Password: ");
        String password = sc.nextLine();

        if (user.authenticate(username, password, "buyer")) {
            System.out.println("Buyer logged in successfully!");
            BuyerPanel.buyerPanel();
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }
    public static void handleSellerLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Seller Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Seller Password: ");
        String password = sc.nextLine();

        if (user.authenticate(username, password,"seller")) {
            System.out.println("Seller logged in successfully!");
            SellerPanel.sellerPanel();
            // Here you can add further actions for seller
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }
}