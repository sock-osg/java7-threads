/*
 * ConsumerTwo.java
 */
package com.oz.java7.threads.ch2.utils;

import java.util.Random;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 15, 2014, 10:56:52 AM
 */
public class ConsumerTwo implements Runnable {
    
    private Buffer buffer;
    
    /**
     * @param buffer
     */
    public ConsumerTwo(Buffer buffer) {
        super();
        this.buffer = buffer;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        while (this.buffer.hasPendingLines()) {
            String line = this.buffer.get();
            this.processLine(line);
        }
    }

    private void processLine(String line) {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
