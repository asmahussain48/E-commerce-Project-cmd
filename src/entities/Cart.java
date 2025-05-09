package entities;
import utils.DatabaseConnection;

import java.sql.*;

public class Cart {
    private int id;
    private int productId;
    private int quantity;

    public Cart(int id, int productId, int quantity) {
        this.id=id;
        this.productId=productId;
        this.quantity=quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId=productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ecommerce_db";
        String user = "root";
        String pass = "Root";
        return DriverManager.getConnection(url, user, pass);
    }
    // Add product to cart in the database
    public static void addToCart(int userId, int productId, int quantity) {
        String sql = "INSERT INTO cart (user_id, product_id, quantity) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, productId);
            stmt.setInt(3, quantity);

            int rows = stmt.executeUpdate();
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
    /*
    This code loops through each product in the cart (from the database query result)
    and prints the product’s details in a formatted way (with spaces for alignment).
     */
    public static void viewCart(int userId) {
        // SQL query to select all products from the cart based on the user ID
        String sql = "SELECT * FROM cart";

        try (Connection con = DatabaseConnection.getConnection();
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
            boolean isEmpty = true;  //we assume the cart is empty at first.
            while (rs.next()) {  // While there is a next row in the result set
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

        try (Connection con = DatabaseConnection.getConnection();
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

        try (Connection con = DatabaseConnection.getConnection();
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

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
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
