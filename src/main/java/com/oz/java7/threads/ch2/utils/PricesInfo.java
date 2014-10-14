/*
 * PricesInfo.java
 */
package com.oz.java7.threads.ch2.utils;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 14, 2014, 12:41:05 PM
 */
public class PricesInfo {
    
    private double price1;
    private double price2;
    
    private ReadWriteLock lock;

    public PricesInfo() {
        super();
        this.price1 = 1.0;
        this.price2 = 2.0;
        this.lock = new ReentrantReadWriteLock();
    }

    /**
     * @return the price1
     */
    public double getPrice1() {
        this.lock.readLock().lock();
        double value = this.price1;
        this.lock.readLock().unlock();
        return value;
    }

    /**
     * @return the price2
     */
    public double getPrice2() {
        this.lock.readLock().lock();
        double value = this.price2;
        this.lock.readLock().unlock();
        return value;
    }
    
    public void setPrices(double price1, double price2) {
        this.lock.writeLock().lock();
        this.price1 = price1;
        this.price2 = price2;
        this.lock.writeLock().unlock();
    }

}
