package com.cevher.java.oop;

/**
 * The interface Shape specifies the behaviors
 * of this implementations subclasses.
 */
interface Shape {  // Use keyword "interface" instead of "class"
    // List of public abstract methods to be implemented by its subclasses
    // All methods in interface are "public abstract".
    // "protected", "private" and "package" methods are NOT allowed.
    double getArea();
}

/**
 * The subclass Rectangle needs to implement all the abstract methods in Shape
 */
class Rectangle implements Shape {  // using keyword "implements" instead of "extends"
    // Private member variables
    private int length, width;

    /**
     * Constructs a Rectangle instance with the given length and width
     */
    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Returns a self-descriptive string
     */
    @Override
    public String toString() {
        return "Rectangle[length=" + length + ",width=" + width + "]";
    }

    // Need to implement all the abstract methods defined in the interface

    /**
     * Returns the area of this rectangle
     */
    @Override
    public double getArea() {
        return length * width;
    }
}

/**
 * The subclass Triangle need to implement all the abstract methods in Shape
 */
class Triangle implements Shape {
    // Private member variables
    private int base, height;

    /**
     * Constructs a Triangle instance with the given base and height
     */
    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

    /**
     * Returns a self-descriptive string
     */
    @Override
    public String toString() {
        return "Triangle[base=" + base + ",height=" + height + "]";
    }

    // Need to implement all the abstract methods defined in the interface

    /**
     * Returns the area of this triangle
     */
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }
}

public class InterfaceExample01 {

    public static void main(String[] args) {
        Shape s1 = new Rectangle(1, 2);  // upcast
        System.out.println(s1);
        //Rectangle[length=1,width=2]
        System.out.println("Area is " + s1.getArea());
        //Area is 2.0

        Shape s2 = new Triangle(3, 4);  // upcast
        System.out.println(s2);
        //Triangle[base=3,height=4]
        System.out.println("Area is " + s2.getArea());
        //Area is 6.0

        // Cannot create instance of an interface
        //Shape s3 = new Shape("green");
        //compilation error: Shape is abstract; cannot be instantiated
    }
}