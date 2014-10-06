/*
 * DataSourcesLoader.java
 */
package com.oz.java7.threads.ch1.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 12:34:24 PM
 */
public class DataSourcesLoader implements Runnable {

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        System.out.printf("Beginning data sources loading: %s\n", new Date());

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException intExc) {
            intExc.printStackTrace();
        }

        System.out.printf("Data sources loading has finished: %s\n", new Date());
    }

}
