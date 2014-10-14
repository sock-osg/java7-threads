/*
 * 
 */
package com.oz.java7.threads.ch2.utils;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 9, 2014, 9:43:01 PM
 */
public class Consumer implements Runnable {
	
	private EventStorage storage;

	/**
	 * @param storage
	 */
	public Consumer(EventStorage storage) {
		super();
		this.storage = storage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			this.storage.get();
		}
	}
}
