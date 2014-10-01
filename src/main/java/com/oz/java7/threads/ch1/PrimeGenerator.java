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
            
            /*
             * There is an important difference between the isInterrupted() and
             * the interrupted() methods. The first one doesn't change the value
             * of the interrupted attribute, but the second one sets it to false. As
             * the interrupted() method is a static method, the utilization of the
             * isInterrupted() method is recommended.
             */
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
