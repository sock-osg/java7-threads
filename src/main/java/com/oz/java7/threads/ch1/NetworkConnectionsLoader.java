/*
 * NetworkConnectionsLoader.java
 */
package com.oz.java7.threads.ch1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 12:37:41 PM
 */
public class NetworkConnectionsLoader implements Runnable {

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        System.out.printf("Network Beginning data sources loading: %s\n", new Date());

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException intExc) {
            intExc.printStackTrace();
        }

        System.out.printf("Network Data sources loading has finished: %s\n", new Date());
    }

}
