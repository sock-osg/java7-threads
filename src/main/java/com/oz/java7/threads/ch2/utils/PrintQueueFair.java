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
public class PrintQueueFair {

    private final Lock queueLock = new ReentrantLock(true);

    public void printJob(Object document) {
        this.queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during " + (duration / 1000)
                    + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.queueLock.unlock();
        }
        
        this.queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during " + (duration / 1000)
                    + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.queueLock.unlock();
        }

    }
}
