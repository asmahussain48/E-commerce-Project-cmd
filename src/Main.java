import java.util.Scanner;
import entities.Product;  // Make sure you import the Product class

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. View All Products");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    // Call the fetchAllProducts method from the Product class to display all products
                    Product.viewAllProducts();  // Displays all products in a table format
                    break;
                case 2:
                    System.out.println("Exiting the program.");
                    return; // Exit the application
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
