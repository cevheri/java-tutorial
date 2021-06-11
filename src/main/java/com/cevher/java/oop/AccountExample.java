package com.cevher.java.oop;
/**
 * The Account class models a bank account with a balance.
 */
class Account {
    // The private instance variables
    private int number;
    private double balance;

    // The constructors (overloaded)
    /** Constructs an Account instance with the given number and initial balance of 0 */
    public Account(int number) {
        this.number = number;
        this.balance = 0.0;  // "this." is optional
    }
    /** Constructs an Account instance with the given number and initial balance */
    public Account(int number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    // The public getters/setters for the private instance variables.
    // No setter for number because it is not designed to be changed.
    // No setter for balance as it is changed via credit() and debit()
    /** Returns the number */
    public int getNumber() {
        return this.number;  // "this." is optional
    }
    /** Returns the balance */
    public double getBalance() {
        return this.balance;  // "this." is optional
    }

    /** Returns a string description of this instance */
    public String toString() {
        // Use built-in function System.format() to form a formatted String
        return String.format("Account[number=%d,balance=$%.2f]", number, balance);
    }

    /** Add the given amount to the balance */
    public void credit(double amount) {
        balance += amount;
    }

    /** Subtract the given amount from balance, if balance >= amount */
    public void debit(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("amount exceeded");
        }
    }

    /** Transfer the given amount to Account another, if balance >= amount */
    public void transferTo(double amount, Account another) {
        if (balance >= amount) {
            this.balance -= amount;
            another.balance += amount;
        } else {
            System.out.println("amount exceeded");
        }
    }
}

/**
 * A Test Driver for the Account class.
 */
public class AccountExample {
    public static void main(String[] args) {
        // Test Constructors and toString()
        Account a1 = new Account(5566);
        System.out.println(a1);
        //Account[number=5566,balance=$0.00]
        Account a2 = new Account(1234, 99.9);
        System.out.println(a2);
        //Account[number=1234,balance=$99.90]

        // Test getters
        System.out.println("The account Number is: " + a2.getNumber());
        //The account Number is: 1234
        System.out.println("The balance is: " + a2.getBalance());
        //The balance is: 99.9

        // Test credit(), debit() and transferTo()
        a1.credit(11.1);
        System.out.println(a1);
        //Account[number=5566,balance=$11.10]
        a1.debit(5.5);
        System.out.println(a1);
        //Account[number=5566,balance=$5.60]
        a1.debit(500);   // Test debit() error
        //amount exceeded
        System.out.println(a1);
        //Account[number=5566,balance=$5.60]

        a2.transferTo(1.0, a1);
        System.out.println(a1);
        //Account[number=5566,balance=$6.60]
        System.out.println(a2);
        //Account[number=1234,balance=$98.90]
    }
}
