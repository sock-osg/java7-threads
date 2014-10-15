/*
 * PrintQueue.java
 */
package com.oz.java7.threads.ch3.utils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 15, 2014, 11:32:37 AM
 */
public class PrintQueueTwo {

    /** Number of printers availables to print. */
    private boolean[] freePrinters;

    private final Semaphore semaphore;
    private Lock lockPrinters;

    /**
     * @param semaphore
     */
    public PrintQueueTwo() {
        super();
        // 3 threads can use the secure block at same time
        this.semaphore = new Semaphore(3);
        // 3 printers availables
        this.freePrinters = new boolean[] { true, true, true };
        this.lockPrinters = new ReentrantLock();
    }

    public void printJob(Object document) {
        try {
            /*
             * The acquire(), acquireUninterruptibly(), tryAcquire(), and release()
             * methods have an additional version which has an int parameter. This parameter represents
             * the number of permits that the thread that uses them wants to acquire or release, so as to
             * say, the number of units that this thread wants to delete or to add to the internal counter
             * of the semaphore. In the case of the acquire(), acquireUninterruptibly(), and
             * tryAcquire() methods, if the value of this counter is less than this value, the thread will be
             * blocked until the counter gets this value or a greater one.
             */
            this.semaphore.acquire();

            int assignedPrinter = this.gewtPrinter();

            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Printing a Job in printer '%d' during %d seconds\n", Thread.currentThread()
                    .getName(), assignedPrinter, duration);
            TimeUnit.SECONDS.sleep(duration);

            this.freePrinters[assignedPrinter] = true;
        } catch (InterruptedException intExc) {
            intExc.printStackTrace();
        } finally {
            this.semaphore.release();
        }
    }

    public int gewtPrinter() {
        int ret = -1;

        try {
            this.lockPrinters.lock();

            for (int i = 0; i < this.freePrinters.length; i++) {
                if (this.freePrinters[i]) {
                    ret = i;
                    this.freePrinters[i] = false;
                    break;
                }
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            this.lockPrinters.unlock();
        }

        return ret;
    }

}
