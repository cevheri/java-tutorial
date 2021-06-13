package com.cevher.java;

enum TrafficLight {
    // Each instance provides its implementation to abstract method
    RED(30) {
        public TrafficLight next() {
            return GREEN;
        }
    },
    AMBER(10) {
        public TrafficLight next() {
            return RED;
        }
    },
    GREEN(30) {
        public TrafficLight next() {
            return AMBER;
        }
    };

    public abstract TrafficLight next(); // An abstract method

    private final int seconds;     // Private variable

    TrafficLight(int seconds) {          // Constructor
        this.seconds = seconds;
    }

    int getSeconds() {             // Getter
        return seconds;
    }
}

public class TrafficLightEnum {
    public static void main(String[] args) {
        for (TrafficLight light : TrafficLight.values()) {
            System.out.printf("%s: %d seconds, next is %s\n", light,
                    light.getSeconds(), light.next());
        }
    }
}