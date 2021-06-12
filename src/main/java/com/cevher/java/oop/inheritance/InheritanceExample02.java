package com.cevher.java.oop.inheritance;

/**
 * The Point2D class models a 2D point at (x, y).
 */
class Point2D {
    // Private instance variables
    private int x, y;

    // Constructors

    /**
     * Construct a Point2D instance at (0,0)
     */
    public Point2D() {  // default constructor
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructs a Point2D instance at the given (x,y)
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getters and Setters
    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

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
}

/**
 * The Point3D class models a 3D point at (x, y,z),
 * which is a subclass of Point2D.
 */
class Point3D extends Point2D {
    // Private instance variables
    private int z;

    // Constructors

    /**
     * Constructs a Point3D instance at (0,0,0)
     */
    public Point3D() {  // default constructor
        super();     // x = y = 0
        this.z = 0;
    }

    /**
     * Constructs a Point3D instance at (x,y,z)
     */
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    // Getters and Setters
    public int getZ() {
        return this.z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    /**
     * Returns a self-descriptive string in the form of "(x,y,z)"
     */
    @Override
    public String toString() {
        return "(" + super.getX() + "," + super.getY() + "," + this.z + ")";
    }
}

public class InheritanceExample02 {
    public static void main(String[] args) {
        /* Test Point2D */
        // Test constructors and toString()
        Point2D p2a = new Point2D(1, 2);
        System.out.println(p2a);  // toString()
        Point2D p2b = new Point2D();  // default constructor
        System.out.println(p2b);
        // Test Setters and Getters
        p2a.setX(3);  // Test setters
        p2a.setY(4);
        System.out.println(p2a);  // toString()
        System.out.println("x is: " + p2a.getX());
        System.out.println("x is: " + p2a.getY());

        /* Test Point3D */
        // Test constructors and toString()
        Point3D p3a = new Point3D(11, 12, 13);
        System.out.println(p3a);  // toString()
        Point2D p3b = new Point3D();  // default constructor
        System.out.println(p3b);
        // Test Setters and Getters
        p3a.setX(21);  // in superclass
        p3a.setY(22);  // in superclass
        p3a.setZ(23);  // in this class
        System.out.println(p3a);  // toString()
        System.out.println("x is: " + p3a.getX());  // in superclass
        System.out.println("y is: " + p3a.getY());  // in superclass
        System.out.println("z is: " + p3a.getZ());  // in this class
    }
}