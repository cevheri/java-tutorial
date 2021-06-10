package com.cevher.java.generic;

import javax.print.DocFlavor;
import java.util.function.Function;

public class StringTransform {

    /*
     *
     *  As an example, the java.lang.String class (a non-generic class)
     *  contains a generic method called transform()
     *  (JDK 12) with the following signature:
     *  public class String {
     *     public <R> R transform(Function<? super String, ? extends R> f) {
     *        return f.apply(this);
     *     }
     *     ......
     *  }
     *
     */

    public final static boolean IF_DEF = false;

    public static void main(String[] args) {

        String str = "hello";
        //#ifdef JDK_12
        //            // Set the return-type R to Number
        //            // Set up Function<String, Number>, which takes a String and returns a Number
        //            Function<String, Number> f1 = String::length;  // int auto-box to Integer, upcast to Number
        //            // Run the .transform() on Function<String, Number>
        //            Number n1 = str.transform(f1);
        //            System.out.println(n1);             //5
        //            System.out.println(n1.getClass());  //class java.lang.Integer
        //            //Integer i1 = str.transform(f1);
        //            //compilation error: incompatible types: inference variable R has incompatible bounds
        //            Integer i1 = (Integer) str.transform(f1);  // Explicit downcast
        //            System.out.println(i1);             //5
        //
        //            // Double is a subtype of Number, satisfying <? extends R=Number>
        //            // Set up Function<String, Double>, which takes a String and returns a Double
        //            Function<String, Double> f2 = s -> (double) s.length();  // double -> Double
        //            Number n2 = str.transform(f2);      // Double upcast to Number
        //            System.out.println(n2);  //5.0
        //            System.out.println(n2.getClass());  //class java.lang.Double
        //            Double d2 = str.transform(f2);      // Okay
        //
        //            // CharSequence is a supertype of String, which satisfies <? super String>
        //            // Integer is a subtype of Number, satisfying <? extends R=Number>
        //            // Set up Function<CharSequence, Integer>, which takes a CharSequence and returns a Integer
        //            Function<CharSequence, Integer> f3 = CharSequence::length;  // int auto-box to Integer
        //            Number n3 = str.transform(f3);  // Upcast Integer to Number
        //            System.out.println(n3);   //5
        //#endif

    }

}
