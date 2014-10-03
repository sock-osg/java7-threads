/*
 * 
 */
package com.oz.java7.threads.ch1;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 2, 2014, 2:06:34 PM
 */
public class SearchTask implements Runnable {
	
	private Result result;
	
	/**
	 * @param result
	 */
	public SearchTask(Result result) {
		super();
		this.result = result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		final String name = Thread.currentThread().getName();
		System.out.printf("Thread %s Start\n", name);
		
		try {
			doTask();
			result.setName(name);
		} catch (InterruptedException intExc) {
			System.out.printf("Thread %s: Interrupted\n",name);
			return;
		}
		
		System.out.printf("Thread %s: End\n", name);
	}

	private void doTask() throws InterruptedException {
		Random random = new Random((new Date()).getTime());
		int value = (int) (random.nextDouble() * 100);
		System.out.printf("In Thread %s: waiting for %d seconds\n", Thread.currentThread().getName(), value);
		TimeUnit.SECONDS.sleep(value);
	}

}
