/*
 * PrintQueue.java
 */
package com.oz.java7.threads.ch2.utils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 13, 2014, 4:11:33 PM
 */
public class PrintQueue {

    private final Lock queueLock = new ReentrantLock();

    public void printJob(Object document) {
        this.queueLock.lock();
        /*
         * The biggest difference with the lock() method is that this method, if the thread that uses it can't get the control of
         * the Lock interface, returns immediately and doesn't put the thread to sleep. This method returns a boolean value,
         * true if the thread gets the control of the lock, and false if not.
         */
        //this.queueLock.tryLock();

        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ": PrintQueue: Printing a Job during " + (duration / 1000)
                    + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally { 
            this.queueLock.unlock();
        }
    }
}
