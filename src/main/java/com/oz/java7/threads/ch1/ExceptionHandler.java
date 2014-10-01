package com.oz.java7.threads.ch1;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 2:37:49 PM
 */
public class ExceptionHandler implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread thread, Throwable exc) {
        System.out.printf("An exception has been captured\n");
        System.out.printf("Thread: %s\n",thread.getId());
        System.out.printf("Exception: %s: %s\n",exc.getClass().
        getName(), exc.getMessage());
        System.out.printf("Stack Trace: \n");
        exc.printStackTrace(System.out);
        System.out.printf("Thread status: %s\n",thread.getState());
    }

}
