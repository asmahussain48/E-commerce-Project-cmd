import entities.user;

import java.sql.*;
import java.util.Scanner;

public class Login {
    private static int loggedInUserId = -1;
    public static user loginUserAndReturnUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        user currentUser = authenticate(username, password);

        if (currentUser != null) {
            loggedInUserId = currentUser.getUserId();  // Set the logged-in user's ID
        }

        return currentUser;
    }
    public static int getLoggedInUserId() {
        return loggedInUserId;  // Returns the logged-in user's ID
    }
    public static user authenticate(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND acc_password = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "Root");
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int userId = rs.getInt("user_id");
                String fullName = rs.getString("full_name");

                // Store logged-in user session
                UserSession.setUserSession(username);  // Save username and user_id

                // Create user object with the fetched details
                user loggedInUser = new user(
                        username,
                        rs.getString("email"),
                        password,
                        fullName,
                        rs.getString("phone_number"),
                        rs.getString("address"));
                loggedInUser.setUserId(userId);
                return loggedInUser;  // Return logged-in user with the userId
            }

        } catch (SQLException e) {
            System.out.println("Error fetching user: " + e.getMessage());
        }

        return null; // If login fails
    }

}



//
//public class Login {
//    public static void loginUser() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter username: ");
//        String username = scanner.nextLine();
//        System.out.print("Enter password: ");
//        String password = scanner.nextLine();
//
//        user loggedInUser = user.authenticate(username, password);
//        if (loggedInUser != null) {
//            System.out.println("Login successful! Welcome, " + loggedInUser.getFullName());
//        } else {
//            System.out.println("Login failed! Incorrect username or password.");
//        }
//    }
//}
// Login.loginUser(); in main class
/*
Class Name:
Login
Method Name:
loginUser
 */