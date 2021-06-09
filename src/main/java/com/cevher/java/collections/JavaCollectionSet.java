package com.cevher.java.collections;

import java.util.HashSet;
import java.util.Set;

public class JavaCollectionSet {

    /*
     * Interface java.util.Set<E>
     * abstract boolean add(E o)           // adds the specified element if it is not already present
     * abstract boolean remove(Object o)   // removes the specified element if it is present
     * abstract boolean contains(Object o) // returns true if it contains o
     *****************
     * Set operations
     * abstract boolean addAll(Collection<? extends E> c) // Set union
     * abstract boolean retainAll(Collection<?> c)        // Set intersection
     */

    public static void main(String[] args) {
        Book book1 = new Book(1, "Java for Dummies");
        Book book1Dup = new Book(1, "Java for the Dummies"); // same id as above
        Book book2 = new Book(2, "Java for more Dummies");
        Book book3 = new Book(3, "more Java for more Dummies");

        Set<Book> set1 = new HashSet<>();
        set1.add(book1);
        set1.add(book1Dup); // duplicate id, not added
        set1.add(book1);    // added twice, not added
        set1.add(book3);
        set1.add(null);     // Set can contain a null
        set1.add(null);     // but no duplicate
        set1.add(book2);
        System.out.println(set1);
        //[null, 1: Java for Dummies, 2: Java for more Dummies, 3: more Java for more Dummies]

        set1.remove(book1);
        set1.remove(book3);
        System.out.println(set1); //[null, 2: Java for more Dummies]

        Set<Book> set2 = new HashSet<>();
        set2.add(book3);
        System.out.println(set2); //[3: more Java for more Dummies]

        set2.addAll(set1);        // "union" with set1
        System.out.println(set2); //[null, 2: Java for more Dummies, 3: more Java for more Dummies]

        set2.remove(null);
        System.out.println(set2); //[2: Java for more Dummies, 3: more Java for more Dummies]

        set2.retainAll(set1);     // "intersection" with set1
        System.out.println(set2); //[2: Java for more Dummies]
    }

}

class Book {
    private int id;
    private String title;

    public Book(int id, String title) {  // constructor
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {  // describle itself
        return id + ": " + title;
    }

    // Two books are equal if they have the same id
    @Override
    public boolean equals(Object o) {
        return o != null && o instanceof Book && this.id == ((Book)o).id;
    }

    // To be consistent with equals(). Two objects which are equal have the same hash code.
    @Override
    public int hashCode() {
        return id;
    }
}