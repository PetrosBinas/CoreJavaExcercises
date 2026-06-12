package objects_and_classes;

public class BankApp {

    static void main() {



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
