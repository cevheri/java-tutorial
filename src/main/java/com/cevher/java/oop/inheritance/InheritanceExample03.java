package com.cevher.java.oop.inheritance;
/**
 * The superclass Person has name and address.
 */
class Person {
    // private instance variables
    private final String name;
    private String address;

    /** Constructs a Person instance with the given name and address */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getters and Setters
    /** Returns the name */
    public String getName() {
        return name;
    }
    /** Returns the address */
    public String getAddress() {
        return address;
    }
    /** Sets the address */
    public void setAddress(String address) {
        this.address = address;
    }

    /** Returns a self-descriptive string */
    @Override
    public String toString() {
        return name + "(" + address + ")";
    }
}

/**
 * The Student class, subclass of Person.
 */
class Student extends Person {
    // private instance variables
    private int numCourses;   // number of courses taken so far
    private final String[] courses; // course codes
    private final int[] grades;     // grade for the corresponding course codes
    private static final int MAX_COURSES = 30; // maximum number of courses

    /** Constructs a Student instance with the given name and address */
    public Student(String name, String address) {
        super(name, address);
        numCourses = 0;
        courses = new String[MAX_COURSES];
        grades = new int[MAX_COURSES];
    }

    /** Returns a self-descriptive string */
    @Override
    public String toString() {
        return "Student: " + super.toString();
    }

    /** Adds a course and its grade - No input validation */
    public void addCourseGrade(String course, int grade) {
        courses[numCourses] = course;
        grades[numCourses] = grade;
        ++numCourses;
    }

    /** Prints all courses taken and their grade */
    public void printGrades() {
        System.out.print(this);
        for (int i = 0; i < numCourses; ++i) {
            System.out.print(" " + courses[i] + ":" + grades[i]);
        }
        System.out.println();
    }

    /** Computes the average grade */
    public double getAverageGrade() {
        int sum = 0;
        for (int i = 0; i < numCourses; i++ ) {
            sum += grades[i];
        }
        return (double)sum/numCourses;
    }
}

/**
 * The Teacher class, subclass of Person.
 */
class Teacher extends Person {
    // private instance variables
    private int numCourses;   // number of courses taught currently
    private final String[] courses; // course codes
    private static final int MAX_COURSES = 5; // maximum courses

    /** Constructs a Teacher instance with the given name and address */
    public Teacher(String name, String address) {
        super(name, address);
        numCourses = 0;
        courses = new String[MAX_COURSES];
    }

    /** Returns a self-descriptive string */
    @Override
    public String toString() {
        return "Teacher: " + super.toString();
    }

    /** Adds a course. Returns false if the course has already existed */
    public boolean addCourse(String course) {
        // Check if the course already in the course list
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) return false;
        }
        courses[numCourses] = course;
        numCourses++;
        return true;
    }

    /** Removes a course. Returns false if the course cannot be found in the course list */
    public boolean removeCourse(String course) {
        boolean found = false;
        // Look for the course index
        int courseIndex = -1;  // need to initialize
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                courseIndex = i;
                found = true;
                break;
            }
        }
        if (found) {
            // Remove the course and re-arrange for courses array
            if (numCourses - 1 - courseIndex >= 0)
                System.arraycopy(courses, courseIndex + 1, courses, courseIndex, numCourses - 1 - courseIndex);
            numCourses--;
            return true;
        } else {
            return false;
        }
    }
}

public class InheritanceExample03 {
    public static void main(String[] args) {
        /* Test Student class */
        Student s1 = new Student("Tan Ah Teck", "1 Happy Ave");
        s1.addCourseGrade("IM101", 97);
        s1.addCourseGrade("IM102", 68);
        s1.printGrades();
        //Student: Tan Ah Teck(1 Happy Ave) IM101:97 IM102:68
        System.out.println("Average is " + s1.getAverageGrade());
        //Average is 82.5

        /* Test Teacher class */
        Teacher t1 = new Teacher("Paul Tan", "8 sunset way");
        System.out.println(t1);
        //Teacher: Paul Tan(8 sunset way)
        String[] courses = {"IM101", "IM102", "IM101"};
        for (String course: courses) {
            if (t1.addCourse(course)) {
                System.out.println(course + " added");
            } else {
                System.out.println(course + " cannot be added");
            }
        }
        //IM101 added
        //IM102 added
        //IM101 cannot be added
        for (String course: courses) {
            if (t1.removeCourse(course)) {
                System.out.println(course + " removed");
            } else {
                System.out.println(course + " cannot be removed");
            }
        }
        //IM101 removed
        //IM102 removed
        //IM101 cannot be removed
    }
}
