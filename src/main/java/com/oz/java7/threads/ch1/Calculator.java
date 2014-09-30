/*
 * Calculator.java
 */
package com.oz.java7.threads.ch1;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Sep 30, 2014, 1:32:22 PM
 */
public class Calculator implements Runnable {
    
    private int number;
    
    /**
     * @param number
     */
    public Calculator(int number) {
        super();
        this.number = number;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%s: %d * %d = %d\n", Thread.currentThread().getName(), number, i, i*number);
        }
    }

}
