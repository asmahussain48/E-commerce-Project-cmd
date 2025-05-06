//import java.util.Scanner;
//
//public class MobileStoreApp {
//    static Scanner sc = new Scanner(System.in);
//
//    public static void main(String[] args) {
//        while (true) {
//            System.out.println("\n===== Main Menu =====");
//            System.out.println("1. Login");
//            System.out.println("2. Register");
//            System.out.println("3. Exit");
//            System.out.print("Choose an option: ");
//            int choice = Integer.parseInt(sc.nextLine());
//
//            switch (choice) {
//                case 1: // Login
//                    login();
//                    break;
//                case 2: // Register
//                    register();
//                    break;
//                case 3: // Exit
//                    System.out.println("Thank you for using the Mobile Store App!");
//                    return; // Exit the program
//                default:
//                    System.out.println("Invalid option. Try again.");
//            }
//        }
//    }
//
//    // Login method (simplified)
//    private static void login() {
//        System.out.println("\n===== Login =====");
//        System.out.println("1. Buyer Login");
//        System.out.println("2. Seller Login");
//        System.out.println("3. Back to Main Menu");
//        System.out.print("Choose an option: ");
//        int choice = Integer.parseInt(sc.nextLine());
//
//        switch (choice) {
//            case 1: // Buyer Login
//                buyerPanel();
//                break;
//            case 2: // Seller Login
//                sellerPanel();
//                break;
//            case 3: // Back to Main Menu
//                return;
//            default:
//                System.out.println("Invalid option. Try again.");
//        }
//    }
//
//    // Register method (simplified)
//    private static void register() {
//        System.out.println("\n===== Register =====");
//        System.out.println("1. Buyer Register");
//        System.out.println("2. Seller Register");
//        System.out.println("3. Back to Main Menu");
//        System.out.print("Choose an option: ");
//        int choice = Integer.parseInt(sc.nextLine());
//
//        switch (choice) {
//            case 1: // Buyer Register
//                // Implement buyer registration logic
//                System.out.println("Buyer registration not implemented yet.");
//                break;
//            case 2: // Seller Register
//                // Implement seller registration logic
//                System.out.println("Seller registration not implemented yet.");
//                break;
//            case 3: // Back to Main Menu
//                return;
//            default:
//                System.out.println("Invalid option. Try again.");
//        }
//    }
//
//    // Buyer Panel
//    private static void buyerPanel() {
//        while (true) {
//            System.out.println("\n===== Buyer Panel =====");
//            System.out.println("1. View All Products");
//            System.out.println("2. Search Products");
//            System.out.println("3. Add Product to Cart");
//            System.out.println("4. View Cart");
//            System.out.println("5. Remove Product from Cart");
//            System.out.println("6. Place Order");
//            System.out.println("7. View My Orders");
//            System.out.println("8. Cancel Order");
//            System.out.println("9. Update Profile");
//            System.out.println("10. Logout");
//            System.out.print("Choose an option: ");
//            int choice = Integer.parseInt(sc.nextLine());
//
//            switch (choice) {
//                case 1:
//                    // Implement View All Products
//                    System.out.println("View All Products");
//                    break;
//                case 2:
//                    // Implement Search Products
//                    System.out.println("Search Products");
//                    break;
//                case 3:
//                    // Implement Add Product to Cart
//                    System.out.println("Add Product to Cart");
//                    break;
//                case 4:
//                    // Implement View Cart
//                    System.out.println("View Cart");
//                    break;
//                case 5:
//                    // Implement Remove Product from Cart
//                    System.out.println("Remove Product from Cart");
//                    break;
//                case 6:
//                    // Implement Place Order
//                    placeOrder();
//                    break;
//                case 7:
//                    // Implement View My Orders
//                    System.out.println("View My Orders");
//                    break;
//                case 8:
//                    // Implement Cancel Order
//                    System.out.println("Cancel Order");
//                    break;
//                case 9:
//                    // Implement Update Profile
//                    System.out.println("Update Profile");
//                    break;
//                case 10:
//                    System.out.println("Logging out...");
//                    return; // Logout and go back to Main Menu
//                default:
//                    System.out.println("Invalid option. Try again.");
//            }
//        }
//    }
//
//    // Seller Panel
//    private static void sellerPanel() {
//        while (true) {
//            System.out.println("\n===== Seller Panel =====");
//            System.out.println("1. Add New Product");
//            System.out.println("2. View My Products");
//            System.out.println("3. Update Product");
//            System.out.println("4. Delete Product");
//            System.out.println("5. View Orders Received");
//            System.out.println("6. Manage Stock");
//            System.out.println("7. Update Profile");
//            System.out.println("8. Logout");
//            System.out.print("Choose an option: ");
//            int choice = Integer.parseInt(sc.nextLine());
//
//            switch (choice) {
//                case 1:
//                    // Implement Add New Product
//                    System.out.println("Add New Product");
//                    break;
//                case 2:
//                    // Implement View My Products
//                    System.out.println("View My Products");
//                    break;
//                case 3:
//                    // Implement Update Product
//                    System.out.println("Update Product");
//                    break;
//                case 4:
//                    // Implement Delete Product
//                    System.out.println("Delete Product");
//                    break;
//                case 5:
//                    // Implement View Orders Received
//                    System.out.println("View Orders Received");
//                    break;
//                case 6:
//                    // Implement Manage Stock
//                    System.out.println("Manage Stock");
//                    break;
//                case 7:
//                    // Implement Update Profile
//                    System.out.println("Update Profile");
//                    break;
//                case 8:
//                    System.out.println("Logging out...");
//                    return; // Logout and go back to Main Menu
//                default:
//                    System.out.println("Invalid option. Try again.");
//            }
//        }
//    }
//
//    // Payment System (for buyers)
//    private static void placeOrder() {
//        System.out.println("\n===== Place Order =====");
//        System.out.println("1. Review Cart");
//        System.out.println("2. Enter Address");
//        System.out.println("3. Payment Options");
//        System.out.print("Choose an option: ");
//        int choice = Integer.parseInt(sc.nextLine());
//
//        switch (choice) {
//            case 1:
//                // Implement Review Cart
//                System.out.println("Review Cart");
//                break;
//            case 2:
//                // Implement Enter Address
//                System.out.println("Enter Address");
//                break;
//            case 3:
//                // Implement Payment Options
//                paymentOptions();
//                break;
//            default:
//                System.out.println("Invalid option. Try again.");
//        }
//    }
//
//    // Payment System (options for buyers)
//    private static void paymentOptions() {
//        System.out.println("\n===== Payment Options =====");
//        System.out.println("1. Cash on Delivery (COD)");
//        System.out.println("2. Credit/Debit Card");
//        System.out.println("3. Mobile Wallets (Easypaisa/JazzCash)");
//        System.out.print("Choose a payment method: ");
//        int choice = Integer.parseInt(sc.nextLine());
//
//        switch (choice) {
//            case 1:
//                // Implement Cash on Delivery
//                System.out.println("Cash on Delivery selected");
//                break;
//            case 2:
//                // Implement Credit/Debit Card Payment
//                System.out.println("Credit/Debit Card selected");
//                break;
//            case 3:
//                // Implement Mobile Wallets Payment
//                System.out.println("Mobile Wallet selected");
//                break;
//            default:
//                System.out.println("Invalid option. Try again.");
//        }
//    }
//}
