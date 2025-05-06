
import java.util.Scanner;

public class PlaceOrder {
    static Scanner sc = new Scanner(System.in);
    static void placeOrder() {
        System.out.println("\n===== Place Order =====");
        System.out.println("1. Review Cart");
        System.out.println("2. Enter Address");
        System.out.println("3. Payment Options");
        System.out.print("Choose an option: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {
            case 1:
                // Implement Review Cart
                System.out.println("Review Cart");
                break;
            case 2:
                // Implement Enter Address
                System.out.println("Enter Address");
                break;
            case 3:
                // Implement Payment Options
                //PAyementOptions.paymentOptions();
                break;
            default:
                System.out.println("Invalid option. Try again.");
        }
    }
}
