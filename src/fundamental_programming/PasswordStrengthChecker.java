package fundamental_programming;

import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {

        Password passObj = new Password();
        String pass = passPrompt();

        String strength = passObj.checkVars(pass);
        System.out.println("Your Password Strength is " + strength);

    }

    static String passPrompt() {

        String pass;
        Scanner sc = new Scanner(System.in);

        System.out.println("Type Your Password:");
        pass = sc.next();

        return pass;

    }

}

class Password {

    int passLength = 0;
    int hasDigit = 0;
    int hasUpperCase = 0;
    int hasLowerCase = 0;
    int strengthSum = 0;

    String checkVars(String pass) {

        if (pass.length() >= 8) {
            this.passLength = 1;
        }

        for (int i = 0; i < pass.length(); i++){

            if(Character.isUpperCase(pass.charAt(i)) && hasUpperCase == 0) {
                this.hasUpperCase = 1;
            }
            else if(Character.isLowerCase(pass.charAt(i)) && this.hasLowerCase == 0) {
                this.hasLowerCase = 1;
            }
            else if(Character.isDigit(pass.charAt(i)) && this.hasDigit == 0) {
                this.hasDigit = 1;
            }
        }

        this.strengthSum = this.hasLowerCase + this.hasUpperCase + this.hasDigit + this.passLength;
        System.out.println(this.strengthSum);

        return switch (this.strengthSum) {
            case 2, 3 -> "MEDIUM";
            case 4 -> "HIGH";
            default -> "LOW";
        };

    }

}
