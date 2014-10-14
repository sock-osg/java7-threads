/*
 * MainRecipe06.java
 */
package com.oz.java7.threads.ch2.main;

import java.util.concurrent.TimeUnit;

import com.oz.java7.threads.ch2.utils.JobFair;
import com.oz.java7.threads.ch2.utils.PrintQueueFair;

/**
 * Modifying Lock fairness.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 14, 2014, 1:01:50 PM
 */
public class MainRecipe06 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PrintQueueFair printQueue = new PrintQueueFair();
        
        Thread[] thread = new Thread[10];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Thread(new JobFair(printQueue), "Thread " + i);
        }
        
        for (Thread currThread : thread) {
            currThread.start();
            
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException intExc) {
                intExc.printStackTrace();
            }
        }
    }

}
