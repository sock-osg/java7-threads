/*
 * Buffer.java
 */
package com.oz.java7.threads.ch2.utils;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 14, 2014, 4:53:50 PM
 */
public class Buffer {

    private LinkedList<String> buffer;
    private int maxSize;
    private boolean pendingLines;

    private Lock lock;
    private Condition lines;
    private Condition space;

    /**
     * 
     */
    public Buffer(int maxSize) {
        super();
        this.maxSize = maxSize;
        this.buffer = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.lines = lock.newCondition();
        this.space = lock.newCondition();
        this.pendingLines = true;
    }

    public void insert(String line) {
        this.lock.lock();

        try {
            while (this.buffer.size() == this.maxSize) {
                // the current thread is waiting for free space
                this.space.await();
            }
            this.buffer.offer(line);
            System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(),buffer.size());
            this.lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.lock.unlock();
        }
    }
    
    public String get() {
        String line = null;
        this.lock.lock();
        
        try {
            while ((this.buffer.size() == 0) && this.hasPendingLines()) {
                this.lines.await();
            }
            
            if (this.hasPendingLines()) {
                line = this.buffer.poll();
                System.out.printf("%s: Line Readed: %d\n",Thread.currentThread().getName(), this.buffer.size());
                this.space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.lock.lock();
        }
        
        return line;
    }

    public boolean hasPendingLines() {
        return this.pendingLines || !this.buffer.isEmpty(); 
    }

    /**
     * @param pendingLines the pendingLines to set
     */
    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }

}
