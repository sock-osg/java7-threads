/*
 * MainRecipe09A.java
 */
package com.oz.java7.threads.ch1.main;

import java.util.concurrent.TimeUnit;

import com.oz.java7.threads.ch1.utils.UnsafeTask;

/**
 * Using local thread variables - Unsafe.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 5:02:32 PM
 */
public class MainRecipe09A {

    /**
     * @param args
     */
    public static void main(String[] args) {
        UnsafeTask task = new UnsafeTask();
        
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();
            
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException intExc) {
                intExc.printStackTrace();
            }
        }

    }

}
