/*
 * Reader.java
 */
package com.oz.java7.threads.ch2.utils;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 14, 2014, 12:45:50 PM
 */
public class Reader implements Runnable {

    private PricesInfo pricesInfo;

    /**
     * @param pricesInfo
     */
    public Reader(PricesInfo pricesInfo) {
        super();
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s: Price 1: %f\n", Thread.currentThread().getName(), this.pricesInfo.getPrice1());
            System.out.printf("%s: Price 2: %f\n", Thread.currentThread().getName(), this.pricesInfo.getPrice2());
        }
    }

}
