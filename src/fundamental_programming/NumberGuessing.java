package fundamental_programming;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessing {

    static void main() {

        // num creation as an obj
        Scanner sc = new Scanner(System.in);
        Number numObj = new Number();
        numObj.createNum();

        boolean gameIsWon = checkIntLogic(numObj.num, sc);

        // print message depending on the result of the game
        if (gameIsWon) {
            System.out.println("Congratulations You Guessed Correct!");
        }
        else {
            System.out.println("Oh No Maybe Another Time :(");
        }

    }

    // Gets the User Input for a num and catches any bad input
    static int promptUsrForNum(Scanner sc) {

        int usrNum;

        while (true) {
            try {
                System.out.println("Type Your Guess:");
                usrNum = sc.nextInt();
                return usrNum;
            }
            catch (InputMismatchException e) {
                System.out.println("Not a Valid Integer!");
                sc.next();
            }
        }
    }

    // Logic That Combines the user input and the equality with the generated number
    static boolean checkIntLogic(int generatedInt, Scanner sc) {

        int usrNum;
        System.out.println("You have 10 tries to guess what integer I am thinking!");

        for (int i = 10; i > 0; i--) {

            usrNum = promptUsrForNum(sc);

            if (usrNum == generatedInt) {
                return true;
            }
        }
        return false;
    }

}

// Number Class
class Number {

    int num;

    // Creates Random 1-10 Number
    void createNum() {

        Random random = new Random();
        this.num = random.nextInt(10) + 1;

    }
}
