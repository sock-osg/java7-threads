/*
 * Bank.java
 */
package com.oz.java7.threads.ch2.utils;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 6, 2014, 3:25:36 PM
 */
public class Bank implements Runnable {
    
    private Account account;
    
    /**
     * @param account
     */
    public Bank(Account account) {
        super();
        this.account = account;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.account.substractAmount(1000);
        }
    }

}
