/*
 * FileClock.java
 */
package com.oz.java7.threads.ch1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 10:25:45 AM
 */
public class FileClock implements Runnable {

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("Iteration %d - %s\n", i, new Date());

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException intExc) {
                System.out.printf("The FileClock has been interrupted in iteration %d\n", i);
            }
        }
    }

}
