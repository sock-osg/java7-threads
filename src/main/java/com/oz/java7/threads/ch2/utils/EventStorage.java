/*
 * 
 */
package com.oz.java7.threads.ch2.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 9, 2014, 9:30:42 PM
 */
public class EventStorage {

	private int maxSize;
	private List<Date> storage;

	/**
	 * @param maxSize
	 * @param storage
	 */
	public EventStorage() {
		super();
		this.maxSize = 10;
		this.storage = new LinkedList<>();
	}

	public synchronized void set() {
		while (this.storage.size() == this.maxSize) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		this.storage.add(new Date());
		System.out.printf("Set: %d\n", this.storage.size());
		this.notifyAll();
	}

	public synchronized void get() {
		while (this.storage.isEmpty()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.printf("Get: %d: %s\n", storage.size(), ((LinkedList<?>) this.storage).poll());
		this.notifyAll();
	}

}
