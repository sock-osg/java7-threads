/*
 * MainRecipe09A.java
 */
package com.oz.java7.threads.ch1.main;

import java.util.concurrent.TimeUnit;

import com.oz.java7.threads.ch1.utils.SafeTask;

/**
 * Using local thread variables - Safe
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 5:02:32 PM
 */
public class MainRecipe09B {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SafeTask task = new SafeTask();
        
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
