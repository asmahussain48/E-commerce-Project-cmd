package entities;

import utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Orders {
    private int id;
    private int ordersUserId;
    private double totalAmount;
    private String status;
    private String paymentStatus;

    public Orders() {
    }

    public Orders(int id, int ordersUserId, double totalAmount, String status, String paymentStatus) {
        this.id=id;
        this.ordersUserId=ordersUserId;
        this.totalAmount=totalAmount;
        this.status=status;
        this.paymentStatus=paymentStatus;
    }

    public Orders(int ordersUserId, double totalAmount, String status, String paymentStatus) {
        this.ordersUserId=ordersUserId;
        this.totalAmount=totalAmount;
        this.status=status;
        this.paymentStatus=paymentStatus;
    }

    public int getOrdersUserId() {
        return ordersUserId;
    }

    public void setOrdersUserId(int ordersUserId) {
        this.ordersUserId=ordersUserId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount=totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status=status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus=paymentStatus;
    }
    public void display() {
        System.out.println("----- Order Details -----");
        System.out.println("Order ID        : " + id);
        System.out.println("User ID         : " + ordersUserId);
        System.out.println("Total Amount    : $" + String.format("%.2f", totalAmount));
        System.out.println("Order Status    : " + status);
        System.out.println("Payment Status  : " + paymentStatus);
        System.out.println("--------------------------");
    }
    public void saveToDatabase() {
        String sql = "INSERT INTO orders (orders_user_id, total_amount, status, payment_status) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, this.ordersUserId);
            ps.setDouble(2, this.totalAmount);
            ps.setString(3, this.status);
            ps.setString(4, this.paymentStatus);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Order saved successfully.");
            } else {
                System.out.println("Failed to save order.");
            }
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}
/*
Class Name:
Orders
Method Names
getOrdersUserId
setOrdersUserId
getTotalAmount
setTotalAmount
getStatus
setStatus
getPaymentStatus
setPaymentStatus
display
getConnection (static method)
saveToDatabase
 */