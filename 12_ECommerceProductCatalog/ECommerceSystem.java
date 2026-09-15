import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ECommerceSystem {
    static Scanner scanner = new Scanner(System.in);
    static Catalog catalog = new Catalog();
    static ShoppingCart cart = new ShoppingCart();
    static OrderHistory orderHistory = new OrderHistory();
    public static void main(String[] args) {
        System.out.println("╔═════════════════════════════════════╗");
        System.out.println("║   E-Commerce Product Catalog        ║");
        System.out.println("║   (Advanced OOP)                    ║");
        System.out.println("╚═════════════════════════════════════╝\n");
        // Initialize catalog
        initializeCatalog();
        boolean continueProgram = true;
        while(continueProgram) {
            displayMainMenu();
            System.out.print("Enter your choice (1-6): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!\n");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    browseCatalog();
                    break;
                case 2:
                    searchProducts();
                    break;
                case 3:
                    manageCart();
                    break;
                case 4:
                    checkout();
                    break;
                case 5:
                    viewOrderHistory();
                    break;
                case 6:
                    continueProgram = false;
                    System.out.println("\nThank you for shopping! Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!\n");
            }
        }
        scanner.close();
    }
    static void displayMainMenu() {
        System.out.println("\n╔═══════════════════════════════════╗");
        System.out.println("║      E-Commerce System            ║");
        System.out.println("╠═══════════════════════════════════╣");
        System.out.println("║  1. Browse Catalog                ║");
        System.out.println("║  2. Search Products               ║");
        System.out.println("║  3. Manage Shopping Cart          ║");
        System.out.println("║  4. Checkout                      ║");
        System.out.println("║  5. View Order History            ║");
        System.out.println("║  6. Exit                          ║");
        System.out.println("╚═══════════════════════════════════╝");
    }
    static void initializeCatalog() {
        catalog.addProduct(new Product("P001", "Java Programming Book", "Education", 499.99, 15));
        catalog.addProduct(new Product("P002", "Python Guide", "Education", 399.99, 20));
        catalog.addProduct(new Product("P003", "Wireless Mouse", "Electronics", 1299.99, 50));
        catalog.addProduct(new Product("P004", "USB-C Cable", "Electronics", 299.99, 100));
        catalog.addProduct(new Product("P005", "Keyboard Mechanical", "Electronics", 4999.99, 25));
        catalog.addProduct(new Product("P006", "Monitor 24inch", "Electronics", 12999.99, 10));
        catalog.addProduct(new Product("P007", "Notebook 100 pages", "Stationery", 99.99, 200));
        catalog.addProduct(new Product("P008", "Pen Pack (12 pcs)", "Stationery", 149.99, 100));
    }
    static void browseCatalog() {
        System.out.println("\n--- Product Catalog ---");
        catalog.displayAllProducts();
        System.out.print("\nEnter product ID to view details (or press Enter to skip): ");
        String productId = scanner.nextLine().trim();
        if (!productId.isEmpty()) {
            Product product = catalog.findProduct(productId);
            if (product != null) {
                product.displayDetails();
            } else {
                System.out.println("Product not found!");
            }
        }
    }
    static void searchProducts() {
        System.out.print("\nEnter search term (product name or category): ");
        String searchTerm = scanner.nextLine().toLowerCase().trim();
        ArrayList<Product> results = catalog.searchProducts(searchTerm);
        if (results.isEmpty()) {
            System.out.println("No products found!");
            return;
        }
        System.out.println("\n--- Search Results ---");
        for (int i = 0; i < results.size(); i++) {
            Product product = results.get(i);
            System.out.println((i + 1) + ". " + product.getProductId() + " - " + 
                              product.getProductName() + " (₹" + 
                              String.format("%.2f", product.getPrice()) + ")");
        }
    }
    static void manageCart() {
        boolean inCart = true;
        while(inCart) {
            System.out.println("\n--- Shopping Cart ---");
            cart.displayCart();
            System.out.println("\n1. Add to cart");
            System.out.println("2. Remove from cart");
            System.out.println("3. Update quantity");
            System.out.println("4. Back to main menu");
            System.out.print("Choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input!");
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice) {
                case 1:
                    addToCart();
                    break;
                case 2:
                    removeFromCart();
                    break;
                case 3:
                    updateCartQuantity();
                    break;
                case 4:
                    inCart = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    static void addToCart() {
        System.out.print("\nEnter product ID: ");
        String productId = scanner.nextLine().trim();
        Product product = catalog.findProduct(productId);
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }
        System.out.print("Enter quantity: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid quantity!");
            scanner.nextLine();
            return;
        }
        int quantity = scanner.nextInt();
        if (quantity <= 0) {
            System.out.println("Quantity must be positive!");
            return;
        }
        if (quantity > product.getStock()) {
            System.out.println("Insufficient stock! Available: " + product.getStock());
            return;
        }
        cart.addItem(product, quantity);
        System.out.println("✓ Added to cart!");
    }
    static void removeFromCart() {
        System.out.print("\nEnter product ID to remove: ");
        String productId = scanner.nextLine().trim();
        if (cart.removeItem(productId)) {
            System.out.println("✓ Item removed from cart!");
        } else {
            System.out.println("Item not found in cart!");
        }
    }
    static void updateCartQuantity() {
        System.out.print("\nEnter product ID: ");
        String productId = scanner.nextLine().trim();
        System.out.print("Enter new quantity: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid quantity!");
            scanner.nextLine();
            return;
        }
        int quantity = scanner.nextInt();
        if (quantity <= 0) {
            System.out.println("Quantity must be positive!");
            return;
        }
        if (cart.updateQuantity(productId, quantity)) {
            System.out.println("✓ Quantity updated!");
        } else {
            System.out.println("Item not found in cart!");
        }
    }
    static void checkout() {
        if (cart.isEmpty()) {
            System.out.println("\n📭 Cart is empty!");
            return;
        }
        System.out.println("\n--- Checkout ---");
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine().trim();
        System.out.print("Enter delivery address: ");
        String address = scanner.nextLine().trim();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine().trim();
        // Create order
        Order order = new Order(customerName, address, phone, cart);
        orderHistory.addOrder(order);
        // Display order summary
        System.out.println("\n--- Order Summary ---");
        order.displayOrderDetails();
        // Clear cart
        cart.clear();
        System.out.println("\n✓ Order placed successfully! Cart cleared.");
    }
    static void viewOrderHistory() {
        orderHistory.displayOrderHistory();
    }
}
// ==================== Product Class ====================
class Product {
    private String productId;
    private String productName;
    private String category;
    private double price;
    private int stock;
    public Product(String productId, String productName, String category, 
                  double price, int stock) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public boolean decreaseStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
            return true;
        }
        return false;
    }
    public void displayDetails() {
        System.out.println("\n--- Product Details ---");
        System.out.println("ID: " + productId);
        System.out.println("Name: " + productName);
        System.out.println("Category: " + category);
        System.out.println("Price: ₹" + String.format("%.2f", price));
        System.out.println("In Stock: " + stock + " units");
    }
}
// ==================== Catalog Class ====================
class Catalog {
    private ArrayList<Product> products;
    public Catalog() {
        this.products = new ArrayList<>();
    }
    public void addProduct(Product product) {
        products.add(product);
    }
    public Product findProduct(String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }
    public ArrayList<Product> searchProducts(String searchTerm) {
        ArrayList<Product> results = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().toLowerCase().contains(searchTerm) ||
                product.getCategory().toLowerCase().contains(searchTerm)) {
                results.add(product);
            }
        }
        return results;
    }
    public void displayAllProducts() {
        System.out.println("┌─────┬────────────────────────┬──────────────┬───────────┬────────┐");
        System.out.println("│ ID  │ Product Name           │ Category     │ Price     │ Stock  │");
        System.out.println("├─────┼────────────────────────┼──────────────┼───────────┼────────┤");
        for (Product product : products) {
            System.out.printf("│ %-3s │ %-22s │ %-12s │ ₹ %-7.2f │ %-6d │\n",
                            product.getProductId(),
                            product.getProductName(),
                            product.getCategory(),
                            product.getPrice(),
                            product.getStock());
        }
        System.out.println("└─────┴────────────────────────┴──────────────┴───────────┴────────┘");
    }
}
// ==================== Cart Item Class ====================
class CartItem {
    private Product product;
    private int quantity;
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getTotal() {
        return product.getPrice() * quantity;
    }
}
// ==================== Shopping Cart Class ====================
class ShoppingCart {
    private ArrayList<CartItem> items;
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }
    public void addItem(Product product, int quantity) {
        for (CartItem item : items) {
            if (item.getProduct().getProductId().equals(product.getProductId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }
    public boolean removeItem(String productId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getProductId().equals(productId)) {
                items.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean updateQuantity(String productId, int newQuantity) {
        for (CartItem item : items) {
            if (item.getProduct().getProductId().equals(productId)) {
                item.setQuantity(newQuantity);
                return true;
            }
        }
        return false;
    }
    public double getCartTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotal();
        }
        return total;
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public void clear() {
        items.clear();
    }
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("📭 Cart is empty");
            return;
        }
        System.out.println("┌─────┬──────────────────────┬──────────┬──────────┐");
        System.out.println("│ ID  │ Product              │ Qty      │ Total    │");
        System.out.println("├─────┼──────────────────────┼──────────┼──────────┤");
        for (CartItem item : items) {
            System.out.printf("│ %-3s │ %-20s │ %-8d │ ₹ %-6.2f │\n",
                            item.getProduct().getProductId(),
                            item.getProduct().getProductName(),
                            item.getQuantity(),
                            item.getTotal());
        }
        System.out.println("├─────┴──────────────────────┼──────────┼──────────┤");
        System.out.printf("│ Total Items: %-13d │          │ ₹ %-6.2f │\n",
                        items.size(), getCartTotal());
        System.out.println("└────────────────────────────┴──────────┴──────────┘");
    }
    public ArrayList<CartItem> getItems() {
        return new ArrayList<>(items);
    }
}
// ==================== Order Class ====================
class Order {
    private static int orderCounter = 1000;
    private int orderId;
    private String customerName;
    private String deliveryAddress;
    private String phoneNumber;
    private ArrayList<CartItem> items;
    private double totalAmount;
    private String orderDate;
    private String status;
    public Order(String customerName, String deliveryAddress, String phoneNumber, 
                ShoppingCart cart) {
        this.orderId = ++orderCounter;
        this.customerName = customerName;
        this.deliveryAddress = deliveryAddress;
        this.phoneNumber = phoneNumber;
        this.items = cart.getItems();
        this.totalAmount = cart.getCartTotal();
        this.orderDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.status = "Pending";
    }
    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getTotalAmount() { return totalAmount; }
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " + customerName);
        System.out.println("Address: " + deliveryAddress);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + status);
        System.out.println("\n--- Items ---");
        for (CartItem item : items) {
            System.out.println("  • " + item.getProduct().getProductName() + " x " + 
                              item.getQuantity() + " = ₹" + 
                              String.format("%.2f", item.getTotal()));
        }
        System.out.println("\nTotal Amount: ₹" + String.format("%.2f", totalAmount));
    }
}
// ==================== Order History Class ====================
class OrderHistory {
    private ArrayList<Order> orders;
    public OrderHistory() {
        this.orders = new ArrayList<>();
    }
    public void addOrder(Order order) {
        orders.add(order);
    }
    public void displayOrderHistory() {
        if (orders.isEmpty()) {
            System.out.println("\n📭 No orders placed yet!");
            return;
        }
        System.out.println("\n--- Order History ---");
        System.out.println("┌──────────┬──────────────────┬────────────┐");
        System.out.println("│ Order ID │ Customer         │ Amount     │");
        System.out.println("├──────────┼──────────────────┼────────────┤");
        for (Order order : orders) {
            System.out.printf("│ %-8d │ %-16s │ ₹ %-8.2f │\n",
                            order.getOrderId(),
                            order.getCustomerName(),
                            order.getTotalAmount());
        }
        System.out.println("└──────────┴──────────────────┴────────────┘");
    }
}
