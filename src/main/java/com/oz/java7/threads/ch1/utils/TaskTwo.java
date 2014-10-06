/*
 * 
 */
package com.oz.java7.threads.ch1.utils;

import java.util.Random;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 2, 2014, 8:35:49 PM
 */
public class TaskTwo implements Runnable {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		int result;
		Random random = new Random(Thread.currentThread().getId());
		while (true) {
			result = 1000 / ((int) (random.nextDouble() * 1000));
			System.out.printf("%s : %f\n", Thread.currentThread().getId(), result);
			if (Thread.currentThread().isInterrupted()) {
				System.out.printf("%d : Interrupted\n", Thread.currentThread().getId());
				return;
			}
		}
	}

}
