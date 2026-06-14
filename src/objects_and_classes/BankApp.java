package objects_and_classes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankApp {

    static void main() {

        //Demo Accounts
        BankAccount[] accounts = {
                new BankAccount("John Smith", 1500.75, "john123"),
                new BankAccount("Maria Johnson", 3200.50, "maria456"),
                new BankAccount("David Brown", 875.20, "david789"),
                new BankAccount("Sarah Wilson", 10000.00, "sarah321"),
                new BankAccount("Michael Davis", 250.00, "mike654"),
                new BankAccount("Emma Taylor", 5400.80, "emma987")
        };

        Scanner sc = new Scanner(System.in);

        BankAccount bankAcc = logInInteract(sc, accounts);
        if(bankAcc != null) { loggedInLogic(sc, bankAcc); }

    }

    static BankAccount logInInteract(Scanner sc, BankAccount[] accounts) {

        System.out.println("Welcome to BinBank!");

        String firstName;
        String lastName;
        String concatName;
        String pass;
        int attemptCounter = 3;

        masterLoop:
        while(true) {
            while (true) {
                System.out.print("Type your First Name: ");
                firstName = sc.next();
                System.out.println();
                if (!firstName.isBlank()) {
                    break;
                }
            }

            while (true) {
                System.out.print("Type Your Last Name: ");
                lastName = sc.next();
                System.out.println();
                if (!lastName.isBlank()) {
                    break;
                }
            }

            concatName = firstName + " " + lastName;

            while (true) {
                System.out.print("Type Your Banking Password: ");
                pass = sc.next();
                System.out.println();
                if (!pass.isBlank()) {
                    break;
                }
            }

            for(BankAccount account : accounts) {
                if(account.validateUser(concatName, pass)){
                    return account;
                }
            }
            attemptCounter--;
            if(attemptCounter == 0){ break masterLoop; }

            System.out.printf("False Credentials, Try Again! Attempts Remaining: %d\n", attemptCounter);
        }
        return null;
    }

    static void loggedInLogic(Scanner sc, BankAccount acc) {
        System.out.printf("Welcome to Your BinBank Menu %s", acc.getOwnerName());
        int choice = 0;

        mainWhile:
        while(true) {
            System.out.println("Choose an Integer For the Action of Your Choice:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            try {
                choice = sc.nextInt();
                if (choice < 1 || choice > 4) { throw new Exception(); }
            }
            catch (Exception e) {
                System.out.println("Type a Valid Integer in Range of 1-4");
            }

            // Deposit Logic
            if (choice == 1) {
                double b;
                while (true) {
                    System.out.println("Type The Ammount You Want to Deposit:");
                    try {
                        b = sc.nextDouble();
                        if (b < 0) { throw new Exception(); }
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Type A Valid Deposit Ammount!");
                        sc.next();
                    }
                    catch (Exception e) {
                        System.out.println("Type A Valid Deposit Ammount!");
                    }
                }

                b += acc.getBalance();
                acc.setBalance(b);
            }

            //Withdraw Logic
            else if(choice == 2) {
                double b;
                double newBalance = 0;
                while (true) {
                    System.out.println("Type The Ammount You Want to Withdraw:");
                    try {
                        b = sc.nextDouble();
                        if (b < 0 || b > acc.getBalance()) { throw new Exception(); }
                        break;
                    }
                    catch (InputMismatchException e) {
                        System.out.println("Type A Valid Withdrawal Ammount!");
                        sc.next();
                    }
                    catch (Exception e) {
                        System.out.println("Type A Valid Withdrawal Amount!");
                    }
                }

                newBalance = acc.getBalance() - b;
                acc.setBalance(newBalance);
            }

            //Check Balance Logic
            else if (choice == 3) {
                System.out.printf("%s Your Current Balance is: %.2f$\n", acc.getOwnerName(), acc.getBalance());
            }

            //Exit Logic
            else {
                break mainWhile;
            }
        }

    }

}

class BankAccount {

    private String ownerName;
    private double balance;
    private String accountPassword;

    BankAccount(){}

    BankAccount(String name, double b, String pass) {

        ownerName = name;
        balance = b;
        accountPassword = pass;

    }

    //getters
    public String getOwnerName() { return this.ownerName; }
    public double getBalance() { return this.balance; }

    //setters
    public void setBalance(double ammount) { this.balance = ammount; }

    public boolean validateUser(String name, String pass) {

        // returns true if the inputed password and name are equal to the instance info
        return name.equals(this.ownerName) && pass.equals(accountPassword);
    }
}
