package entities;

import java.sql.*;

public class Product extends category {
    private int id;
    private String name;
    private String brand;
    private String model;
    private String productDescription;
    private double price;
    private int quantity;
    private boolean isAvailable;

    public Product() {
        super();
    }

    public Product(int id, String name, String brand, String model, String productDescription, double price, int quantity, boolean isAvailable) {
        super();
        this.id=id;
        this.name=name;
        this.brand=brand;
        this.model=model;
        this.productDescription=productDescription;
        this.price=price;
        this.quantity=quantity;
        this.isAvailable=isAvailable;
    }

    public Product(String name, String brand, String model, String productDescription, double price, int quantity, boolean isAvailable) {
        super();
        this.name=name;
        this.brand=brand;
        this.model=model;
        this.productDescription=productDescription;
        this.price=price;
        this.quantity=quantity;
        this.isAvailable=isAvailable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand=brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model=model;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription=productDescription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be a positive value.");
        }
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity=quantity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable=available;
    }
    // Database connection method
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/ecommerce_db"; // change DB name
        String user = "root"; // change as needed
        String password = "Root"; // change as needed
        return DriverManager.getConnection(url, user, password);
    }
    // Insert product into database
    public void saveToDatabase() {
        String sql = "INSERT INTO products (name, brand, model, product_description, price, quantity, is_available) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(2, name);
            ps.setString(3, brand);
            ps.setString(4, model);
            ps.setString(5, productDescription);
            ps.setDouble(6, price);
            ps.setInt(7, quantity);
            ps.setBoolean(8, isAvailable);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    this.id = rs.getInt(1); // set generated id
                    System.out.println("Product saved with ID: " + id);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error saving product: " + e.getMessage());
        }
    }
    //id
    public static Product fetchProductById(int productId) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "Root");
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, productId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("product_description"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getBoolean("is_available")

                );
            }

        } catch (SQLException e) {
            System.out.println("Error fetching product: " + e.getMessage());
        }

        return null;
    }

    // Display method for console apps
//    public void display() {
//        System.out.println("Product ID: " + id);
//        System.out.println("Name: " + name);
//        System.out.println("Brand: " + brand);
//        System.out.println("Model: " + model);
//        System.out.println("Description: " + productDescription);
//        System.out.println("Price: $" + price);
//        System.out.println("Quantity: " + quantity);
//        System.out.println("Category Type: " + getType());
//        System.out.println("Available: " + (isAvailable ? "Yes" : "No"));
//        System.out.println("-----------------------------");
//    }
    public void display() {
        System.out.printf("%-10s %-20s %-15s %-15s %-30s %-10s %-10s %-12s\n",
                "ID", "Name", "Brand", "Model", "Description", "Price", "Quantity", "Available");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("%-10d %-20s %-15s %-15s %-30s $%-10.2f %-10d %-12s\n",
                id, name, brand, model, productDescription, price, quantity, (isAvailable ? "Yes" : "No"));
        System.out.println("----------------------------------------------------------------------------------------");
    }
    public static void viewAllProducts() {
        String sql = "SELECT * FROM products";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "Root");
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.printf("%-10s %-20s %-15s %-15s %-30s %-10s %-10s %-12s\n",
                    "ID", "Name", "Brand", "Model", "Description", "Price", "Quantity", "Available");
            System.out.println("----------------------------------------------------------------------------------------");

            while (rs.next()) {
                Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("product_description"),
                        rs.getDouble("price"),
                        rs.getInt("quantity"),
                        rs.getBoolean("is_available")
                );
                // Display each product in the table format
                product.display();
            }

        } catch (SQLException e) {
            System.out.println("Error fetching all products: " + e.getMessage());
        }
    }



    public void updateProductInDatabase() {
        String sql = "UPDATE products SET name=?, brand=?, model=?, product_description=?, price=?, quantity=?, is_available=? WHERE id=?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, brand);
            ps.setString(3, model);
            ps.setString(4, productDescription);
            ps.setDouble(5, price);
            ps.setInt(6, quantity);
            ps.setBoolean(7, isAvailable);
            ps.setInt(8, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Product updated in database.");
            } else {
                System.out.println("No product found with ID " + id);
            }
        } catch (SQLException e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
    }

    public static void deleteProductFromDatabase(int productId) {
        String sql = "DELETE FROM products WHERE id=?";
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "root", "Root");
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, productId);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Product deleted from database.");
            } else {
                System.out.println("No product found with ID " + productId);
            }
        } catch (SQLException e) {
            System.out.println("Error deleting product: " + e.getMessage());
        }
    }
/*
Class Name:
Product
Method Names:
getCategoryId
setCategoryId
getName
setName
getBrand
setBrand
getModel
setModel
getProductDescription
setProductDescription
getPrice
setPrice
getQuantity
setQuantity
isAvailable
setAvailable
getConnection (private method)
saveToDatabase
display
updateProductInDatabase
deleteProductFromDatabase (static method)
 */





}


/*
// Create Product object                                    these are variables
        Product product = new Product(categoryId, name, brand, model, description, price, quantity, isAvailable);
        // Save to database
        product.saveToDatabase();
 */