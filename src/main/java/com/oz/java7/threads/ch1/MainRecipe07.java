/*
 * MainRecipe07.java
 */
package com.oz.java7.threads.ch1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Creating and running a daemon thread.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 1:36:54 PM
 */
public class MainRecipe07 {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<Event>();

        WriterTask writer = new WriterTask(deque);

        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writer);
            thread.start();
        }

        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }

}
