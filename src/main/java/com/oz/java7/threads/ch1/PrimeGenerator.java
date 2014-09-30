/*
 * PrimeGenerator.java
 */
package com.oz.java7.threads.ch1;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Sep 30, 2014, 4:31:00 PM
 */
public class PrimeGenerator extends Thread {

    /*
     * (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        long number = 1l;

        while (true) {
            if (this.isPrime(number)) {
                System.out.printf("Number %d is Prime\n", number);
            }

            if (this.isInterrupted()) {
                System.out.println("The Prime Generator has been Interrumped");
                return;
            }

            number++;
        }
    }

    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if ((number % i) == 0) {
                return false;
            }
        }
        return true;
    }

}
