import entities.Product;
import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static entities.Product.viewMyProducts;


public class ProductManager {static Scanner sc = new Scanner(System.in);

    public static void addNewProduct() {
        System.out.println("=== Add New Product ===");

        try {
            System.out.print("Enter category ID: ");
            int categoryId = Integer.parseInt(sc.nextLine());

            System.out.print("Enter product name: ");
            String name = sc.nextLine();

            System.out.print("Enter brand: ");
            String brand = sc.nextLine();

            System.out.print("Enter model: ");
            String model = sc.nextLine();

            System.out.print("Enter description: ");
            String description = sc.nextLine();

            System.out.print("Enter price: ");
            double price = Double.parseDouble(sc.nextLine());

            System.out.print("Enter quantity: ");
            int quantity = Integer.parseInt(sc.nextLine());

            System.out.print("Is the product available? (true/false): ");
            boolean isAvailable = Boolean.parseBoolean(sc.nextLine());

            // Create and insert product (without seller ID binding)
            Product product = new Product(name, brand, model, description, price, quantity, isAvailable);

            // Save to database (assumes you modify method to not require seller_id)
            product.saveToDatabaseWithCategory(categoryId);

            System.out.println("Product added successfully!");
            product.display();
        } catch (Exception e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
    }
    public static void updateProduct(int sellerId) {
        System.out.print("Enter Product ID to update: ");
        int productId = Integer.parseInt(sc.nextLine());

        Product product = Product.fetchProductById(productId);
        if (product != null) {
            System.out.println("Current Product Details:");
            product.display();

            System.out.print("Enter new Product Name (Leave blank to keep current): ");
            String name = sc.nextLine();
            if (!name.isEmpty()) product.setName(name);

            System.out.print("Enter new Product Brand (Leave blank to keep current): ");
            String brand = sc.nextLine();
            if (!brand.isEmpty()) product.setBrand(brand);

            System.out.print("Enter new Product Model (Leave blank to keep current): ");
            String model = sc.nextLine();
            if (!model.isEmpty()) product.setModel(model);

            System.out.print("Enter new Product Description (Leave blank to keep current): ");
            String description = sc.nextLine();
            if (!description.isEmpty()) product.setProductDescription(description);

            System.out.print("Enter new Product Price (Leave blank to keep current): ");
            String priceInput = sc.nextLine();
            if (!priceInput.isEmpty()) product.setPrice(Double.parseDouble(priceInput));

            System.out.print("Enter new Product Quantity (Leave blank to keep current): ");
            String quantityInput = sc.nextLine();
            if (!quantityInput.isEmpty()) product.setQuantity(Integer.parseInt(quantityInput));

            System.out.print("Is the Product Available (true/false, Leave blank to keep current): ");
            String availabilityInput = sc.nextLine();
            if (!availabilityInput.isEmpty()) product.setAvailable(Boolean.parseBoolean(availabilityInput));

            product.updateProductInDatabase();
        } else {
            System.out.println("Product not found.");
        }
    }
    public static void updateProfile(int sellerId) {
        System.out.print("Enter your new full name: ");
        String fullName = sc.nextLine();
        System.out.print("Enter your new phone number: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Enter your new address: ");
        String address = sc.nextLine();

        String sql = "UPDATE users SET full_name = ?, phone_number = ?, address = ? WHERE user_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, fullName);
            ps.setString(2, phoneNumber);
            ps.setString(3, address);
            ps.setInt(4, sellerId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Profile updated successfully.");
            } else {
                System.out.println("Error updating profile.");
            }
        } catch (SQLException e) {
            System.out.println("Error updating profile: " + e.getMessage());
        }
    }
    public static void manageStock(int sellerId) {
        System.out.println("Managing stock for products...");
        viewMyProducts(sellerId); // Display current products
        System.out.print("Enter Product ID to update stock: ");
        int productId = Integer.parseInt(sc.nextLine());
        System.out.print("Enter new quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        Product product = Product.fetchProductById(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.updateProductInDatabase(); // Update the quantity in the database
        } else {
            System.out.println("Product not found.");
        }
    }
    public static void viewOrdersReceived(int sellerId) {
        String sql = "SELECT o.id, o.order_date, o.total_amount, o.status, o.payment_status, u.username " +
                "FROM orders o " +
                "JOIN users u ON o.orders_user_id = u.user_id " +
                "WHERE o.orders_user_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, sellerId);
            ResultSet rs = ps.executeQuery();

            System.out.println("\nOrders Received:");
            System.out.printf("%-10s %-20s %-10s %-15s %-15s\n", "Order ID", "Username", "Date", "Total", "Status");
            System.out.println("------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-10d %-20s %-10s %-15.2f %-15s\n",
                        rs.getInt("id"), rs.getString("username"),
                        rs.getString("order_date"), rs.getDouble("total_amount"), rs.getString("status"));
            }

        } catch (SQLException e) {
            System.out.println("Error fetching orders: " + e.getMessage());
        }
    }
    public static void deleteProduct(int sellerId) {
        System.out.print("Enter Product ID to delete: ");
        int productId = Integer.parseInt(sc.nextLine());
        Product.deleteProductFromDatabase(productId);
    }
}
