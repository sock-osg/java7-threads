/*
 * PrintQueue.java
 */
package com.oz.java7.threads.ch3.utils;

import java.util.concurrent.Semaphore;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 15, 2014, 11:32:37 AM
 */
public class PrintQueue {

    private final int maxThreadsAllowed = 1;

    private final Semaphore semaphore;

    /**
     * @param semaphore
     */
    public PrintQueue() {
        super();
        /*
         * Binary Semaphore
         * this.semaphore = new Semaphore(1);
         * The initial value of the internal counter is 1, so you will protect the access to one shared resource, in this case,
         * the print queue.
         * As occurs with other classes, the Semaphore class admits a second parameter in its
         * constructor. This parameter must take a Boolean value. If you give it the false value, you
         * are creating a semaphore that will work in non-fair mode. You will get the same behavior if you
         * don't use this parameter. If you give it the true value, you are creating a semaphore that will
         * work in fair mode.
         */ 
        this.semaphore = new Semaphore(this.maxThreadsAllowed);
    }

    public void printJob(Object document) {
        try {
            this.semaphore.acquire();

            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(), duration);
            Thread.sleep(duration * 1000);
        } catch (InterruptedException intExc) {
            intExc.printStackTrace();
        } finally {
            this.semaphore.release();
        }
    }

}
