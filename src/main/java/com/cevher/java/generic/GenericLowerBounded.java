package com.cevher.java.generic;

import java.util.List;
import java.util.function.Consumer;

public class GenericLowerBounded {
    public static void main(String[] args) {
        List<Double> doubleList = List.of(0.0, 1.1, 2.3, 3.4, 4.5, 5.6, 6.7, 7.8, 8.9);
        Consumer<Double> doubleConsumer = d ->
                System.out.printf("%x%n",
                        Double.doubleToRawLongBits(d));
        // double consumer
        doubleList.forEach(doubleConsumer);
        // consumer one line alternative
        doubleList.forEach(d -> {
            System.out.printf("%x%n",
                    Double.doubleToRawLongBits(d));
        });

        // Number Consumer
        Consumer<Number> numberConsumer = n ->
                System.out.println(n.intValue());
        System.out.println("Number Convert to int");
        doubleList.forEach(numberConsumer);

        // Consumer one line alternative
        System.out.println("Double Convert to in");
        doubleList.forEach(n -> {
            System.out.println(n.intValue());
            // Number num = (Number) n;
            // System.out.println(num.intValue());
        });

    }
}
