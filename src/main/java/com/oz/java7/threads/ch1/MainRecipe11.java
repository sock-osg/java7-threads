/*
 * MainRecipe11.java
 */
package com.oz.java7.threads.ch1;

/**
 * Processing uncontrolled exceptions in a group of threads.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 3, 2014, 4:40:10 PM
 */
public class MainRecipe11 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");
        TaskTwo task = new TaskTwo();
        
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(threadGroup, task);
            thread.start();
        }
    }

}
