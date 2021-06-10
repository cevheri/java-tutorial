package com.cevher.java.generic;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // Set "E" to "String"
        ArrayList<String> fruitLst = new ArrayList<>();
        fruitLst.add("apple");
        fruitLst.add("orange");
        System.out.println(fruitLst);  //[apple, orange]
        // JDK 5 also introduces the for-each loop
        for (String str: fruitLst) {   // we need to know type of elements
            System.out.println(str);
        }
        //apple
        //orange

        // Adding non-String type triggers compilation error
        //fruitLst.add(99);
        //compilation error: incompatible types: int cannot be converted to String

        // JDK 7 introduces diamond operator <> for type inference to shorten the code
        ArrayList<String> coffeeLst = new ArrayList<>();  // can omit type in instantiation
        coffeeLst.add("espresso");
        coffeeLst.add("latte");
        System.out.println(coffeeLst);  //[espresso, latte]

        // We commonly program at the specification in List instead of implementation ArrayList
        List<String> animalLst = new ArrayList<>();  // Upcast ArrayList<String> to List<String>
        animalLst.add("tiger");
        System.out.println(animalLst);  //[tiger]

        // A Collection holds only objects, not primitives
        // Try auto-box/unbox between primitives and wrapper objects
        List<Integer> intLst = new ArrayList<>();
        intLst.add(11);  // primitive "int" auto-box to "Integer" (JDK 5)
        int i1 = intLst.get(0);  // "Integer" auto-unbox to primitive "int"
        System.out.println(intLst);  //[11]
        //intLst.add(2.2);
        //compilation error: incompatible types: double cannot be converted to Integer

        // "Number" is a supertype of "Integer" and "Double"
        List<Number> numLst = new ArrayList<>();
        numLst.add(33);   // primitive "int" auto-box to "Integer", upcast to Number
        numLst.add(4.4);  // primitive "double" auto- box to "Double", upcast to Number
        System.out.println(numLst);  //[33, 4.4]
}
}