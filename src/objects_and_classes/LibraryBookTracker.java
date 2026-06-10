package objects_and_classes;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryBookTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);



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
