package fundamental_programming;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SimpleAtm {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // creating the usr Account
        UserAccount acc = new UserAccount();

        // Initiate the Menu Logic
        acc.userPrompt(sc);

    }

}

class UserAccount {

    double usrBalance = 1000.0;

    void userPrompt(Scanner sc) {

        System.out.println("Welcome to BinBank!");
        int index;

        usrPromptLoop:
        while (true) {

            System.out.println("Transaction Type Menu");
            System.out.println("1 -> Check Balance");
            System.out.println("2 -> Deposit Money");
            System.out.println("3 -> Withdraw Money");
            System.out.println("4 -> Exit");
            System.out.println("Type the number that is connected with the type of transaction you want to make:");

            try {
                index = sc.nextInt();

                if (index >= 1 && index <= 4) {

                    switch (index) {
                        case 1 -> {
                            checkBalance();
                            index = 0;
                        }
                        case 2 -> {
                            depositMoney(sc);
                            index = 0;
                        }
                        case 3 -> {
                            withdrawMoney(sc);
                            index = 0;
                        }
                        default -> {
                            break usrPromptLoop;
                        }
                    }
                }
            }
            catch (InputMismatchException e) {
                sc.next();
                System.out.println("Type a valid Integer in range 1-4!");
            }
        }

    }

    void checkBalance() {

        System.out.println("~ ~ ~");
        System.out.printf("Your Balance is %.2f $", this.usrBalance);
        System.out.println("~ ~ ~");

    }

    void depositMoney(Scanner sc) {

        while (true) {
            System.out.println("Type the amount of money you want to deposit:");
            double depositAmount;

            try {
                depositAmount = sc.nextDouble();
                if (depositAmount > 0.0) {
                    this.usrBalance += depositAmount;
                    break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Type a valid numeric amount!");
            }
        }
    }

    void withdrawMoney(Scanner sc) {

        while (true) {
            System.out.println("Type the amount you want to withdraw:");
            double withdrawAmount;

            try {
                withdrawAmount = sc.nextDouble();
                if (withdrawAmount > 0) {
                    this.usrBalance -= withdrawAmount;
                    break;
                }
            }
            catch (InputMismatchException e) {
                System.out.println("Type a valid numeric amount!");
            }
        }
    }

}



