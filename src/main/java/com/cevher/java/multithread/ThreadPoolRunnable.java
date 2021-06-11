package com.cevher.java.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable{
    private final int workerNumber;

    WorkerThread(int workerNumber){
        this.workerNumber= workerNumber;
    }

    public void run() {
        // The thread simply prints 1 to 5
        for (int i = 1; i <= 5; ++i) {
            System.out.printf("Worker %d: %d\n", workerNumber, i);
            try {
                // sleep for 0 to 0.5 second
                Thread.sleep((int)(Math.random() * 500));
            } catch (InterruptedException ignored) {}
        }
    }
}
public class ThreadPoolRunnable {
    public static void main(String[] args) {
        int numWorkers = 3;
        int threadPoolSize = 5;

        ExecutorService pool =
                Executors.newFixedThreadPool(threadPoolSize);
        WorkerThread[] workers = new WorkerThread[numWorkers];
        for (int i = 0; i < numWorkers; ++i) {
            workers[i] = new WorkerThread(i+1);
            pool.execute(workers[i]);
        }
        // pool.shutdown() to shutdown all the threads in the pool.
        pool.shutdown();
    }
}
/*
 * Worker 1: 1
 * Worker 3: 1
 * Worker 2: 1
 * Worker 3: 2
 * Worker 1: 2
 * Worker 2: 2
 * Worker 2: 3
 * Worker 3: 3
 * Worker 1: 3
 * Worker 2: 4
 * Worker 3: 4
 * Worker 3: 5
 * Worker 1: 4
 * Worker 1: 5
 * Worker 2: 5
 *
 * Process finished with exit code 0
 */