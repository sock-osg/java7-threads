/*
 * Account.java
 */
package com.oz.java7.threads.ch2.utils;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 6, 2014, 2:26:29 PM
 */
public class Account {

    private double balance;

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public synchronized void addAmount(double amount) {
        double tmp = this.balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException intExc) {
            intExc.printStackTrace();
        }
        
        tmp += amount;
        this.balance = tmp;
    }
    
    public synchronized void substractAmount(double amount) {
        double tmp = this.balance;
        try {
            Thread.sleep(10);
        } catch (InterruptedException intExc) {
            intExc.printStackTrace();
        }
        
        tmp -= amount;
        this.balance = tmp;
    }
    
}
