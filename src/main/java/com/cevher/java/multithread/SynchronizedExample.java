package com.cevher.java.multithread;

class SynchronizedCounter {
    private static int count = 0;

    public synchronized static void increment() {
        ++count;
        System.out.println("Count is " + count + " @ " + System.nanoTime());
    }

    public synchronized static void decrement() {
        --count;
        System.out.println("Count is " + count + " @ " + System.nanoTime());
    }
}

public class SynchronizedExample {
    public static void main(String[] args) {
        Thread threadIncrement = new Thread(() -> {
            for (int i = 0; i < 10; ++i) {
                SynchronizedCounter.increment();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadDecrement = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    SynchronizedCounter.decrement();
                    try {
                        sleep(1);
                    } catch (InterruptedException ignored) {
                    }
                }
            }
        };

        threadIncrement.start();
        threadDecrement.start();
    }
}

/*
 * Count is 1 @ 64775511174712
 * Count is 0 @ 64775546735902
 * Count is 1 @ 64775547801101
 * Count is 0 @ 64775548541472
 * Count is 1 @ 64775548912095
 * Count is 0 @ 64775549689968
 * Count is 1 @ 64775550021776
 * Count is 0 @ 64775550849976
 * Count is 1 @ 64775551134244
 * Count is 0 @ 64775552011457
 * Count is 1 @ 64775552252403
 * Count is 0 @ 64775553153578
 * Count is 1 @ 64775553360025
 * Count is 0 @ 64775554315120
 * Count is 1 @ 64775554473558
 * Count is 0 @ 64775555494753
 * Count is 1 @ 64775555592787
 * Count is 0 @ 64775556645776
 * Count is 1 @ 64775556749968
 * Count is 0 @ 64775557810763
 */