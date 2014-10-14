/*
 * Job.java
 */
package com.oz.java7.threads.ch2.utils;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 13, 2014, 4:17:05 PM
 */
public class JobFair implements Runnable {

    private PrintQueueFair printQueue;

    /**
     * @param printQueue
     */
    public JobFair(PrintQueueFair printQueue) {
        super();
        this.printQueue = printQueue;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        System.out.printf("%s: Going to print a document\n", Thread.currentThread().getName());
        this.printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }

}
