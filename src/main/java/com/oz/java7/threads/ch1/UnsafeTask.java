/*
 * UnsafeTask.java
 */
package com.oz.java7.threads.ch1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.oz.java7.threads.UnsafeThread;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 4:29:27 PM
 */
@UnsafeThread
public class UnsafeTask implements Runnable {
    
    private Date startDate;

    @Override
    public void run() {
        this.startDate = new Date();
        System.out.printf("Statring Thread: %s : %s\n", Thread.currentThread().getId(), this.startDate);
        
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), this.startDate);
    }

}
