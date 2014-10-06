/*
 * CleanerTask.java
 */
package com.oz.java7.threads.ch1.utils;

import java.util.Date;
import java.util.Deque;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 1:25:18 PM
 */
public class CleanerTask extends Thread {

    private Deque<Event> deque;

    /**
     * @param deque
     */
    public CleanerTask(Deque<Event> deque) {
        super();
        // mark this Thread as a daemon thread
        this.deque = deque;
        this.setDaemon(true);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            this.clean(date);
        }
    }

    /**
     * 
     * @param date
     */
    private void clean(Date date) {
        long difference;
        boolean delete;

        if (this.deque.isEmpty()) {
            return;
        }

        delete = false;

        do {
            Event event = this.deque.getLast();
            difference = date.getTime() - event.getDate().getTime();

            if (difference > 10000) {
                System.out.printf("Cleaner: %s\n", event.getEvent());
                this.deque.removeLast();
                delete = true;
            }
        } while (difference > 10000);

        if (delete) {
            System.out.printf("Cleaner: Size of the queue %d\n", this.deque.size());
        }
    }

}
