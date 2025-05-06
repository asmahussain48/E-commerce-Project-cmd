
import java.util.Scanner;
import entities.user; // Assuming you have a User class that saves users to the database

public class BuyerSellerRegister {
    static Scanner sc = new Scanner(System.in);
    public static void buyerRegister() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n===== Buyer Registration =====");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        System.out.print("Enter Full Name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        // Create a new User object with 'buyer' user type
        user newUser = new user(username, email, password, "buyer", fullName, phoneNumber, address);

        // Call saveToDatabase to save the user in the database
        newUser.saveToDatabase();
        BuyerPanel.buyerPanel();
    }

    public static void sellerRegister() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n===== Seller Registration =====");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();
        System.out.print("Enter Full Name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        // Create a new User object with 'seller' user type
        user newUser = new user(username, email, password, "seller", fullName, phoneNumber, address);

        // Call saveToDatabase to save the user in the database
        newUser.saveToDatabase();
        SellerPanel.sellerPanel();
    }

}
