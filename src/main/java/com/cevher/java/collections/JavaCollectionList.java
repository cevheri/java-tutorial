package com.cevher.java.collections;

import java.util.ArrayList;
import java.util.List;

public class JavaCollectionList {


    public static void main(String[] args) {

        // Collection holds only objects, not primitives
        List<Integer> ls = new ArrayList<>();  // List of Integer object (not int)
        ls.add(1);  // auto-box primitive int to Integer object
        ls.add(2);
        System.out.println(ls);    // [1, 2]
        int first = ls.get(0);  // auto-unbox Integer object to int
        System.out.println(first);  // 1

    }


}
