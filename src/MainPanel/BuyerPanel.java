package MainPanel;

import entities.Product;

import java.util.Scanner;

public class BuyerPanel {
    static Scanner sc = new Scanner(System.in);
    public static void buyerPanel() {
        while (true) {
            System.out.println("\n===== Buyer Panel =====");
            System.out.println("1. View All Products");
            System.out.println("2. Search Products");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Remove Product from Cart");
            System.out.println("6. Place Order");
            System.out.println("7. View My Orders");
            System.out.println("8. Cancel Order");
            System.out.println("9. Update Profile");
            System.out.println("10. Logout");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    // Implement View All Products
                    System.out.println("View All Products");
                    Product.viewAllProducts();
                    break;
                case 2:
                    // Implement Search Products
                    System.out.println("Search Products");
                    break;
                case 3:
                    // Implement Add Product to Cart
                    System.out.println("Add Product to Cart");
                    break;
                case 4:
                    // Implement View Cart
                    System.out.println("View Cart");
                    break;
                case 5:
                    // Implement Remove Product from Cart
                    System.out.println("Remove Product from Cart");
                    break;
                case 6:
                    // Implement Place Order
                    PlaceOrder.placeOrder();
                    break;
                case 7:
                    // Implement View My Orders
                    System.out.println("View My Orders");
                    break;
                case 8:
                    // Implement Cancel Order
                    System.out.println("Cancel Order");
                    break;
                case 9:
                    // Implement Update Profile
                    System.out.println("Update Profile");
                    break;
                case 10:
                    System.out.println("Logging out...");
                    return; // Logout and go back to Main Menu
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
