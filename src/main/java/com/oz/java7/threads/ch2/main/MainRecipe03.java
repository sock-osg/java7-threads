/*
 * 
 */
package com.oz.java7.threads.ch2.main;

import com.oz.java7.threads.ch2.utils.Consumer;
import com.oz.java7.threads.ch2.utils.EventStorage;
import com.oz.java7.threads.ch2.utils.Producer;

/**
 * Using conditions in synchronized code
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 9, 2014, 9:44:28 PM
 */
public class MainRecipe03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EventStorage storage = new EventStorage();
		
		Producer producer = new Producer(storage);
		Thread threadProducer = new Thread(producer);
		
		Consumer consumer = new Consumer(storage);
		Thread threadConsumer = new Thread(consumer);
		
//		threadProducer.start();
		threadConsumer.start();
		threadProducer.start();
	}
	
}
