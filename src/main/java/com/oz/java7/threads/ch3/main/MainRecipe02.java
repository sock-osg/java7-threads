/*
 * MainRecipe01.java
 */
package com.oz.java7.threads.ch3.main;

import com.oz.java7.threads.ch3.utils.JobTwo;
import com.oz.java7.threads.ch3.utils.PrintQueueTwo;

/**
 * Controlling concurrent access to multiple copies of a resource.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 15, 2014, 11:44:11 AM
 */
public class MainRecipe02 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PrintQueueTwo printQueue = new PrintQueueTwo();

        Thread[] thread = new Thread[100];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Thread(new JobTwo(printQueue), "Thread" + i);
        }

        for (int i = 0; i < thread.length; i++) {
            thread[i].start();
        }
    }

}
