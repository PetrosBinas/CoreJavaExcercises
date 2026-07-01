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
    private static int productCount;

    // Getters
    public static Product[] getProducts() { return products; }
    public static int getProductCount() { return productCount; }

    //Setters
    public static void setProducts(Product[] newProductArr) { products = newProductArr; }
    private static void reloadProductCount() { productCount = products.length; }

    // Methods

    // Adds a new product by manually making the products array bigger by 1 place
    public static void addProduct(Product newProduct) {
        Product[] temp = new Product[productCount + 1];

        for (int i = 0; i < productCount; i++) {
            temp[i] = products[i];
        }
        temp[productCount] = newProduct;
        products = temp;
        reloadProductCount();
    }

    public static void printInventory() {
        String pName;
        for (Product product : products) {
            pName = product.getName();
            System.out.println(pName);
        }
    }

    public static double totalInventoryValue() {
        double totalValue = 0;
        double productPrice = 0;
        double productQuantity = 0;
        for (Product product : products) {
            productPrice = product.getPrice();
            productQuantity = (double) product.getQuantity();
            totalValue += (productQuantity * productPrice);
        }
        System.out.printf("Total Inventory Value: %.2f$", totalValue);
        return totalValue;
    }

    public static Product findProductByName(String pName) {
        for (Product product : products) {
            if (product.getName().equals(pName)) {
                return product;
            }
        }
        return null;
    }

}
