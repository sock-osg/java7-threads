/*
 * MainRecipe05.java
 */
package com.oz.java7.threads.ch2.main;

import com.oz.java7.threads.ch2.utils.PricesInfo;
import com.oz.java7.threads.ch2.utils.Reader;
import com.oz.java7.threads.ch2.utils.Writer;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 14, 2014, 12:53:43 PM
 */
public class MainRecipe05 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();
        
        Reader[] readers = new Reader[5];
        Thread[] threadsReader = new Thread[readers.length];
        
        for (int i = 0; i < readers.length; i++) {
            readers[i] = new Reader(pricesInfo);
            threadsReader[i] = new Thread(readers[i]);
        }
        
        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);
        
        for (Thread thread : threadsReader) {
            thread.start();
        }
        threadWriter.start();
    }

}
