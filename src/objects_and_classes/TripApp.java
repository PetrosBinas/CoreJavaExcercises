package objects_and_classes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TripApp {

    static void main() {

        Scanner sc = new Scanner(System.in);
        Car clientCar = clientPrompt(sc);
    }

    static Car clientPrompt(Scanner sc) {

        String brand;
        String model;
        double consumption;
        double fuelCapacity;

        while(true) {
             try {
                 System.out.println("Type Your Car's Brand:");
                 brand = sc.nextLine();
                 break;
             }
             catch (Exception e) {
                 System.out.println("Brand Field Cannot be Empty!");
             }
        }

        while(true) {
            try {
                System.out.println("Type your Car's Model:");
                model = sc.nextLine();
                if(!model.isBlank()) { break; }
            }
            catch (Exception e) {
                System.out.println("Model Field Cannot be Empty!");
            }
        }

        while(true) {
            try {
                System.out.println("Type The Consumption of Your Car per 100 km:");
                consumption = sc.nextDouble();
                if(consumption <= 0) {
                    throw new Exception();
                }
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Type A Valid Number for Your Vehicle Consumption!");
            }
            catch (Exception e) {
                System.out.println("Consumption Cannot Be a Negative Number!");
            }
        }

        while(true) {
            try {
                System.out.println("Type The Fuel Capacity of Your Car:");
                fuelCapacity = sc.nextDouble();
                if(fuelCapacity <= 0) {
                    throw new Exception();
                }
                break;
            }
            catch (InputMismatchException e) {
                System.out.println("Type a Valid Number for Your Vehicle Fuel Capacity!");
            }
            catch (Exception e) {
                System.out.println("Fuel Capacity Cannot be a Negative Number!");
            }
        }

        return new Car(brand, model, consumption, fuelCapacity);
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
        return kmPerLiter * fuelCapacity; //returning max Km the Car Object can travel with its autonomy
    }
}
