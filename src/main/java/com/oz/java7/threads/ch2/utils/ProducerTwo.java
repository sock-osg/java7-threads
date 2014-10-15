/*
 * ProducerTwo.java
 */
package com.oz.java7.threads.ch2.utils;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 15, 2014, 10:53:03 AM
 */
public class ProducerTwo implements Runnable {
    
    private FileMock mock;
    private Buffer buffer;

    /**
     * @param mock
     * @param buffer
     */
    public ProducerTwo(FileMock mock, Buffer buffer) {
        super();
        this.mock = mock;
        this.buffer = buffer;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        this.buffer.setPendingLines(true);
        
        while (this.mock.hasMoreLines()) {
            String line = this.mock.getLine();
            this.buffer.insert(line);
        }
        this.buffer.setPendingLines(false);
    }

}
