package com.cevher.java.oop;



/**
 * The Author class model a book's author.
 */
class Author {
    // The private instance variables
    private String name;
    private String email;
    private char gender;   // 'm' or 'f'

    /** Constructs a Author instance with the given inputs */
    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    // The public getters and setters for the private instance variables.
    // No setter for name and gender as they are not designed to be changed.
    /** Returns the name */
    public String getName() {
        return name;
    }
    /** Returns the gender */
    public char getGender() {
        return gender;
    }
    /** Returns the email */
    public String getEmail() {
        return email;
    }
    /** Sets the email */
    public void setEmail(String email) {
        this.email = email;
    }

    /** Returns a self-descriptive String */
    public String toString() {
        return name + " (" + gender + ") at " + email;
    }
}
/**
 * The Book class models a book with one (and only one) author.
 */
class Book {
    // The private instance variables
    private String name;
    private Author author;
    private double price;
    private int qty;

    /** Constructs a Book instance with the given author */
    public Book(String name, Author author, double price, int qty) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    // Getters and Setters
    /** Returns the name of this book */
    public String getName() {
        return name;
    }
    /** Return the Author instance of this book */
    public Author getAuthor() {
        return author;  // return member author, which is an instance of the class Author
    }
    /** Returns the price */
    public double getPrice() {
        return price;
    }
    /** Sets the price */
    public void setPrice(double price) {
        this.price = price;
    }
    /** Returns the quantity */
    public int getQty() {
        return qty;
    }
    /** Sets the quantity */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /** Returns a self-descriptive String */
    public String toString() {
        return "'" + name + "' by " + author;  // author.toString()
    }
}
public class CompositionExample01 {
    public static void main(String[] args) {
        // We need an Author instance to create a Book instance
        Author ahTeck = new Author("Tan Ah Teck", "ahTeck@somewhere.com", 'm');
        System.out.println(ahTeck);  // Author's toString()
        //Tan Ah Teck (m) at ahTeck@somewhere.com

        // Test Book's constructor and toString()
        Book dummyBook = new Book("Java for dummies", ahTeck, 9.99, 99);
        System.out.println(dummyBook);  // Book's toString()
        //'Java for dummies' by Tan Ah Teck (m) at ahTeck@somewhere.com

        // Test Setters and Getters
        dummyBook.setPrice(8.88);
        dummyBook.setQty(88);
        System.out.println("name is: " + dummyBook.getName());
        //name is: Java for dummies
        System.out.println("price is: " + dummyBook.getPrice());
        //price is: 8.88
        System.out.println("qty is: " + dummyBook.getQty());
        //qty is: 88
        System.out.println("author is: " + dummyBook.getAuthor());  // invoke Author's toString()
        //author is: Tan Ah Teck (m) at ahTeck@somewhere.com
        System.out.println("author's name is: " + dummyBook.getAuthor().getName());
        //author's name is: Tan Ah Teck
        System.out.println("author's email is: " + dummyBook.getAuthor().getEmail());
        //author's email is: ahTeck@somewhere.com
        System.out.println("author's gender is: " + dummyBook.getAuthor().getGender());
        //author's gender is: m

        // Using an anonymous Author instance to create a Book instance
        Book moreDummyBook = new Book("Java for more dummies",
                new Author("Peter Lee", "peter@nowhere.com", 'm'), // an anonymous Author's instance
                19.99, 8);
        System.out.println(moreDummyBook);  // Book's toString()
        //'Java for more dummies' by Peter Lee (m) at peter@nowhere.com
    }
}
