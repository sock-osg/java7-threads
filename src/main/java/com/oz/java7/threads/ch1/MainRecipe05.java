/*
 * MainRecipe05.java
 */
package com.oz.java7.threads.ch1;

import java.util.concurrent.TimeUnit;

/**
 * Sleeping and resuming a thread.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 10:30:33 AM
 */
public class MainRecipe05 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        FileClock clock = new FileClock();
        Thread thread = new Thread(clock);
        thread.start();

        try {
            /*
             * When you call the sleep() method, Thread leaves the CPU and stops its execution for a
             * period of time. During this time, it's not consuming CPU time, so the CPU can be executing
             * other tasks.
             */
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException intExc) {
            intExc.printStackTrace();
        }
        
        thread.interrupt();
    }

}
