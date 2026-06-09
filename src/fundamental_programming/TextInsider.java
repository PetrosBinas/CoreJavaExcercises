package fundamental_programming;

import java.lang.reflect.Array;
import java.util.Scanner;

public class TextInsider {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Text txt = new Text();
        // get the text value for the txt obj from user
        txt.getText(sc);
        // filling the text info counters with the object method getTextInfo()
        txt.getTextInfo();
        // printing out the stats of the user text input
        txt.printTextInfo();

    }

}

class Text {

    String text;
    int charsCount;
    int lettersCount;
    int digitsCount;
    int spaceCount;
    int vowelsCount;

    void getText(Scanner sc) {

        String curText;
        while (true) {

            System.out.println("Type a text to be analyzed:");
            curText = sc.nextLine();
            if (!curText.isEmpty()) {
                this.text = curText;
                break;
            }
            else {
                System.out.println("Text input is not valid!");
            }
        }
    }

    void getTextInfo() {

        for (int i = 0; i < this.text.length(); i++) {

            // appending to charsCount for every char and checking where to append according to what the char is
            charsCount++;
            if (Character.isLetter(this.text.charAt(i))) {
                lettersCount++;
                // checking if the letter is a vowelsCount
                switch (this.text.charAt(i)){
                    case 'a','e','i','o','u','A','E','I','O','U' -> vowelsCount++;
                }
            }
            else if (Character.isDigit(this.text.charAt(i))) {
                digitsCount++;
            }
            else if (Character.isSpaceChar(this.text.charAt(i))){
                spaceCount++;
            }
        }
    }

    void printTextInfo() {

        System.out.println("The statistics for the text that you typed:");
        System.out.printf("Char Count: %d\n", this.charsCount);
        System.out.printf("Letters Count: %d\n", this.lettersCount);
        System.out.printf("Digits Count: %d\n", this.digitsCount);
        System.out.printf("Space Count: %d\n", this.spaceCount);
        System.out.printf("Vowels Count: %d\n", this.vowelsCount);

    }

}
