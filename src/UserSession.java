import java.sql.*;

public class UserSession {
    private static String username;
    private static int userId;

    // Set the logged-in user's details
    public static void setUserSession(String user) {
        username = user;

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "Root");

            // Fetch user ID from the database
            String sql = "SELECT user_id FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userId = resultSet.getInt("user_id");
            } else {
                userId = -1;  // If not found, set to invalid
            }

            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getUsername() {
        return username;
    }

    public static int getUserId() {
        return userId;
    }

    public static void clearSession() {
        username = null;
        userId = -1;
    }
    public static void setUserSession(String user, int id) {
        username = user;
        userId = id;
    }

}
