/*
 * Company.java
 */
package com.oz.java7.threads.ch2.utils;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 6, 2014, 3:27:09 PM
 */
public class Company implements Runnable {
    
    public Account account;

    /**
     * @param account
     */
    public Company(Account account) {
        super();
        this.account = account;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.addAmount(1000);
        }
    }

}
