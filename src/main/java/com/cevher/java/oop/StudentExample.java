package com.cevher.java.oop;

/**
 * The student class models a student having courses and grades.
 */
class Student {
    // The private instance variables
    private String name;
    private String address;
    // The courses taken and grades for the courses are kept in 2 parallel arrays
    private String[] courses;
    private int[] grades;     // valid range is [0, 100]
    private int numCourses;   // Number of courses taken so far
    private static final int MAX_COURSES = 30;  // Maximum number of courses taken by student

    /** Constructs a Student instance with the given input */
    public Student(String name, String address) {
        this.name = name;
        this.address = address;
        courses = new String[MAX_COURSES];  // allocate arrays
        grades = new int[MAX_COURSES];
        numCourses = 0;                     // no courses so far
    }

    // The public getters and setters.
    // No setter for name as it is not designed to be changed.
    /** Returns the name */
    public String getName() {
        return this.name;
    }
    /** Returns the address */
    public String getAddress() {
        return this.address;
    }
    /** Sets the address */
    public void setAddress(String address) {
        this.address = address;
    }

    /** Returns a self-descriptive String */
    public String toString() {
        return name + "(" + address + ")";
    }

    /** Adds a course and grade */
    public void addCourseGrade(String course, int grade) {
        courses[numCourses] = course;
        grades[numCourses] = grade;
        ++numCourses;
    }

    /** Prints all courses and their grades */
    public void printGrades() {
        System.out.print(name);
        for (int i = 0; i < numCourses; ++i) {
            System.out.print(" " + courses[i] + ":" + grades[i]);
        }
        System.out.println();
    }

    /** Computes the average grade */
    public double getAverageGrade() {
        int sum = 0;
        for (int i = 0; i < numCourses; ++i) {
            sum += grades[i];
        }
        return (double)sum/numCourses;
    }
}


/**
 * A test driver program for the Student class.
 */
public class StudentExample {
    public static void main(String[] args) {
        // Test constructor and toString()
        Student student1 = new Student("Ali", "Istanbul");
        System.out.println(student1);  // toString()
        // Ali(Istanbul)

        // Test Setters and Getters
        student1.setAddress("Java Turkey");
        System.out.println(student1);
        // Ali(Java Turkey)
        System.out.println(student1.getName());
        // Ali
        System.out.println(student1.getAddress());
        // Java Turkey

        // Test addCourseGrade(), printGrades() and getAverageGrade()
        student1.addCourseGrade("M", 89);
        student1.addCourseGrade("S", 57);
        student1.addCourseGrade("A", 96);
        student1.printGrades();
        //Ali M:89 S:57 A:96
        System.out.printf("The average grade is %.2f%n", student1.getAverageGrade());
        //The average grade is 80.67
    }
}