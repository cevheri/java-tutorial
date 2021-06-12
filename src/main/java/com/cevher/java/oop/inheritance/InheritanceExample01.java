package com.cevher.java.oop.inheritance;

class Circle {
    // private instance variables
    private double radius;
    private String color;

    // Constructors
    public Circle() {
        this.radius = 1.0;
        this.color = "red";
        System.out.println("Construced a Circle with Circle()");  // for debugging
    }

    public Circle(double radius) {
        this.radius = radius;
        this.color = "red";
        System.out.println("Construced a Circle with Circle(radius)");  // for debugging
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
        System.out.println("Construced a Circle with Circle(radius, color)");  // for debugging
    }

    // public getters and setters for the private variables
    public double getRadius() {
        return this.radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Returns a self-descriptive String
     */
    public String toString() {
        return "Circle[radius=" + radius + ",color=" + color + "]";
    }

    /**
     * Returns the area of this Circle
     */
    public double getArea() {
        System.out.println("Circle -> getArea()");
        return radius * radius * Math.PI;
    }
}

/**
 * A Cylinder is a Circle plus a height.
 */
class Cylinder extends Circle {
    // private instance variable
    private double height;

    // Constructors
    public Cylinder() {
        super();  // invoke superclass' constructor Circle()
        this.height = 1.0;
        System.out.println("Constructed a Cylinder with Cylinder()");  // for debugging
    }

    public Cylinder(double height) {
        super();  // invoke superclass' constructor Circle()
        this.height = height;
        System.out.println("Constructed a Cylinder with Cylinder(height)");  // for debugging
    }

    public Cylinder(double height, double radius) {
        super(radius);  // invoke superclass' constructor Circle(radius)
        this.height = height;
        System.out.println("Constructed a Cylinder with Cylinder(height, radius)");  // for debugging
    }

    public Cylinder(double height, double radius, String color) {
        super(radius, color);  // invoke superclass' constructor Circle(radius, color)
        this.height = height;
        System.out.println("Constructed a Cylinder with Cylinder(height, radius, color)");  // for debugging
    }

    // Getter and Setter
    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Override the getArea() method inherited from superclass Circle
    @Override
    public double getArea() {
        System.out.println("Cylinder -> getArea()");
        return 2 * Math.PI * getRadius() * height + 2 * super.getArea();
    }

    /**
     * Returns the volume of this Cylinder
     */
    public double getVolume() {
        return getArea() * height;   // Use Circle's getArea()
    }

    /**
     * Returns a self-descriptive String
     */
    @Override
    public String toString() {
        return "This is a Cylinder";  // to be refined later
    }
}

public class InheritanceExample01 {
    public static void main(String[] args) {
        Cylinder cy1 = new Cylinder();
        //Construced a Circle with Circle()
        //Constructed a Cylinder with Cylinder()
        System.out.println("Radius is " + cy1.getRadius()
                + ", Height is " + cy1.getHeight()
                + ", Color is " + cy1.getColor()
                + ", Base area is " + cy1.getArea()
                + ", Volume is " + cy1.getVolume());
        //Radius is 1.0, Height is 1.0, Color is red,
        //Base area is 3.141592653589793, Volume is 3.141592653589793

        Cylinder cy2 = new Cylinder(5.0, 2.0);
        //Construced a Circle with Circle(radius)
        //Constructed a Cylinder with Cylinder(height, radius)
        System.out.println("Radius is " + cy2.getRadius()
                + ", Height is " + cy2.getHeight()
                + ", Color is " + cy2.getColor()
                + ", Base area is " + cy2.getArea()
                + ", Volume is " + cy2.getVolume());
        //Radius is 2.0, Height is 5.0, Color is red,
        //Base area is 12.566370614359172, Volume is 62.83185307179586

        // Substitute a subclass instance to a superclass reference
        Circle c1 = new Cylinder(1.1, 2.2);
        c1.getArea();
    }
}
