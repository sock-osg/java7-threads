/*
 * MainRecipe02.java
 */
package com.oz.java7.threads.ch1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Thread.State;

/**
 * Chapter 1 - Recipe Getting and setting thread information
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Sep 30, 2014, 3:30:49 PM
 */
public class MainRecipe02 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Thread[] threads = new Thread[100000];
        Thread.State[] status = new Thread.State[threads.length];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Calculator(i));
            threads[i].setPriority((i % 2) == 0 ? Thread.MAX_PRIORITY : Thread.MIN_PRIORITY);
            threads[i].setName("Thread " + i);
        }

        try (FileWriter file = new FileWriter("/tmp/out.log");
                PrintWriter pw = new PrintWriter(file);) {
            for (int i = 0; i < threads.length; i++) {
                pw.println("Main : status of Thread " + i + " : " + threads[i].getState());
                status[i] = threads[i].getState();
            }

            // Execute each threads
            for (int i = 0; i < threads.length; i++) {
                threads[i].start();
            }

            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < threads.length; i++) {
                    if (threads[i].getState() != status[i]) {
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i] = threads[i].getState();
                    }
                }
                finish = true;
                
                // Validate that all theads are finished.
                for (int i = 0; i < threads.length; i++) {
                    finish &= (threads[i].getState() == State.TERMINATED);
                }
            }
            
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : ************************************\n");
    }

}
