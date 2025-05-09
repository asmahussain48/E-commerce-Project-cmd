public class UserSession {
    private static String username;  // Store username
    private static int userId;       // Store user ID

    // Set the logged-in user's details
    public static void setUserSession(String user, int id) {
        username = user;
        userId = id;
    }

    // Get the logged-in user's details
    public static String getUsername() {
        return username;
    }

    public static int getUserId() {
        return userId;
    }

    // Clear session when the user logs out
    public static void clearSession() {
        username = null;
        userId = -1;
    }
}
