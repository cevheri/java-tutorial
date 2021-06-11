package com.cevher.java.oop;

public class CustomTime {
    public static void main(String[] args) {
        // Test Constructors and toString()
        Time t1 = new Time(1, 2, 3);
        System.out.println(t1);  // toString()
        //03:02:01
        Time t2 = new Time();    // The default constructor
        System.out.println(t2);
        //00:00:00

        // Test Setters and Getters
        t1.setHour(4);
        t1.setMinute(5);
        t1.setSecond(6);
        System.out.println(t1);  // run toString() to inspect the modified instance
        //04:05:06
        System.out.println("Hour is: " + t1.getHour());
        //Hour is: 4
        System.out.println("Minute is: " + t1.getMinute());
        //Minute is: 5
        System.out.println("Second is: " + t1.getSecond());
        //Second is: 6

        // Test setTime()
        t1.setTime(58, 59, 23);
        System.out.println(t1);
        //23:59:58

        // Test nextSecond() and chaining
        System.out.println(t1.nextSecond()); // Return an instance of Time. Invoke Time's toString()
        //23:59:59
        System.out.println(t1.nextSecond().nextSecond().nextSecond());  // chaining
        //00:00:02
    }
}
/**
 * The Time class models a time instance with second, minute and hour.
 * This class does not perform input validation for second, minute and hour.
 */
class Time {
    // The private instance variables
    private int second, minute, hour;

    // The constructors (overloaded)
    /** Constructs a Time instance with the given second, minute and hour. No input validation */
    public Time(int second, int minute, int hour) {
        this.second = second;
        this.minute = minute;
        this.hour = hour;
    }
    /** Constructs a Time instance with the default values */
    public Time() {  // the default constructor
        this.second = 0;
        this.minute = 0;
        this.hour = 0;
    }

    // The public getters/setters for the private variables.
    /** Returns the second */
    public int getSecond() {
        return this.second;
    }
    /** Returns the minute */
    public int getMinute() {
        return this.minute;
    }
    /** Returns the hour */
    public int getHour() {
        return this.hour;
    }
    /** Sets the second. No input validation */
    public void setSecond(int second) {
        this.second = second;
    }
    /** Sets the minute. No input validation */
    public void setMinute(int minute) {
        this.minute = minute;
    }
    /** Sets the hour. No input validation */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /** Returns a self-descriptive string in the form of  "hh:mm:ss" with leading zeros */
    public String toString() {
        // Use built-in function String.format() to form a formatted String
        return String.format("%02d:%02d:%02d", hour, minute, second);
        // Specifier "0" to print leading zeros, if available.
    }

    /** Sets second, minute and hour to the given values */
    public void setTime(int second, int minute, int hour) {
        // No input validation
        this.second = second;
        this.minute = minute;
        this.hour = hour;
    }

    /** Advances this Time instance by one second, and returns this instance to support chaining */
    public Time nextSecond() {
        ++second;
        if (second >= 60) {
            second = 0;
            ++minute;
            if (minute >= 60) {
                minute = 0;
                ++hour;
                if (hour >= 24) {
                    hour = 0;
                }
            }
        }
        return this;   // Return "this" instance, to support chaining operations
        // e.g., t1.nextSecond().nextSecond()
    }
}