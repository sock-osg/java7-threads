/*
 * WriterTask.java
 */
package com.oz.java7.threads.ch1.utils;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 1:20:34 PM
 */
public class WriterTask implements Runnable {
    
    private Deque<Event> deque;
    
    /**
     * @param deque
     */
    public WriterTask(Deque<Event> deque) {
        super();
        this.deque = deque;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("The thread %s has generated an event", Thread.currentThread().getId()));
            this.deque.addFirst(event);
            
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException intExc) {
                intExc.printStackTrace();
            }
        }
    }

}
