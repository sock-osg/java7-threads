/*
 * Participant.java
 */
package com.oz.java7.threads.ch3.utils;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 15, 2014, 1:16:18 PM
 */
public class Participant implements Runnable {

    private Videoconference conference;
    private String name;

    /**
     * @param conference
     * @param name
     */
    public Participant(Videoconference conference, String name) {
        super();
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        long duration = (long) (Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        this.conference.arrive(this.name);
    }

}
