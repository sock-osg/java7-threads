/*
 * Writter.java
 */
package com.oz.java7.threads.ch2.utils;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 14, 2014, 12:48:04 PM
 */
public class Writer implements Runnable {

    private PricesInfo pricesInfo;

    /**
     * @param pricesInfo
     */
    public Writer(PricesInfo pricesInfo) {
        super();
        this.pricesInfo = pricesInfo;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("Writer: Attempt to modify the prices.\n");
            pricesInfo.setPrices(Math.random() * 10, Math.random() * 8);
            System.out.printf("Writer: Prices have been modified.\n");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
