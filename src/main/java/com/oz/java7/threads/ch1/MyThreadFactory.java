/*
 * MyThreadFactory.java
 */
package com.oz.java7.threads.ch1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 3, 2014, 5:06:16 PM
 */
public class MyThreadFactory implements ThreadFactory {
    
    private int counter;
    private String name;
    private List<String> stats;

    /**
     * 
     * @param name
     */
    public MyThreadFactory(String name) {
        super();
        this.name = name;
        this.counter = 0;
        this.stats = new ArrayList<>();
    }

    /* (non-Javadoc)
     * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable)
     */
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, this.name + "-Thread_" + this.counter);
        this.counter++;
        this.stats.add(String.format("Created thread %d with name %s on %s", thread.getId(), thread.getName(), new Date()));
        return thread;
    }
    
    public String getStats() {
        StringBuffer buffer = new StringBuffer();

        for (String item : this.stats) {
            buffer.append(item);
            buffer.append("\n");
        }
        
        return buffer.toString();
    }

}
