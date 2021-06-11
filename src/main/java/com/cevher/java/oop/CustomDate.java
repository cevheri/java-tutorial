package com.cevher.java.oop;


/**
 * A Test Driver for the Date class.
 */
public class CustomDate {
    public static void main(String[] args) {
        // Test constructor and toString()
        Date d1 = new Date(2020, 2, 8);
        System.out.println(d1);  // toString()
        //02/08/2020

        // Test Setters and Getters
        d1.setYear(2021);
        d1.setMonth(12);
        d1.setDay(23);
        System.out.println(d1);
        //12/23/2012
        System.out.println("Year is: " + d1.getYear());
        //Year is: 2012
        System.out.println("Month is: " + d1.getMonth());
        //Month is: 12
        System.out.println("Day is: " + d1.getDay());
        //Day is: 23

        // Test setDate()
        d1.setDate(9999, 1, 2);
        System.out.println(d1);
        //01/02/2988
    }
}

/**
 * The Date class models a calendar date with day, month and year.
 * This class does not perform input validation for day, month and year.
 */
class Date {
    // The private instance variables
    private int year, month, day;

    /** Constructs a Date instance with the given year, month and day. No input validation */
    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // The public getters/setters for the private variables
    /** Returns the year */
    public int getYear() {
        return this.year;
    }
    /** Returns the month */
    public int getMonth() {
        return this.month;
    }
    /** Returns the day */
    public int getDay() {
        return this.day;
    }
    /** Sets the year. No input validation */
    public void setYear(int year) {
        this.year = year;
    }
    /** Sets the month. No input validation */
    public void setMonth(int month) {
        this.month = month;
    }
    /** Sets the day. No input validation */
    public void setDay(int day) {
        this.day = day;
    }

    /* Returns a descriptive String in the form "MM/DD/YYYY" with leading zero */
    public String toString() {
        // Use built-in function String.format() to form a formatted String
        return String.format("%02d/%02d/%4d", month, day, year);
        // Specifier "0" to print leading zeros
    }

    /** Sets year, month and day. No input validation */
    public void setDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }
}