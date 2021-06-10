package com.cevher.java.generic;

import java.util.*;

public class GenericUpperBounded {

    public static void main(String[] args) {

        // Set E to Number.
        // Number is supertype of Integer, Double and Float
        List<Number> numberList = new ArrayList<>();
        numberList.add(1);
        System.out.println(numberList); // [1]

        // Integer is a subtype of Number, which satisfies <? extends E=Number>
        Collection<Integer> integerCollection = new LinkedList<>();
        integerCollection.add(2);
        integerCollection.add(3);
        System.out.println(integerCollection);//[2, 3]
        // Try .addAll(Collection<Integer extends Number>)
        numberList.addAll(integerCollection);
        System.out.println(numberList);//[1, 2, 3]

        // Double is a subtype of Number, which satisfies <? extends E=Number>
        // Set is a subtype of Collection. Set<Double> is a subtype of Collection<Double>
        Set<Double> doubleSet = new HashSet<>();
        doubleSet.add(4.0);
        doubleSet.add(5.1);
        System.out.println(doubleSet);//[4.0, 5.1]
        // Try .addAll(Collection<Double extends Number>)
        numberList.addAll(doubleSet);
        System.out.println(numberList);//[1, 2, 3, 4.0, 5.1]

    }
}
