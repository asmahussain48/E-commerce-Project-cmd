import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.Orders;
import utils.DatabaseConnection;


public class OrderManagment {

    public static void placeOrder(int userId) {
        String sql = "INSERT INTO orders (orders_user_id, total_amount, status, payment_status) VALUES (?, ?, ?, ?)";

        // Calculate total amount based on cart
        double totalAmount = calculateTotalAmount(userId);  // You would need to create this logic

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setDouble(2, totalAmount);
            stmt.setString(3, "pending");
            stmt.setString(4, "pending");

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Order placed successfully.");
            } else {
                System.out.println("Failed to place order.");
            }

        } catch (SQLException e) {
            System.out.println("Error placing order: " + e.getMessage());
        }
    }

    public static double calculateTotalAmount(int userId) {
        double totalAmount = 0.0;  // Initialize total amount to 0

        // SQL query to get all items from the user's cart (product_id, quantity)
        String sql = "SELECT c.product_id, c.quantity, p.price " +
                "FROM cart c JOIN products p ON c.product_id = p.id " +
                "WHERE c.user_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);  // Set the user_id in the query

            try (ResultSet rs = ps.executeQuery()) {
                // Iterate through the result set and calculate the total amount
                while (rs.next()) {
                    int quantity = rs.getInt("quantity");  // Get quantity from the cart
                    double price = rs.getDouble("price");  // Get price from the product table

                    // Add the total price for this item (quantity * price) to the overall total
                    totalAmount += quantity * price;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error calculating total amount: " + e.getMessage());
        }

        return totalAmount;  // Return the calculated total amount
    }


    public static void viewOrders(ArrayList<Orders> orderList) {
        if (orderList.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        System.out.println("----- Order History -----");
        for (Orders o : orderList) {
            o.display();
        }
        System.out.println("-------------------------");
    }

    public static void cancelOrder(ArrayList<Orders> orderList, Orders orderToCancel) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).equals(orderToCancel)) {
                orderList.remove(i);
                System.out.println("Order canceled successfully.");
                return;
            }
        }
        System.out.println("Order not found.");
    }
}
/*
 ArrayList<Order> orders = new ArrayList<>();

        Order o1 = new Order(1, "user1", new Date(), 1299.99);
        Order o2 = new Order(2, "user2", new Date(), 499.99);

        OrderManagement.placeOrder(orders, o1);
        OrderManagement.placeOrder(orders, o2);

        OrderManagement.viewOrders(orders);
        OrderManagement.cancelOrder(orders, o1);
        OrderManagement.viewOrders(orders);
 */

/*
Class Name:
OrderManagment
Method Names:
placeOrder
viewOrders
cancelOrder
 */

