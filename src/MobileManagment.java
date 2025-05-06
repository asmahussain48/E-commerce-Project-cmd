import entities.Product;

import java.util.ArrayList;
import java.util.Scanner;


public class MobileManagment {


    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int nextId = 1;

    public static void MobileManages() throws Exception {


        while (true) {
            System.out.println("\n===== Mobile Store Management =====");
            System.out.println("1. New Mobiles");
            System.out.println("2. Old Mobiles");
            System.out.println("3. View All Products");
            System.out.println("4. Search Product");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> showSubMenu("New");
                    case 2 -> showSubMenu("Old");
                    case 3 -> listAllProducts();
                    case 4 -> searchProduct();
                    case 5 -> {
                        System.out.println("Thank you for using Mobile Store!");
                        return;
                    }
                    default -> System.out.println("Invalid option. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    static void showSubMenu(String type) {
        while (true) {
            System.out.println("\n" + type + " Mobiles:");
            System.out.println("1. Add " + type + " Mobile");
            System.out.println("2. Update " + type + " Mobile Info");
            System.out.println("3. Delete " + type + " Mobile");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");
            try {
                int subChoice = Integer.parseInt(sc.nextLine());
                switch (subChoice) {
                    case 1 -> addMobile(type);
                    case 2 -> updateMobile(type);
                    case 3 -> deleteMobile(type);
                    case 4 -> {
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    static void addMobile(String type) {
        try {
            System.out.print("Enter brand: ");
            String brand = sc.nextLine();
            System.out.print("Enter model: ");
            String model = sc.nextLine();

            double price = 0;
            while (true) {
                System.out.print("Enter price: ");
                try {
                    price = Double.parseDouble(sc.nextLine());
                    if (price < 0) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price. Enter a positive number.");
                }
            }

            int quantity;
            while (true) {
                System.out.print("Enter the Quantity: ");
                try {
                    quantity = Integer.parseInt(sc.nextLine());
                    if (quantity<0) throw new NumberFormatException();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid quantity. Enter a positive number.");
                }
            }

            boolean isAvailable = askAvailability();
            System.out.println("Enter the description of mobile: ");
            String description = sc.nextLine();

            products.add(new Product(nextId++, type, brand, model, description, price,quantity ,isAvailable));
            System.out.println(type + " mobile added successfully.");
        } catch (Exception e) {
            System.out.println("Error adding mobile. Please try again.");
        }

    }

    static void updateMobile(String type) {
        try {
            System.out.print("Enter Mobile ID to update: ");
            int id = Integer.parseInt(sc.nextLine());

            for (Product product : products) {
                if (product.getId() == id && product.getType().equalsIgnoreCase(type)) {
                    System.out.print("Enter new brand: ");
                    product.setBrand(sc.nextLine());
                    System.out.print("Enter new model: ");
                    product.setModel(sc.nextLine());

                    while (true) {
                        System.out.print("Enter new price: ");
                        try {
                            // Try setting the price using the setter
                            product.setPrice(Double.parseDouble(sc.nextLine()));  // This will validate the price inside the setter
                            break;  // If no exception, exit the loop
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid price. Enter a positive number.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());  // Print the error message from the setter
                        }
                    }

                    product.setAvailable(askAvailability());
                    System.out.println("Enter the description of mobile: ");
                    product.setDescription(sc.nextLine());
                    System.out.println("Mobile info updated.");
                    return;
                }
            }
            System.out.println("Mobile not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. ID must be a number.");
        }
    }

    static void deleteMobile(String type) {
        try {
            System.out.print("Enter Mobile ID to delete: ");
            int id = Integer.parseInt(sc.nextLine());

            boolean removed = products.removeIf(product -> product.getId() == id && product.getType().equalsIgnoreCase(type));
            if (removed) {
                System.out.println("Mobile deleted.");
            } else {
                System.out.println("Mobile not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. ID must be a number.");
        }
    }

    static void listAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No mobiles available.");
        } else {
            System.out.println("All Mobile Products:");
            for (Product product : products) {
                product.display();
            }
        }
    }

    static void searchProduct() {
        System.out.print("Enter brand or model to search: ");
        String keyword = sc.nextLine().toLowerCase();
        boolean found = false;
        for (Product product : products) {
            if (product.getBrand().toLowerCase().contains(keyword) || product.getModel().toLowerCase().contains(keyword)) {
                product.display();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching mobile found.");
        }
    }

    static boolean askAvailability() {
        while (true) {
            System.out.print("Is it available? (Yes/No): ");
            String input = sc.nextLine().trim().toLowerCase();
            if (input.equals("yes")) return true;
            else if (input.equals("no")) return false;
            else System.out.println("Invalid input. Please enter 'Yes' or 'No'.");
        }
    }
}