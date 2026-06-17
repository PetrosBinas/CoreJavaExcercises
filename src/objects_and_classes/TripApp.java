package objects_and_classes;

public class TripApp {

    static void main() {

    }

}

class Car {

    private String brand;
    private String model;
    private double consumption;
    private double fuelCapacity;

    //Constructor
    public Car(String b, String m, double c, double f) {

        this.brand = b;
        this.model = m;
        this.consumption = c;
        this.fuelCapacity = f;
    }

    //getters
    public String getBrand() { return this.brand; }
    public String getModel() { return this.model; }
    public double getConsumption() { return this.consumption; }
    public double getFuelCapacity() { return this.fuelCapacity; }

    //setters
    public void setBrand(String b) { this.brand = b; }
    public void setModel(String m) { this.model = m; }
    public void setConsumption(double c) { this.consumption = c; }
    public void setFuelCapacity(double f) { this.fuelCapacity = f; }

    //methods
    public double maxKm() {

        double kmPerLiter = 100 / consumption;
        double maxIndependencyOfCar = kmPerLiter * fuelCapacity;
    }
}
