/*
 * MainRecipe04.java
 */
package com.oz.java7.threads.ch2.main;

import com.oz.java7.threads.ch2.utils.Job;
import com.oz.java7.threads.ch2.utils.PrintQueue;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 13, 2014, 4:18:40 PM
 */
public class MainRecipe04 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        
        Thread[] thread = new Thread[10];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }
        
        for (Thread currThread : thread) {
            currThread.start();
        }
    }

}
