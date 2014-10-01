/*
 * MainRecipe03.java
 */
package com.oz.java7.threads.ch1;

/**
 * Chaper 1 - Inerrumpting a thread
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Sep 30, 2014, 4:37:03 PM
 */
public class MainRecipe03 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException intExc) {
            intExc.getStackTrace();
        }
        
        task.interrupt();
    }

}
