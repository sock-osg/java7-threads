/*
 * MainChap01.java
 */
package com.oz.java7.threads.ch1;

/**
 * Chapter 1 - Creating and running a thread.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Sep 30, 2014, 1:35:45 PM
 */
public class MainRecipe01 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            Calculator calculator = new Calculator(i);
            
            Thread thread = new Thread(calculator);
            thread.start();
        }

    }

}
