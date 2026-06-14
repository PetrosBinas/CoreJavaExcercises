package objects_and_classes;

import java.util.Scanner;

public class BankApp {

    static void main() {

        Scanner sc = new Scanner(System.in);

        logInInteract(sc);

    }

    static void logInInteract(Scanner sc) {

        System.out.println("Welcome to BinBank!");

        String firstName;
        String lastName;
        String concatName;
        String pass;

        while(true) {
            System.out.print("Type your First Name: ");
            firstName = sc.next();
            System.out.println();
            if(!firstName.isBlank()) {
                break;
            }
        }

        while(true) {
            System.out.print("Type Your Last Name: ");
            lastName = sc.next();
            System.out.println();
            if(!lastName.isBlank()) {
                break;
            }
        }

        while(true) {
            System.out.print("Type Your Banking Password: ");
            pass = sc.next();
            System.out.println();
            if(!pass.isBlank()){
                break;
            }
        }
    }

}

class BankAccount {

    private String ownerName;
    private double balance;
    private double accountNumber;
    private String accountPassword;

    BankAccount(){}

    BankAccount(String name, double b, double num, String pass) {

        ownerName = name;
        balance = b;
        accountNumber = num;
        accountPassword = pass;

    }

    public boolean validateUser(String name, String pass) {

        // returns true if the inputed password and name are equal to the instance info
        return name.equals(this.ownerName) && pass.equals(accountPassword);
    }
}
