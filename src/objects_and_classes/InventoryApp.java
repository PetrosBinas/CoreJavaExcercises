package objects_and_classes;

public class InventoryApp {

    public static void main(String[] args) {

    }
}

class Product {

    private String name;
    private double price;
    private long quantity;

    public Product() {}

    public Product(String name, double price, long quantity) {
        this.name = name;
        this. price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getName() { return this.name; }
    public double getPrice() { return this.price; }
    public long getQuantity() { return this.quantity; }

    // Setters
    public void setName(String newName) { this.name = newName; }
    public void setPrice(double newPrice) { this.price = newPrice; }
    public void setQuantity(long newQuantity) { this.quantity = newQuantity; }

    // Methods
    public void increaseQuantity(long q) { this.quantity += q; } // increases quantity by q
    public void decreaseQuantity(long q) { this.quantity -= q; } // decreases quantity by q
    public double getTotalValue() { return ((double) this.quantity) * this.price; }
    public void printInfo() {
        System.out.printf("Product Name: %s\nProduct Price: %f\nProduct Available Quantity: %d\n", this.name, this.price, this.quantity);
    }

}

class Inventory {

    private static Product[] products;
    private long productCount;

    // Methods
    public static void addProduct(Product newProduct) {
        
    }

}
