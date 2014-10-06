/*
 * MainRecipe06.java
 */
package com.oz.java7.threads.ch1.main;

import java.util.Date;

import com.oz.java7.threads.ch1.utils.DataSourcesLoader;
import com.oz.java7.threads.ch1.utils.NetworkConnectionsLoader;

/**
 * Waiting for the finalization of a thread.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 12:39:01 PM
 */
public class MainRecipe06 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        DataSourcesLoader dsLoader = new DataSourcesLoader();
        Thread thread1 = new Thread(dsLoader, "DataSourceThread");

        NetworkConnectionsLoader ncLoader = new NetworkConnectionsLoader();
        Thread thread2 = new Thread(ncLoader, "NetworkConnectionLoader");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join(1000);
        } catch (InterruptedException intExc) {
            intExc.printStackTrace();
        }

        /*
         * At the moment whet both threads are finished, at that moment, the
         * main Thread object continues its execution and writes the final message.
         */
        System.out.printf("Main: Configuration has been loaded %s\n", new Date());
    }

}
