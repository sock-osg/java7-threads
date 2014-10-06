/*
 * MainRecipe12.java
 */
package com.oz.java7.threads.ch1.main;

import com.oz.java7.threads.ch1.utils.MyThreadFactory;
import com.oz.java7.threads.ch1.utils.TaskThree;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 6, 2014, 11:26:24 AM
 */
public class MainRecipe12 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
        TaskThree task = new TaskThree();

        Thread thread = null;
        System.out.println("Starting the threads");

        for (int i = 0; i < 1000; i++) {
            thread = factory.newThread(task);
            thread.start();
        }

        System.out.printf("Factory status:\n");
        System.out.printf("%s\n", factory.getStats());
    }

}
