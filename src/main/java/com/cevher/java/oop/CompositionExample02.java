package com.cevher.java.oop;

import java.util.Arrays;

/**
 * The Circle class composes a "Point" instance as its center and a radius.
 * We reuse the "Point" class via composition.
 */
class Circle {
    // The private member variables
    private Point center;  // Declare an instance of the "Point" class
    private double radius;

    // Constructors

    /**
     * Constructs a Circle instance with the default values
     */
    public Circle() {
        this.center = new Point(); // Construct a Point at (0,0)
        this.radius = 1.0;
    }

    /**
     * Constructs a Circle instance with the center at (xCenter, yCenter) and radius
     */
    public Circle(int xCenter, int yCenter, double radius) {
        center = new Point(xCenter, yCenter); // Construct a Point at (xCenter,yCenter)
        this.radius = radius;
    }

    /**
     * Constructs a Circle instance with the given Point instance as center and radius
     */
    public Circle(Point center, double radius) {
        this.center = center;  // The caller had constructed a Point instance
        this.radius = radius;
    }

    // Getters and Setters
    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Point getCenter() {
        return this.center;  // return a Point instance
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public int getCenterX() {
        return center.getX();  // Point's getX()
    }

    public void setCenterX(int x) {
        center.setX(x);  // Point's setX()
    }

    public int getCenterY() {
        return center.getY();  // Point's getY()
    }

    public void setCenterY(int y) {
        center.setY(y);  // Point's setY()
    }

    public int[] getCenterXY() {
        return center.getXY();  // Point's getXY()
    }

    public void setCenterXY(int x, int y) {
        center.setXY(x, y);  // Point's setXY()
    }

    /**
     * Returns a self-descriptive String
     */
    public String toString() {
        return "Circle[center=" + center + ",radius=" + radius + "]";  // invoke center.toString()
    }

    /**
     * Returns the area of this circle
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Returns the circumference of this circle
     */
    public double getCircumference() {
        return 2.0 * Math.PI * radius;
    }

    /**
     * Returns the distance from the center of this circle to the center of
     * the given Circle instance called another
     */
    public double distance(Circle another) {
        return center.distance(another.center);  // Use distance() of the Point class
    }
}

/**
 * A Line composes of two Points - a begin "Point" and an end "Point".
 * We reuse the Point class via composition.
 */
class Line {
    // The private instance variables
    Point begin, end;   // instances of the "Point" class

    /**
     * Constructs a Line instance given 2 points at (x1, y1) and (x2, y2)
     */
    public Line(int x1, int y1, int x2, int y2) {
        begin = new Point(x1, y1);  // Construct the instances declared
        end = new Point(x2, y2);
    }

    /**
     * Construct a Line instance given 2 Point instances
     */
    public Line(Point begin, Point end) {
        this.begin = begin;  // The caller had constructed the instances
        this.end = end;
    }

    // The public getter and setter for the private instance variables
    public Point getBegin() {
        return begin;
    }

    public Point getEnd() {
        return end;
    }

    public void setBegin(Point begin) {
        this.begin = begin;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public int getBeginX() {
        return begin.getX();  // Point's getX()
    }

    public void setBeginX(int x) {
        begin.setX(x);  // Point's setX()
    }

    public int getBeginY() {
        return begin.getY();  // Point's getY()
    }

    public void setBeginY(int y) {
        begin.setY(y);  // Point's setY()
    }

    public int[] getBeginXY() {
        return begin.getXY();  // Point's getXY()
    }

    public void setBeginXY(int x, int y) {
        begin.setXY(x, y);  // Point's setXY()
    }

    public int getEndX() {
        return end.getX();  // Point's getX()
    }

    public void setEndX(int x) {
        end.setX(x);  // Point's setX()
    }

    public int getEndY() {
        return end.getY();  // Point's getY()
    }

    public void setEndY(int y) {
        end.setY(y);  // Point's setY()
    }

    public int[] getEndXY() {
        return end.getXY();  // Point's getXY()
    }

    public void setEndXY(int x, int y) {
        end.setXY(x, y);  // Point's setXY()
    }

    /**
     * Returns a self-descriptive String
     */
    public String toString() {
        return "Line[begin=" + begin + ",end=" + end + "]";
        // Invoke begin.toString() and end.toString()
    }

    /**
     * Returns the length of this line
     */
    public double getLength() {
        return begin.distance(end);  // use Point's distance() method
    }
}

public class CompositionExample02 {


    public static void main(String[] args) {

        // Test Circle
        // Test Constructors and toString()
        Circle c1 = new Circle();
        System.out.println(c1);  // Circle's toString()
        Circle c2 = new Circle(1, 2, 3.3);
        System.out.println(c2);  // Circle's toString()
        Circle c3 = new Circle(new Point(4, 5), 6.6);   // an anonymous Point instance
        System.out.println(c3);  // Circle's toString()

        // Test Setters and Getters
        c1.setCenter(new Point(11, 12));
        c1.setRadius(13.3);
        System.out.println(c1);  // Circle's toString()
        System.out.println("center is: " + c1.getCenter());  // Point's toString()
        System.out.println("radius is: " + c1.getRadius());

        c1.setCenterX(21);
        c1.setCenterY(22);
        System.out.println(c1);  // Circle's toString()
        System.out.println("center's x is: " + c1.getCenterX());
        System.out.println("center's y is: " + c1.getCenterY());
        c1.setCenterXY(31, 32);
        System.out.println(c1);  // Circle's toString()
        System.out.println("center's x is: " + c1.getCenterXY()[0]);
        System.out.println("center's y is: " + c1.getCenterXY()[1]);

        // Test getArea() and getCircumference()
        System.out.printf("area is: %.2f%n", c1.getArea());
        System.out.printf("circumference is: %.2f%n", c1.getCircumference());

        // Test distance()
        System.out.printf("distance is: %.2f%n", c1.distance(c2));
        System.out.printf("distance is: %.2f%n", c2.distance(c1));

        /////////////////////////////////////////////////////////////
        // Test Line
        // Test constructor and toString()
        Line l1 = new Line(1, 2, 3, 4);
        System.out.println(l1);  // Line's toString()
        //Line[begin=(1,2),end=(3,4)]
        Line l2 = new Line(new Point(5, 6), new Point(7, 8));  // anonymous Point's instances
        System.out.println(l2);  // Line's toString()
        //Line[begin=(5,6),end=(7,8)]

        // Test Setters and Getters
        l1.setBegin(new Point(11, 12));
        l1.setEnd(new Point(13, 14));
        System.out.println(l1);  // Line's toString()
        //Line[begin=(11,12),end=(13,14)]
        System.out.println("begin is: " + l1.getBegin());  // Point's toString()
        //begin is: (11,12)
        System.out.println("end is: " + l1.getEnd());  // Point's toString()
        //end is: (13,14)

        l1.setBeginX(21);
        l1.setBeginY(22);
        l1.setEndX(23);
        l1.setEndY(24);
        System.out.println(l1);  // Line's toString()
        //Line[begin=(21,22),end=(23,24)]
        System.out.println("begin's x is: " + l1.getBeginX());
        //begin's x is: 21
        System.out.println("begin's y is: " + l1.getBeginY());
        //begin's y is: 22
        System.out.println("end's x is: " + l1.getEndX());
        //end's x is: 23
        System.out.println("end's y is: " + l1.getEndY());
        //end's y is: 24

        l1.setBeginXY(31, 32);
        l1.setEndXY(33, 34);
        System.out.println(l1);  // Line's toString()
        //Line[begin=(31,32),end=(33,34)]
        System.out.println("begin's x and y are: " + Arrays.toString(l1.getBeginXY()));
        //begin's x and y are: [31, 32]
        System.out.println("end's x and y are: " + Arrays.toString(l1.getEndXY()));
        //end's x and y are: [33, 34]

        // Test getLength()
        System.out.printf("length is: %.2f%n", l1.getLength());
        //length is: 2.83
    }
}