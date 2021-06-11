package com.cevher.java.oop;

/**
 * A Test Driver for the Point class.
 */
public class CustomPoint {
    public static void main(String[] args) {
        // Test constructors and toString()
        Point p1 = new Point(1, 2);
        System.out.println(p1);  // toString()
        //(1,2)
        Point p2 = new Point();  // default constructor
        System.out.println(p2);
        //(0,0)

        // Test Setters and Getters
        p1.setX(3);
        p1.setY(4);
        System.out.println(p1);  // run toString() to inspect the modified instance
        //(3,4)
        System.out.println("X is: " + p1.getX());
        //X is: 3
        System.out.println("Y is: " + p1.getY());
        //Y is: 4

        // Test setXY() and getXY()
        p1.setXY(5, 6);
        System.out.println(p1);  // toString()
        //(5,6)
        System.out.println("X is: " + p1.getXY()[0]);
        //X is: 5
        System.out.println("Y is: " + p1.getXY()[1]);
        //Y is: 6

        // Test the 3 overloaded versions of distance()
        p2.setXY(10, 11);
        System.out.printf("Distance is: %.2f%n", p1.distance(10, 11));
        //Distance is: 7.07
        System.out.printf("Distance is: %.2f%n", p1.distance(p2));
        //Distance is: 7.07
        System.out.printf("Distance is: %.2f%n", p2.distance(p1));
        //Distance is: 7.07
        System.out.printf("Distance is: %.2f%n", p1.distance());
        //Distance is: 7.81
    }
}

/**
 * The Point class models a 2D point at (x, y).
 */
class Point {
    // The private instance variables
    private int x, y;

    // The constructors (overloaded)
    /** Construct a Point instance with the default values */
    public Point() {  // The default constructor
        this.x = 0;
        this.y = 0;
    }
    /** Construct a Point instance with the given x and y values */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // The public getters and setters
    /** Returns the value of x */
    public int getX() {
        return this.x;
    }
    /** Sets the value of x */
    public void setX(int x) {
        this.x = x;
    }
    /** Returns the value of y */
    public int getY() {
        return this.y;
    }
    /** Sets the value of y */
    public void setY(int y) {
        this.y = y;
    }

    /** Returns a self-descriptive string in the form of "(x,y)" */
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    /** Returns a 2-element int array containing x and y */
    public int[] getXY() {
        int[] results = new int[2];
        results[0] = this.x;
        results[1] = this.y;
        return results;
    }

    /** Sets both x and y */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /** Return the distance from this instance to the given point at (x,y). Invoke via p1.distance(1,2) */
    public double distance(int x, int y) {
        int xDiff = this.x - x;
        int yDiff = this.y - y;
        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }
    /** Returns the distance from this instance to the given Point instance. Invoke via p1.distance(p2) */
    public double distance(Point another) {
        int xDiff = this.x - another.x;
        int yDiff = this.y - another.y;
        return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
    }
    /** Returns the distance from this instance to (0,0). Invoke via p1.distance() */
    public double distance() {
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }
}