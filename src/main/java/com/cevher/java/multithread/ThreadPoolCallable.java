package com.cevher.java.multithread;

import java.util.concurrent.*;

class CallableWorkerThread implements Callable<String> {
    private int workerNumber;

    CallableWorkerThread(int workerNumber) {
        this.workerNumber = workerNumber;
    }

    public String call() {    // use call() instead of run()
        for (int i = 1; i <= 5; ++i) {    // just print 1 to 5
            System.out.printf("Worker %d: %d\n", workerNumber, i);
            try {
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {}
        }
        return "worker " + workerNumber;
    }
}
public class ThreadPoolCallable {
    public static void main(String[] args) {
        int numWorkers = Integer.parseInt(args[0]);

        ExecutorService pool = Executors.newCachedThreadPool();
        CallableWorkerThread[] workers = new CallableWorkerThread[numWorkers];
        Future[] futures = new Future[numWorkers];

        for (int i = 0; i < numWorkers; ++i) {
            workers[i] = new CallableWorkerThread(i + 1);
            futures[i] = pool.submit(workers[i]);
        }
        for (int i = 0; i < numWorkers; ++i) {
            try {
                System.out.println(futures[i].get() + " ended");
            } catch (InterruptedException ex) {
                System.out.println("InterruptedException - ?");
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                System.out.println("ExecutionException - ?");
                ex.printStackTrace();
            }
        }
    }
}