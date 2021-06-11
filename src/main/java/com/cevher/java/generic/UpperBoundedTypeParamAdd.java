package com.cevher.java.generic;

public class UpperBoundedTypeParamAdd {

    public static <T extends Number> double add(T first, T second) {
        // Need to use only methods defined in Number, such as doubleValue
        // Subtypes Integer and Double inherit and support these methods too.
        return first.doubleValue() + second.doubleValue();
    }

    public static <T extends Comparable<T>> T maximum(T x, T y) {
        // Need to restrict T to Comparable and its subtype for .compareTo()
        return (x.compareTo(y) > 0) ? x : y;
    }

    public static void main(String[] args) {
        System.out.println(add(55, 66));     // int -> Integer. T is Integer.
        System.out.println(add(5.5f, 6.6f)); // float -> Float. T is Float.
        System.out.println(add(5.5, 6.6));   // double -> Double. T is Double.
        System.out.println(add(55, 6.6));    // int -> double -> Double. T is Double.
        //System.out.println(add("apple", "orange"));
        //compilation error: method add in class UpperBoundedTypeParameterTest
        //  cannot be applied to given types;


        // Upper BoundedType Param Maximum val
        System.out.println(maximum(55, 66));    // 66
        System.out.println(maximum(6.6, 5.5));  // 6.6
        System.out.println(maximum("Monday", "Tuesday"));  // Tuesday


        // Bounded Type Parameter for Generic Class
        //The bounded type parameter <T extends ClassName> can also be applied to generic class, e.g.,
        MagicNumber<Double> n1 = new MagicNumber<>(9.9);
        System.out.println(n1);           //MagicNumber[value=9.9]
        System.out.println(n1.isMagic()); //true

        MagicNumber<Float> n2 = new MagicNumber<>(1.23f);
        System.out.println(n2);           //MagicNumber[value=1.23]
        System.out.println(n2.isMagic()); //false

        MagicNumber<Number> n3 = new MagicNumber<>(1);
        System.out.println(n3);           //MagicNumber[value=1]
        System.out.println(n3.isMagic()); //false

        //MagicNumber<String> n4 = new MagicNumber<>("hello");
        //error: type argument String is not within bounds of type-variable T
    }
}

class MagicNumber<T extends Number> {
    private final T value;

    public MagicNumber(T value) {
        this.value = value;
    }

    public boolean isMagic() {
        return value.intValue() == 9;
    }

    public String toString() {
        return "MagicNumber[value=" + value + "]";
    }

}