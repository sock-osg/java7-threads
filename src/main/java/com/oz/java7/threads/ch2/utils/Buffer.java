/*
 * Buffer.java
 */
package com.oz.java7.threads.ch2.utils;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 14, 2014, 4:53:50 PM
 */
public class Buffer {
    
    private LinkedList<String> buffer;
    private int mazSize;
    private boolean pendingLines;

    private Lock lock;
    private Condition lines;
    private Condition space;
    
    /**
     * 
     */
    public Buffer(int maxSize) {
        super();
        this.mazSize = maxSize;
    }
    
}
