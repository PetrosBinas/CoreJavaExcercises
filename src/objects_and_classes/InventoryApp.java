package objects_and_classes;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InventoryApp {

    public static void main(String[] args) {

        System.out.println("Welcome to Inventory App!");
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        mainLoop(sc, inventory);

    }

    public static void printMenu() {
        System.out.println("Available Actions:");
        System.out.println("1. Add Product to Inventory");
        System.out.println("2. Search For a Product by Name");
        System.out.println("3. Increase the Quantity of a Product");
        System.out.println("4. Decrease the Quantity of a Product");
        System.out.println("5. Print All Products");
        System.out.println("6. Print all Inventory Value");
        System.out.println("7. Exit Program");
    }

    public static Product findProduct(String pName, Inventory inventory) {
        Product product = inventory.findProductByName(pName);
        return product;
    }

    public static String getValidProdName(Scanner sc) {
        String pName = "";
        while (true) {
            try {
                System.out.println("Type The Product Name: ");
                pName = sc.next();
                if (!pName.isBlank()) {
                    return pName;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Not a Valid Product Name");
            }
        }
    }

    public static int getMenuChoice(Scanner sc) {
        while (true) {
            System.out.println("Type the Choice of the Action You Want to Take");
            int choice = 0;
            try {
                choice = sc.nextInt();
                if (choice >= 1 && choice <= 7) {
                    return choice;
                } else {
                    throw new Exception();
                }
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Not a Valid Integer!");
            } catch (Exception e) {
                System.out.println("Type an Integer in Range 1-7");
            }
        }
    }

    public static double getValidProdPrice(Scanner sc) {
        double pPrice = 0;
        while (true) {
            System.out.println("Type a Vald Price: ");
            try {
                pPrice = sc.nextDouble();
                if (pPrice > 0) {
                    return pPrice;
                } else {
                    throw new Exception();
                }
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Not a Valid Number");
            } catch (Exception e) {
                System.out.println("Price Must Be Bigger Than 0!");
            }
        }
    }

    public static long getValidProdQuantity(Scanner sc) {
        long pQuantity = 0;
        while (true) {
            System.out.println("Type a Valid Quantity: ");
            try {
                pQuantity = sc.nextLong();
                if (pQuantity > 0) {
                    return pQuantity;
                } else {
                    throw new Exception();
                }
            } catch (InputMismatchException e) {
                sc.next();
                System.out.println("Not a Valid Number");
            } catch (Exception e) {
                System.out.println("Price Must Be Bigger Than 0");
            }
        }
    }

    public static void mainLoop(Scanner sc, Inventory inventory) {
        while (true) {
            int menuChoice = 0;
            printMenu();
            menuChoice = getMenuChoice(sc);

            if (menuChoice == 1) { // Adding New Product
                String pName = getValidProdName(sc);
                double pPrice = getValidProdPrice(sc);
                long pQuantity = getValidProdQuantity(sc);
                Product p = new Product(pName, pPrice, pQuantity);
                inventory.addProduct(p);
            } else if (menuChoice == 2) { // Search if a Product Exists
                String pName = getValidProdName(sc);
                Product product = findProduct(pName, inventory);
                if (product != null) {
                    System.out.println("Product Exists!");
                    System.out.printf("Name: %s\nPrice: %f\nQuantity: %d\n", product.getName(), product.getPrice(), product.getQuantity());
                } else {
                    System.out.println("Product Doesn't Exist In Inventory!");
                }
            }
            else if (menuChoice == 3) {
                String pName = getValidProdName(sc);
                Product product = findProduct(pName, inventory);
                System.out.println("Type the Ammount of Products You Want to Add");
                long q = getValidProdQuantity(sc);
                product.increaseQuantity(q);
            }
            else if (menuChoice == 4) {
                String pName = getValidProdName(sc);
                Product product = findProduct(pName, inventory);
                System.out.println("Type The Ammount of Products You Want to Remove");
                long q = getValidProdQuantity(sc);
                product.decreaseQuantity(q);
            }
            else if (menuChoice == 5) {
                inventory.printInventory();
            }
            else if (menuChoice == 6) {
                inventory.totalInventoryValue();
            }
            else { break; }
        }
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
        System.out.printf("Total Inventory Value: %.2f$\n", totalValue);
        return totalValue;
    }

    public static Product findProductByName(String pName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(pName)) {
                return product;
            }
        }
        return null;
    }

}
