/*
 * MainRecipe01.java
 */
package com.oz.java7.threads.ch3.main;

import com.oz.java7.threads.ch3.utils.Job;
import com.oz.java7.threads.ch3.utils.PrintQueue;

/**
 * Controlling concurrent access to a resource.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 15, 2014, 11:44:11 AM
 */
public class MainRecipe01 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread" + i);
        }

        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }

}
