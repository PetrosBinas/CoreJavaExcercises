package objects_and_classes;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryBookTracker {

    public static void main(String[] args) {

        // a mini book list for our library
        Book[] booksArr = {
                new Book("Crime and Punishment", "Fyodor Dostoevsky", "1866"),
                new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "1967"),
                new Book("The Stranger", "Albert Camus", "1942"),
                new Book("1984", "George Orwell","1949"),
                new Book("The Brothers Karamazov", "Fyodor Dostoevsky", "1880")
        };

        Scanner sc = new Scanner(System.in);

        logicLoop(booksArr, sc);

    }

    static void logicLoop(Book[] books, Scanner sc) {

        System.out.println("Welcome to Our Cozy Little Library!");

        while (true) {

            int choice = startMenu(sc);

            if (choice == 1) {
                bookMenu(books);
            }
            else if (choice == 2) {
                borrowBook(books, sc);
            }
            else if (choice == 3) {
                returnBook(books, sc);
            }
            else {
                break;
            }

        }
    }

    static void bookMenu(Book[] books) {

        int bookNumber = 1;

        for (Book book : books) {
            System.out.printf("%d. %s of %s published in %s\n", bookNumber, book.getTitle(), book.getAuthor(), book.getYearPublished());
            bookNumber++;
        }
    }

    static int startMenu(Scanner sc) {

        while (true) {
            int choice =0;
            System.out.println();
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("Choose an Option:");
            System.out.println("1. Check Library Books");
            System.out.println("2. Borrow a Book of Your Choice");
            System.out.println("3. Return a Book You Have Borrowed");
            System.out.println("4. Exit Program");

            try {
                choice = sc.nextInt();
                if(choice >= 1 && choice <= 4) {
                    return choice;
                }
                else {
                    throw new Exception();
                }
            }
            catch (Exception e) {
                System.out.println("Type a valid Number Between 1-4 that Relate to the Available Options");
            }
        }
    }

    static void borrowBook(Book[] books, Scanner sc) {

        while (true) {
            int choice = 0;
            System.out.println("Type the number of the Book You Want to Borrow:");

            try {
                choice = sc.nextInt();
                if (choice < 1 || choice > 5) {
                    throw new Exception();
                }
            }
            catch (Exception e) {
                System.out.println("Print a valid number in range 1-5!");
                continue;
            }

            if (!books[choice-1].isBorrowed()) {
                System.out.printf("Congrats You Borrowed %s, now don't forget to bring it back!\n", books[choice-1].getTitle());
                books[choice-1].setBorrowed(true);
                break;
            }
            else {
                System.out.printf("%s is not available, someone else have borrowed it, maybe another time\nWe have more books though\n", books[choice-1].getTitle());
                break;
            }
        }
    }

    static void returnBook(Book[] books, Scanner sc) {

        while (true) {
            int choice = 0;
            System.out.println("Type the number of the Book You Want to Return:");

            try {
                choice = sc.nextInt();
                if (choice < 1 || choice > 5) {
                    throw new Exception();
                }
            }
            catch (Exception e) {
                System.out.println("Print a valid number in range 1-5");
                continue;
            }

            if (books[choice-1].isBorrowed()) {
                System.out.printf("Congrats You Successfully Returned %s", books[choice-1].getTitle());
                books[choice-1].setBorrowed(false);
                break;
            }
            else {
                System.out.printf("%s is not borrowed, You might Have mistaken us for another library!", books[choice-1].getTitle());
                break;
            }
        }
    }

}


class Book {

    // book fields
    private boolean isBorrowed = false;
    private String title;
    private String author;
    private String yearPublished;

    // Book constructor
    public Book(String t, String a, String year) {

        title = t;
        author = a;
        yearPublished = year;

    }

    // fields getters
    public boolean isBorrowed() {return this.isBorrowed;}
    public String getTitle() {return this.title;}
    public String getAuthor() {return this.author;}
    public String getYearPublished() {return this.yearPublished;}

    //fields Setters
    public void setBorrowed(boolean b) {this.isBorrowed = b;}
    public void setTitle(String t) {this.title = t;}
    public void setAuthor(String a) {this.author = a;}
    public void setYearPublished(String y) {this.yearPublished = y;}

    public void borrowBook() {
        if (!this.isBorrowed) {
            System.out.printf("You have successfully borrowed %s\n", this.title);
            isBorrowed = true;
        }
        else {
            System.out.printf("%s is already borrowed! Try borrowing another book!", this.title);
        }
    }

    public void returnBook() {
        if (this.isBorrowed) {
            System.out.printf("You have successfully returned %s\n", this.title);
            isBorrowed = false;
        }
        else {
            System.out.printf("%s is not borrowed. You might be in the wrong Library!", this.title);
        }
    }

    public void printInfo() {
        System.out.printf("Book Title: %s\n", this.title);
        System.out.printf("Author: %s\n", this.author);
        System.out.printf("Year Published: %s\n", this.yearPublished);
        System.out.printf("Book Status: %s", (isBorrowed ? "Borrowed" : "Available"));
    }

}
