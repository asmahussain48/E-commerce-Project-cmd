
import java.util.Scanner;

public class SellerPanel {
    static Scanner sc = new Scanner(System.in);
    public static void sellerPanel() {
        while (true) {
            System.out.println("\n===== Seller Panel =====");
            System.out.println("1. Add New Product");
            System.out.println("2. View My Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. View Orders Received");
            System.out.println("6. Manage Stock");
            System.out.println("7. Update Profile");
            System.out.println("8. Logout");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    // Implement Add New Product
                    System.out.println("Add New Product");
                    break;
                case 2:
                    // Implement View My Products
                    System.out.println("View My Products");
                    break;
                case 3:
                    // Implement Update Product
                    System.out.println("Update Product");
                    break;
                case 4:
                    // Implement Delete Product
                    System.out.println("Delete Product");
                    break;
                case 5:
                    // Implement View Orders Received
                    System.out.println("View Orders Received");
                    break;
                case 6:
                    // Implement Manage Stock
                    System.out.println("Manage Stock");
                    break;
                case 7:
                    // Implement Update Profile
                    System.out.println("Update Profile");
                    break;
                case 8:
                    System.out.println("Logging out...");
                    return; // Logout and go back to Main Menu
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
