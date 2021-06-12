package com.cevher.java.oop.inheritance;


/**
 * The Point class models a 2D point at (x, y).
 */
class Point {
    // The private instance variables
    private int x, y;

    // The constructors (overloaded)

    /**
     * Construct a Point instance with the default values
     */
    public Point() {  // The default constructor
        this.x = 0;
        this.y = 0;
    }

    /**
     * Construct a Point instance with the given x and y values
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // The public getters and setters

    /**
     * Returns the value of x
     */
    public int getX() {
        return this.x;
    }

    /**
     * Sets the value of x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Returns the value of y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Sets the value of y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns a self-descriptive string in the form of "(x,y)"
     */
    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    /**
     * Returns a 2-element int array containing x and y
     */
    public int[] getXY() {
        int[] results = new int[2];
        results[0] = this.x;
        results[1] = this.y;
        return results;
    }

    /**
     * Sets both x and y
     */
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Return the distance from this instance to the given point at (x,y). Invoke via p1.distance(1,2)
     */
    public double distance(int x, int y) {
        int xDiff = this.x - x;
        int yDiff = this.y - y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    /**
     * Returns the distance from this instance to the given Point instance. Invoke via p1.distance(p2)
     */
    public double distance(Point another) {
        int xDiff = this.x - another.x;
        int yDiff = this.y - another.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    /**
     * Returns the distance from this instance to (0,0). Invoke via p1.distance()
     */
    public double distance() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }
}

/**
 * The LineSub class, subclass of Point.
 * It inherits the begin point from the superclass, and adds an end point.
 */
class LineSub extends Point {  // Inherited the begin point
    // Private instance variables
    Point end;   // Declare end as instance of Point

    /**
     * Constructs a LineSub instance with 2 points at (x1, y1) and (x2, y2)
     */
    public LineSub(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.end = new Point(x2, y2);   // Construct Point instances
    }

    /**
     * Constructs a LineSub instance with the 2 given Point instances
     */
    public LineSub(Point begin, Point end) {
        super(begin.getX(), begin.getY());  // Need to construct super
        this.end = end;
    }

    // Getters and Setters
    public Point getBegin() {
        return this;   // upcast to Point (polymorphism - to be discussed later)
    }

    public Point getEnd() {
        return end;
    }

    public void setBegin(Point begin) {
        super.setX(begin.getX());
        super.setY(begin.getY());
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    // Other Get and Set methods
    public int getBeginX() {
        return super.getX();  // inherited, super is optional
    }

    public void setBeginX(int x) {
        super.setX(x);        // inherited, super is optional
    }

    public int getBeginY() {
        return super.getY();
    }

    public void setBeginY(int y) {
        super.setY(y);
    }

    public int[] getBeginXY() {
        return super.getXY();
    }

    public void setBeginXY(int x, int y) {
        super.setXY(x, y);
    }

    public int getEndX() {
        return end.getX();
    }

    public void setEndX(int x) {
        end.setX(x);
    }

    public int getEndY() {
        return end.getY();
    }

    public void setEndY(int y) {
        end.setY(y);
    }

    public int[] getEndXY() {
        return end.getXY();
    }

    public void setEndXY(int x, int y) {
        end.setXY(x, y);
    }

    /**
     * Returns a self-descriptive string
     */
    @Override
    public String toString() {
        return "LineSub[begin=" + super.toString() + ",end=" + end + "]";
    }

    /**
     * Returns the length of this line
     */
    public double getLength() {
        return super.distance(end);
    }
}

public class InheritanceExample04 {

    public static void main(String[] args) {
        // Test constructors and toString()
        LineSub l1 = new LineSub(1, 2, 3, 4);
        System.out.println(l1);  // toString()
        LineSub l2 = new LineSub(new Point(5, 6), new Point(7, 8));
        System.out.println(l2);

        // Test Setters and Getters
        l1.setBegin(new Point(11, 12));
        l1.setEnd(new Point(13, 14));
        System.out.println(l1);  // toString()
        System.out.println("begin is: " + l1.getBegin());
        System.out.println("end is: " + l1.getEnd());

        l1.setBeginX(21);
        l1.setBeginY(22);
        l1.setEndX(23);
        l1.setEndY(24);
        System.out.println(l1);
        System.out.println(l1);  // toString()
        System.out.println("begin's x is: " + l1.getBeginX());
        System.out.println("begin's y is: " + l1.getBeginY());
        System.out.println("end's x is: " + l1.getEndX());
        System.out.println("end's y is: " + l1.getEndY());

        l1.setBeginXY(31, 32);
        l1.setEndXY(33, 34);
        System.out.println(l1);  // toString()
        System.out.println("begin's x is: " + l1.getBeginXY()[0]);
        System.out.println("begin's y is: " + l1.getBeginXY()[1]);
        System.out.println("end's x is: " + l1.getEndXY()[0]);
        System.out.println("end's y is: " + l1.getEndXY()[1]);

        // Test getLength()
        System.out.printf("length is: %.2f%n", l1.getLength());
    }
}