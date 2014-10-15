/*
 * MainRecipe07.java
 */
package com.oz.java7.threads.ch2.main;

import com.oz.java7.threads.ch2.utils.Buffer;
import com.oz.java7.threads.ch2.utils.ConsumerTwo;
import com.oz.java7.threads.ch2.utils.FileMock;
import com.oz.java7.threads.ch2.utils.ProducerTwo;

/**
 * Using multiple conditions in a Lock.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 15, 2014, 11:02:56 AM
 */
public class MainRecipe07 {
    
    public static void main(String[] args) {
        FileMock mock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);
        
        ProducerTwo producer = new ProducerTwo(mock, buffer);
        Thread threadProducer = new Thread(producer);
        
        ConsumerTwo[] consumers = new ConsumerTwo[3];
        Thread[] threadConsumers = new Thread[consumers.length];
        
        for (int i = 0; i < threadConsumers.length; i++) {
            consumers[i] = new ConsumerTwo(buffer);
            threadConsumers[i] = new Thread(consumers[i], "Thread-Consumer " + i);
        }
        
        threadProducer.start();
        
        for (Thread thread : threadConsumers) {
            thread.start();
        }
    }

}
