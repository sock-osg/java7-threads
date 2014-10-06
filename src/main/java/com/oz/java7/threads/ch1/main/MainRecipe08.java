/*
 * MainRecipe08.java
 */
package com.oz.java7.threads.ch1.main;

import com.oz.java7.threads.ch1.utils.ExceptionHandler;
import com.oz.java7.threads.ch1.utils.Task;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 2:48:26 PM
 */
public class MainRecipe08 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Task task = new Task();
        Thread thread = new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());

        thread.start();
    }

}
