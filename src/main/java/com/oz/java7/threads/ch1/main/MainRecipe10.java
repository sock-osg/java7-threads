/*
 * 
 */
package com.oz.java7.threads.ch1.main;

import java.util.concurrent.TimeUnit;

import com.oz.java7.threads.ch1.utils.Result;
import com.oz.java7.threads.ch1.utils.SearchTask;

/**
 * Grouping threads into a group.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 2, 2014, 2:17:39 PM
 */
public class MainRecipe10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("Searcher");
		Result result = new Result();
		
		SearchTask searchTask = new SearchTask(result);
		
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(threadGroup, searchTask);
			thread.start();
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        threadGroup.list();
        
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        
        System.out.printf("Printing states of threads \n");
        for (int i = 0; i < threads.length; i++) {
        	System.out.printf("In main Thread %s: %s\n", threads[i].getName(), threads[i].getState());
		}
        
        waitFinish(threadGroup);
        threadGroup.interrupt();
	}

	private static void waitFinish(ThreadGroup threadGroup) {
		while (threadGroup.activeCount() > 9) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
