
import java.util.ArrayList;
import entities.Orders;
public class OrderManagment {

    public static void placeOrder(ArrayList<Orders> orderList, Orders newOrder) {
        orderList.add(newOrder);
        System.out.println("Order placed successfully.");
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

