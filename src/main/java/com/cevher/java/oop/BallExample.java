package com.cevher.java.oop;

import java.util.Arrays;
/**
 * The Ball class models a moving ball at (x, y) with displacement
 *   per move-step of (xStep, yStep).
 */
class Ball {
    // The private instance variables
    private double x, y, xStep, yStep;

    /** Constructs a Ball instance with the given input */
    public Ball(double x, double y, double xStep, double yStep) {
        this.x = x;
        this.y = y;
        this.xStep = xStep;
        this.yStep = yStep;
    }

    // The public getters and setters for the private variables
    public double getX() {
        return this.x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return this.y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getXStep() {
        return this.xStep;
    }
    public void setXStep(double xStep) {
        this.xStep = xStep;
    }
    public double getYStep() {
        return this.yStep;
    }
    public void setYStep(double yStep) {
        this.yStep = yStep;
    }

    /** Returns a self-descriptive String */
    public String toString() {
        return "Ball@(" + x + "," + y + "),speed=(" + xStep + "," + yStep + ")";
    }

    /** Returns the x and y position in a 2-element double array */
    public double[] getXY() {
        double[] results = new double[2];
        results[0] = this.x;
        results[1] = this.y;
        return results;
    }
    /** Sets the x and y position */
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /** Returns the xStep and yStep in a 2-element double array */
    public double[] getXYStep() {
        double[] results = new double[2];
        results[0] = this.xStep;
        results[1] = this.yStep;
        return results;
    }
    /** Sets the xStep and yStep */
    public void setXYStep(double xStep, double yStep) {
        this.xStep = xStep;
        this.yStep = yStep;
    }

    /** Moves a step by increment x and y by xStep and yStep, respectively.
     Return "this" instance to support chaining operation. */
    public Ball move() {
        x += xStep;
        y += yStep;
        return this;
    }
}

/**
 * A Test Driver for the Ball class.
 */
public class BallExample {
    public static void main(String[] args) {
        // Test constructor and toString()
        Ball b1 = new Ball(1, 2, 11, 12);
        System.out.println(b1);  // toString()
        //Ball@(1.0,2.0),speed=(11.0,12.0)

        // Test Setters and Getters
        b1.setX(3);
        b1.setY(4);
        b1.setXStep(13);
        b1.setYStep(14);
        System.out.println(b1);
        //Ball@(3.0,4.0),speed=(13.0,14.0)
        System.out.println("x is: " + b1.getX());
        //x is: 3.0
        System.out.println("y is: " + b1.getY());
        //y is: 4.0
        System.out.println("xStep is: " + b1.getXStep());
        //xStep is: 13.0
        System.out.println("yStep is: " + b1.getYStep());
        //yStep is: 14.0

        // Test setXY(), getXY(), setXYStep(), getXYStep()
        b1.setXY(5, 6);
        b1.setXYStep(15, 16);
        System.out.println(b1);  // toString()
        //Ball@(5.0,6.0),speed=(15.0,16.0)
        System.out.println("x and y are: " + Arrays.toString(b1.getXY()));  // use utility to print array
        //x and y are: [5.0, 6.0]
        System.out.println("xStep and yStep are: " + Arrays.toString(b1.getXYStep()));
        //xStep and yStep are: [15.0, 16.0]

        // Test move() and chaining
        System.out.println(b1.move());  // toString()
        //Ball@(20.0,22.0),speed=(15.0,16.0)
        System.out.println(b1.move().move().move());
        //Ball@(65.0,70.0),speed=(15.0,16.0)
    }
}