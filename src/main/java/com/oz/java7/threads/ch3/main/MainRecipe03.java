/*
 * MainRecipe03.java
 */
package com.oz.java7.threads.ch3.main;

import com.oz.java7.threads.ch3.utils.Participant;
import com.oz.java7.threads.ch3.utils.Videoconference;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 15, 2014, 1:18:55 PM
 */
public class MainRecipe03 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Videoconference conference = new Videoconference(10);
        Thread threadConference = new Thread(conference);
        threadConference.start();

        for (int i = 0; i < 10; i++) {
            Participant participant = new Participant(conference, "Participant " + i);
            Thread thread = new Thread(participant);
            thread.start();
        }
    }

}
