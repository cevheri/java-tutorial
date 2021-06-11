package com.cevher.java.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericWildcard {

    /**
     * Accepts List<Object>, NOT list<String>, List<Integer>, etc.
     */
    public static void printListObject(List<Object> lst) {
        for (Object o : lst) System.out.println(o);
    }
    /**
     * Unbounded Wildcard <?>
     */
    public static void printListWildcard(List<?> lst) {
        for (Object o : lst) System.out.println(o);
    }

    /**
     * Generic method which accepts List<Number>
     * and Number's subtypes such as Integer, Double
     * @param lst Number such as Integer, Double
     * @return double
     */
    public static double sumList(List<? extends Number> lst) {
        double sum = 0.0;
        for (Number num : lst) {
            sum += num.doubleValue();
        }
        return sum;
    }

    /**
     * Generic method which accepts List<Integer>
     * and Integer's supertypes such as Number and Object
     * @param lst Number
     * @param num int
     */
    public static void addIntToList(List<? super Integer> lst, int num) {
        lst.add(num);
    }
    public static void main(String[] args) {
        List<Object> objLst = new ArrayList<>();  // ArrayList<Object> inferred
        objLst.add(11);  // int auto-box to Integer, upcast to Object
        objLst.add(22);
        printListObject(objLst);
        // 11
        // 22
        List<String> strLst = new ArrayList<>();  // ArrayList<String> inferred
        strLst.add("one");
        //printList(strLst);  // only accept List<Object>
        //error: incompatible types: List<String> cannot be converted to List<Object>

        // Upper Bounded Wildcard <? extends T>
        List<Integer> intLst = List.of(1, 2, 3); // JDK 9 unmodifiable List
        System.out.println(sumList(intLst));  //6.0
        List<Double> doubleLst = List.of(1.1, 2.2, 3.3);
        System.out.println(sumList(doubleLst));  //6.6


        // Lower Bounded Wildcard <? super T>
        List<Integer> intLst2 = new ArrayList<>(); // modifiable List
        intLst2.add(1);
        intLst2.add(2);
        System.out.println(intLst2);  //[1, 2]
        addIntToList(intLst2, 3);
        System.out.println(intLst2);  //[1, 2, 3]

        List<Number> numLst2 = new ArrayList<>();
        numLst2.add(1.1);
        numLst2.add(2.2);
        System.out.println(numLst2);  //[1.1, 2.2]
        addIntToList(numLst2, 3);
        System.out.println(numLst2);  //[1.1, 2.2, 3]

        List<String> strLst2 = new ArrayList<>();
        //addIntToList(strLst2, "hello");
        //error: incompatible types: List<String> cannot be converted to List<? super Integer>

    }
}