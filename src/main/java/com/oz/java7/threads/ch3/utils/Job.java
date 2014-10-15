/*
 * Job.java
 */
package com.oz.java7.threads.ch3.utils;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 15, 2014, 11:40:02 AM
 */
public class Job implements Runnable {

    private PrintQueue printQueue;

    /**
     * @param printQueue
     */
    public Job(PrintQueue printQueue) {
        super();
        this.printQueue = printQueue;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
        this.printQueue.printJob(new Object());
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }

}
