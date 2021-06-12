package com.cevher.java.oop;

/**
 * The Movable interface defines a list of public abstract methods
 * to be implemented by its subclasses
 */
interface Movable {  // use keyword "interface" (instead of "class") to define an interface
    // An interface defines a list of public abstract methods to be implemented by the subclasses
    public void moveUp();    // "public" and "abstract" optional

    public void moveDown();

    public void moveLeft();

    public void moveRight();
}

/**
 * The subclass MovablePoint needs to implement all the abstract methods
 * defined in the interface Movable
 */
class MovablePoint implements Movable {
    // Private member variables
    private int x, y;   // x and y coordinates of the point

    /**
     * Constructs a MovablePoint instance at the given x and y
     */
    public MovablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns a self-descriptive string
     */
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    // Need to implement all the abstract methods defined in the interface Movable
    @Override
    public void moveUp() {
        y--;
    }

    @Override
    public void moveDown() {
        y++;
    }

    @Override
    public void moveLeft() {
        x--;
    }

    @Override
    public void moveRight() {
        x++;
    }
}

public class InterfaceExample02 {

    public static void main(String[] args) {
        MovablePoint p1 = new MovablePoint(1, 2);
        System.out.println(p1);
        //(1,2)
        p1.moveDown();
        System.out.println(p1);
        //(1,3)
        p1.moveRight();
        System.out.println(p1);
        //(2,3)

        // Test Polymorphism
        Movable p2 = new MovablePoint(3, 4);  // upcast
        p2.moveUp();
        System.out.println(p2);
        //(3,3)

        MovablePoint p3 = (MovablePoint) p2;   // downcast
        System.out.println(p3);
        //(3,3)
    }
}