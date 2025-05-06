package entities;

import java.sql.*;

public class Cart {

    private int id;
    private int userId;
    private int productId;
    private int quantity;

    public Cart() {}

    public Cart(int userId, int productId, int quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Database connection method
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ecommerce_db"; // Update if your DB is named differently
        String user = "root"; // Your MySQL username
        String pass = "Root"; // Your MySQL password
        return DriverManager.getConnection(url, user, pass);
    }

    // Add product to cart in the database
    public static void addToCart(int userId, int productId, int quantity) {
        String sql = "INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "Root");
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Set parameters
            ps.setInt(1, userId);  // The logged-in user's ID
            ps.setInt(2, productId);  // The ID of the product the user is adding
            ps.setInt(3, quantity);  // The quantity the user wants to add

            // Execute the insert query
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Product added to cart successfully.");
            } else {
                System.out.println("Failed to add product to cart.");
            }

        } catch (SQLException e) {
            System.out.println("Error adding to cart: " + e.getMessage());
        }
    }


    // View all products in the cart
    public static void viewCart(int userId) {
        // SQL query to select all products from the cart based on the user ID
        String sql = "SELECT p.id, p.name, p.brand, p.model, p.product_description, p.price, c.quantity " +
                "FROM cart c " +
                "JOIN products p ON c.product_id = p.id " +
                "WHERE c.user_id = ?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "Root");
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Set the userId parameter to the SQL query
            ps.setInt(1, userId);

            // Execute the query and get the results
            ResultSet rs = ps.executeQuery();

            // Print a table header for better readability
            System.out.printf("%-10s %-20s %-15s %-15s %-30s %-10s %-10s\n",
                    "ID", "Name", "Brand", "Model", "Description", "Price", "Quantity");
            System.out.println("----------------------------------------------------------------------------------------");

            // Loop through the result set and display the products in the cart
            boolean isEmpty = true;
            while (rs.next()) {
                isEmpty = false; // Found at least one product in cart
                System.out.printf("%-10d %-20s %-15s %-15s %-30s $%-10.2f %-10d\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("product_description"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"));
            }

            if (isEmpty) {
                System.out.println("Your cart is empty.");
            }

        } catch (SQLException e) {
            System.out.println("Error fetching cart items: " + e.getMessage());
        }
    }


    // Remove a product from the cart
    public static void removeFromCart(int userId, int productIdToRemove) {
        String sql = "DELETE FROM cart WHERE user_id = ? AND product_id = ?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "Root");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);  // Set the user ID
            ps.setInt(2, productIdToRemove);  // Set the product ID

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Product removed from cart.");
            } else {
                System.out.println("Product not found in cart.");
            }

        } catch (SQLException e) {
            // Print the full stack trace for debugging
            e.printStackTrace();
            System.out.println("Error removing product from cart: " + e.getMessage());
        }
    }
    public static void reviewCart(int userId) {
        // SQL query to select all products from the cart based on the user ID
        String sql = "SELECT p.id, p.name, p.brand, p.model, p.product_description, p.price, c.quantity " +
                "FROM cart c " +
                "JOIN products p ON c.product_id = p.id " +
                "WHERE c.user_id = ?";

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "Root");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId); // Set the user ID

            ResultSet rs = ps.executeQuery();

            // Print a table header for better readability
            System.out.printf("%-10s %-20s %-15s %-15s %-30s %-10s %-10s\n",
                    "ID", "Name", "Brand", "Model", "Description", "Price", "Quantity");
            System.out.println("----------------------------------------------------------------------------------------");

            // Loop through the result set and display the products in the cart
            while (rs.next()) {
                System.out.printf("%-10d %-20s %-15s %-15s %-30s $%-10.2f %-10d\n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("product_description"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching cart items: " + e.getMessage());
        }
    }


    // Update the quantity of a product in the cart
    public static void updateCart(int userId, int productId, int newQuantity) {
        String sql = "UPDATE cart SET quantity = ? WHERE user_id = ? AND product_id = ?";

        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, newQuantity); // Set the new quantity
            ps.setInt(2, userId); // Set user ID
            ps.setInt(3, productId); // Set product ID

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Cart updated successfully.");
            } else {
                System.out.println("Failed to update cart.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating cart: " + e.getMessage());
        }
    }
}
