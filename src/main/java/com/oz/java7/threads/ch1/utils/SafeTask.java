/**
 * 
 */
package com.oz.java7.threads.ch1.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Samuel Quintana
 *
 */
public class SafeTask implements Runnable {
	
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>() {
		
		protected Date initialValue() {
			return new Date();
		}
		
	};
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.printf("Statring Thread: %s : %s\n", Thread.currentThread().getId(), startDate.get());
        
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException intExc) {
            intExc.printStackTrace();
        }
        
        System.out.printf("Thread Finished: %s : %s\n", Thread.currentThread().getId(), startDate.get());
	}

}
