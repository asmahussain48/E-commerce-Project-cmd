
import entities.user;

import java.sql.*;
import java.util.Scanner;

public class BuyerSellerLogin {
    static Scanner sc = new Scanner(System.in);
    public static void handleBuyerLogin() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Buyer Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Buyer Password: ");
        String password = sc.nextLine();

        if (authenticate(username, password, "buyer")) {
            System.out.println("Buyer logged in successfully!"+ UserSession.getUserId());
            BuyerPanel.buyerPanel();
            // Here you can add further actions for buyer
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

        if (authenticate(username, password, "seller")) {
            System.out.println("Seller logged in successfully! with ID: " + UserSession.getUserId() );
            SellerPanel.sellerPanel();
            // Here you can add further actions for seller
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }
    public static boolean authenticate(String username, String password, String role) {
        String sql = "SELECT * FROM users WHERE username = ? AND acc_password = ? AND user_type = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "Root");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, role);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("user_id");

                // Set session with correct userId
                UserSession.setUserSession(username, userId);

                return true;
            }

        } catch (SQLException e) {
            System.out.println("Error fetching user: " + e.getMessage());
        }

        return false;
    }

}