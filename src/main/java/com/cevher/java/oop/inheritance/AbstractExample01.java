package com.cevher.java.oop.inheritance;
/**
 * This abstract superclass Shape contains an abstract method
 *   getArea(), to be implemented by its subclasses.
 */
abstract class Shape {
    // Private member variable
    private final String color;

    /** Constructs a Shape instance with the given color */
    public Shape (String color) {
        this.color = color;
    }

    /** Returns a self-descriptive string */
    @Override
    public String toString() {
        return "Shape[color=" + color + "]";
    }

    /** All Shape's concrete subclasses must implement a method called getArea() */
    abstract public double getArea();
}
/**
 * The Rectangle class, subclass of Shape
 */
class Rectangle extends Shape {
    // Private member variables
    private int length, width;

    /** Constructs a Rectangle instance with the given color, length and width */
    public Rectangle(String color, int length, int width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    /** Returns a self-descriptive string */
    @Override
    public String toString() {
        return "Rectangle[length=" + length + ",width=" + width + "," + super.toString() + "]";
    }

    /** Override the inherited getArea() to provide the proper implementation for rectangle */
    @Override
    public double getArea() {
        return length*width;
    }
}
/**
 * The Triangle class, subclass of Shape
 */
class Triangle extends Shape {
    // Private member variables
    private int base, height;

    /** Constructs a Triangle instance with the given color, base and height */
    public Triangle(String color, int base, int height) {
        super(color);
        this.base = base;
        this.height = height;
    }

    /** Returns a self-descriptive string */
    @Override
    public String toString() {
        return "Triangle[base=" + base + ",height=" + height + "," + super.toString() + "]";
    }

    /** Override the inherited getArea() to provide the proper implementation for triangle */
    @Override
    public double getArea() {
        return 0.5*base*height;
    }
}
public class AbstractExample01 {
    public static void main(String[] args) {
        Shape s1 = new Rectangle("red", 4, 5);
        System.out.println(s1);
        System.out.println("Area is " + s1.getArea());

        Shape s2 = new Triangle("blue", 4, 5);
        System.out.println(s2);
        System.out.println("Area is " + s2.getArea());

        // Cannot create instance of an abstract class
        // Shape s3 = new Shape("green");
        //compilation error: Shape is abstract; cannot be instantiated
    }
}
