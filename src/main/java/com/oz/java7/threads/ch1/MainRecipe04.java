/*
 * MainRecipe04.java
 */
package com.oz.java7.threads.ch1;

import java.util.concurrent.TimeUnit;

/**
 * Controlling the interruption of a thread.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Sep 30, 2014, 5:41:55 PM
 */
public class MainRecipe04 {

    public static void main(String[] args) {
        FileSearch searcher = new FileSearch("/home", "Win7.vdi");
        Thread thread = new Thread(searcher);

        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException intExc) {
            intExc.printStackTrace();
        }

        thread.interrupt();
    }

}
