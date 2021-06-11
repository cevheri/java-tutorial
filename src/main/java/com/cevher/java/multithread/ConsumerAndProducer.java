package com.cevher.java.multithread;
// Testing wait() and notify()
class MessageBox {
    private String message;
    private boolean hasMessage;

    // producer
    public synchronized void putMessage(String message) {
        while (hasMessage) {
            // no room for new message
            try {
                wait();  // release the lock of this object
            } catch (InterruptedException ignored) { }
        }
        // acquire the lock and continue
        hasMessage = true;
        this.message = message + " Put @ " + System.nanoTime();
        notify();
    }

    // consumer
    public synchronized String getMessage() {
        while (!hasMessage) {
            // no new message
            try {
                wait();  // release the lock of this object
            } catch (InterruptedException ignored) { }
        }
        // acquire the lock and continue
        hasMessage = false;
        notify();
        return message + " Get @ " + System.nanoTime();
    }
}
public class ConsumerAndProducer {
    public static void main(String[] args) {
        final MessageBox box = new MessageBox();

        Thread producerThread = new Thread() {
            @Override
            public void run() {
                System.out.println("Producer thread started...");
                for (int i = 1; i <= 6; ++i) {
                    box.putMessage("message " + i);
                    System.out.println("Put message " + i);
                }
            }
        };

        Thread consumerThread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("Consumer thread 1 started...");
                for (int i = 1; i <= 3; ++i) {
                    System.out.println("Consumer thread 1 Get " + box.getMessage());
                }
            }
        };

        Thread consumerThread2 = new Thread() {
            @Override
            public void run() {
                System.out.println("Consumer thread 2 started...");
                for (int i = 1; i <= 3; ++i) {
                    System.out.println("Consumer thread 2 Get " + box.getMessage());
                }
            }
        };

        consumerThread1.start();
        consumerThread2.start();
        producerThread.start();
    }
}
/*
 * Consumer thread 1 started...
 * Consumer thread 2 started...
 * Producer thread started...
 * Put message 1
 * Put message 2
 * Put message 3
 * Consumer thread 2 Get message 2 Put @ 65172603297671 Get @ 65172603342951
 * Consumer thread 2 Get message 3 Put @ 65172603392900 Get @ 65172610879549
 * Consumer thread 2 Get message 4 Put @ 65172610916893 Get @ 65172610970409
 * Consumer thread 1 Get message 1 Put @ 65172574889335 Get @ 65172602625555
 * Put message 4
 * Put message 5
 * Consumer thread 1 Get message 5 Put @ 65172611383917 Get @ 65172611412167
 * Put message 6
 * Consumer thread 1 Get message 6 Put @ 65172611479480 Get @ 65172611533228
 *
 * Process finished with exit code 0
 */