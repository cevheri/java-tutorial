package com.cevher.java.multithread;


class MyThread extends Thread {
    private String name;

    public MyThread(String name) {   // constructor
        this.name = name;
    }

    // Override the run() method to specify the thread's running behavior
    @Override
    public void run() {
        for (int i = 1; i <= 5; ++i) {
            System.out.println(name + ": " + i);
            Thread.yield();
        }
    }
}

public class CustomThread {

    public static void main(String[] args) {
        Thread[] threads = {
                new MyThread("Thread 1"),
                new MyThread("Thread 2"),
                new MyThread("Thread 3")
        };
        for (Thread t : threads) {
            t.start();
        }
    }
}
/*
 * output:
 * Thread 1: 1
 * Thread 3: 1
 * Thread 1: 2
 * Thread 2: 1
 * Thread 1: 3
 * Thread 3: 2
 * Thread 2: 2
 * Thread 3: 3
 * Thread 1: 4
 * Thread 1: 5
 * Thread 3: 4
 * Thread 3: 5
 * Thread 2: 3
 * Thread 2: 4
 * Thread 2: 5
 */