
import java.util.ArrayList;
import entities.Product;
public class CartManagement {

    public static void addToCart(ArrayList<Product> cart, Product newProduct) {
        cart.add(newProduct);
        System.out.println("Product added to cart.");
    }

    public static void viewCart(ArrayList<Product> cart) {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("Items in your cart:");
        for (Product p : cart) {
            p.display();
        }
    }

    public static void removeFromCart(ArrayList<Product> cart, Product productToRemove) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).equals(productToRemove)) {
                cart.remove(i);
                System.out.println("Product removed from cart.");
                return;
            }
        }
        System.out.println("Product not found in cart.");
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


