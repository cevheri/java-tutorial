package com.cevher.java.generic;

import java.util.*;

@FunctionalInterface
interface MyConsumer<T> {
    void accept(T t);  // public abstract
}

// Need 3 levels of class hierarchy for testing
class C1 {
    protected String value;
    public C1(String value) { this.value = value; }
    public void methodC1() { System.out.println(this + " runs methodC1()"); }
    @Override public String toString() { return "C1[" + value + "]"; }
}
class C2 extends C1 {
    public C2(String value) { super(value); }
    public void methodC2() { System.out.println(this + " runs methodC2()"); }
    @Override public String toString() { return "C2[" + value + "]"; }
}
class C3 extends C2 {
    public C3(String value) { super(value); }
    public void methodC3() { System.out.println(this + " runs methodC3()"); }
    @Override public String toString() { return "C3[" + value + "]"; }
}

public class GenericUpperLowerWildcard {
    // For a specific T only
    public static <T> T processAll1(Collection<T> coll, MyConsumer<T> consumer) {
        T last = null;
        for (T t : coll) {
            last = t;
            consumer.accept(t);
        }
        return last;
    }

    // Lower bounded wildcard
    public static <T> T processAll2(Collection<T> coll, MyConsumer<? super T> consumer) {
        T last = null;
        for (T t : coll) {
            last = t;
            consumer.accept(t); // t supports all its supertype's operations
        }
        return last;
    }

    // Lower bounded and upper bounded wildcards
    public static <T> T processAll3(Collection<? extends T> coll, MyConsumer<? super T> consumer) {
        T last = null;
        for (T t : coll) {     // T's subtype elements can be upcast to T
            last = t;
            consumer.accept(t); // t supports all its supertype's operations
        }
        return last;
    }

    public static void main(String[] args) {
        // Set T to C2
        // Try processAll1(Collection<C2>, MyConsumer<C2>)
        Collection<C2> fruits = List.of(new C2("apple"), new C2("orange"));
        MyConsumer<C2> consumer1 = C2::methodC2;  // Can use C2's methods
        C2 result1 = processAll1(fruits, consumer1);
        //C2[apple] runs methodC2()
        //C2[orange] runs methodC2()
        System.out.println(result1);
        //C2[orange]

        // Try processAll2(Collection<C2>, MyConsumer<C1 super C2>)
        MyConsumer<C1> consumer2 = C1::methodC1;
        // Can use only C1's methods. But subtype C2 supports all C1's methods
        //processAll1(fruits, consumer2);  // wrong type for consumer2 in processAll1()
        //error: method processAll1 in class GenericWildardTest cannot be applied to given types
        C2 result2 = processAll2(fruits, consumer2);
        //C2[apple] runs methodC1()
        //C2[orange] runs methodC1()
        System.out.println(result2);
        //C2[orange]

        // Try processAll3(Collection<C3 extends C2>, MyConsumer<C1 super C2>)
        Collection<C3> coffees = List.of(new C3("espresso"), new C3("latte"));
        C2 result3 = processAll3(coffees, consumer2);
        //C3[espresso] runs methodC1()
        //C3[latte] runs methodC1()
        System.out.println(result3);
        //C3[latte]
        processAll3(coffees, consumer2).methodC3();
        //C3[espresso] runs methodC1()
        //C3[latte] runs methodC1()
        //C3[latte] runs methodC3()

        // Try subclass List of Collection
        List<C3> animals = List.of(new C3("tiger"), new C3("lion"));
        C2 result4 = processAll3(animals, consumer2);
        //C3[tiger] runs methodC1()
        //C3[lion] runs methodC1()
        System.out.println(result4);
        //C3[lion]
    }
}