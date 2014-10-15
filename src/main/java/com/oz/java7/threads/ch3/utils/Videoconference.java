/*
 * Videoconference.java
 */
package com.oz.java7.threads.ch3.utils;

import java.util.concurrent.CountDownLatch;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 15, 2014, 1:03:41 PM
 */
public class Videoconference implements Runnable {

    private final CountDownLatch controller;

    /**
     * @param controller
     */
    public Videoconference(int number) {
        super();
        /*
         * There's no way to re-initialize the internal counter of the CountDownLatch object or to modify
         * its value. Once the counter is initialized, the only method you can use to modify its value is
         * the countDown() method explained earlier. When the counter arrives to 0, all the calls to the
         * await() method return immediately and all subsequent calls to the countDown() method
         * have no effect.
         */
        this.controller = new CountDownLatch(number);
    }

    public void arrive(String name) {
        System.out.printf("%s has arrived.\n", name);
        this.controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", this.controller.getCount());
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n", this.controller.getCount());

        try {
            this.controller.await();
            System.out.printf("VideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
