
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Cart;
import entities.Product;
import utils.DatabaseConnection;

import static MainPanel.PayementOptions.*;
import static entities.Cart.addToCart;

public class CartManagement {
    static Scanner sc = new Scanner(System.in);

    //Add Cart
    public static void addProductToCart(int userId) {
        // Collect the product ID and quantity from the user
        System.out.print("Enter the product ID to add to cart: ");
        int productId = Integer.parseInt(sc.nextLine());

        System.out.print("Enter quantity: ");
        int quantity = Integer.parseInt(sc.nextLine());

        // Now call the addToCart method to insert the product into the cart
        addToCart(userId, productId, quantity);  // Passing the collected data to addToCart()
    }



    public static void updateCart(ArrayList<Product> cart, Product oldProduct, Product newProduct) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(oldProduct)) {
                cart.set(i, newProduct);  // Replace directly
                System.out.println("Cart updated successfully.");
                return;
            }
        }
        System.out.println("Product to update not found in cart.");
    }
}
/*
public class Main {
    public static void main(String[] args) {
        ArrayList<Product> cart = new ArrayList<>();

        Product p1 = new Product(1, "Phone", 699.99);
        Product p2 = new Product(2, "Laptop", 1199.99);

        CartManagement.addToCart(cart, p1);
        CartManagement.addToCart(cart, p2);

        CartManagement.viewCart(cart);

        Product updatedPhone = new Product(1, "Phone", 649.99); // Discounted
        CartManagement.updateCart(cart, p1, updatedPhone);

        CartManagement.viewCart(cart);
        CartManagement.removeFromCart(cart, updatedPhone);

        CartManagement.viewCart(cart);
    }
}
 */


/*
Class Name:
CartManagement
Method Names:
addToCart
viewCart
removeFromCart
updateCart

 */


