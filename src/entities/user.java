package entities;
import java.sql.*;


public class user {
    private int userId;
    private String username;
    private String email;
    private String password;
    private String fullName;
    private String phoneNumber;
    private String address;
    private String userType;


    public boolean isBuyer() {
        return "buyer".equalsIgnoreCase(this.userType);
    }

    public boolean isSeller() {
        return "seller".equalsIgnoreCase(this.userType);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId=userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username=username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password=password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName=fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber=phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address=address;
    }
    public user(String username, String email, String password, String userType, String fullName, String phoneNumber, String address) {
        this.username = username;      // Assigning the parameter to the class field
        this.email = email;
        this.password = password;
        this.userType = userType;      // 'buyer' or 'seller'
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }



    public user(int userId, String username, String email, String password, String fullName, String phoneNumber, String address) {
        this.userId=userId;
        this.username=username;
        this.email=email;
        this.password=password;
        this.fullName=fullName;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }

    public user(String username, String email, String password, String fullName, String phoneNumber, String address) {
        this.username=username;
        this.email=email;
        this.password=password;
        this.fullName=fullName;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }
    public void display() {
        System.out.println("------ User Details ------");
        System.out.println("User ID: " + userId);
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
        System.out.println("Full Name: " + fullName);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Address: " + address);
        System.out.println("--------------------------");
    }
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ecommerce_db"; // Update DB name
        String user = "root"; // Your MySQL username
        String pass = "Root"; // Your MySQL password
        return DriverManager.getConnection(url, user, pass);
    }
    public void saveToDatabase() {
        // Updated SQL query to include user_type
        String sql = "INSERT INTO users (username, email, acc_password, full_name, phone_number, address, user_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            // Set the values for the PreparedStatement, including user_type
            stmt.setString(1, this.username);
            stmt.setString(2, this.email);
            stmt.setString(3, this.password);
            stmt.setString(4, this.fullName);
            stmt.setString(5, this.phoneNumber);
            stmt.setString(6, this.address);
            stmt.setString(7, this.userType);  // Set user_type (buyer or seller)

            // Execute the update
            int rows = stmt.executeUpdate();

            if (rows > 0) {
                // Get the generated keys
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        this.userId = rs.getInt(1);  // Get the auto-generated user_id
                        System.out.println("User registered with ID: " + userId);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }




    //authentication of login
    // Authentication method
    public static boolean authenticate(String username, String password, String userType) {
        String sql = "SELECT * FROM users WHERE username = ? AND acc_password = ? AND user_type = ?";

        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, userType);
            ResultSet rs = stmt.executeQuery();

            return rs.next(); // Returns true if the user exists
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
            return false;
        }
    }

}



/*
user
Method Names:
getUserId
setUserId
getUsername
setUsername
getEmail
setEmail
getPassword
setPassword
getFullName
setFullName
getPhoneNumber
setPhoneNumber
getAddress
setAddress
display
getConnection (static method)
saveToDatabase
authenticate (static method)
 */