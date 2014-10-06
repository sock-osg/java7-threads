/*
 * MainRecipe01.java
 */
package com.oz.java7.threads.ch2.main;

import com.oz.java7.threads.ch2.utils.Account;
import com.oz.java7.threads.ch2.utils.Bank;
import com.oz.java7.threads.ch2.utils.Company;

/**
 * Synchronizing a method.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 6, 2014, 3:31:59 PM
 */
public class MainRecipe01 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);
        
        Company company = new Company(account);
        Thread companyThread = new Thread(company);
        
        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);
        
        System.out.printf("Account : Initial Balance: %f\n", account.getBalance());
        System.out.printf("Starting threads\n");
        companyThread.start();
        bankThread.start();
        
        // Waiting for the finalization of two threads
        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Account : Final Balance: %f\n", account.getBalance());
        } catch (InterruptedException intExc) {
            intExc.printStackTrace();
        }
    }

}
