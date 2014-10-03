/*
 * TaskThree.java
 */
package com.oz.java7.threads.ch1;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 3, 2014, 5:36:07 PM
 */
public class TaskThree implements Runnable {

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
