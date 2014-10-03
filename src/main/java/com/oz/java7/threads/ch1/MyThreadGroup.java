/*
 * 
 */
package com.oz.java7.threads.ch1;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 2, 2014, 8:26:02 PM
 */
public class MyThreadGroup extends ThreadGroup {

	public MyThreadGroup(String name) {
		super(name);
	}

	@Override
	public void uncaughtException(Thread thread, Throwable throwable) {
		System.out.printf("The thread %s has throw an exception\n", thread.getId());
		throwable.printStackTrace();
		System.out.printf("Terminating the rest of the threads\n");
		interrupt();
	}

}
