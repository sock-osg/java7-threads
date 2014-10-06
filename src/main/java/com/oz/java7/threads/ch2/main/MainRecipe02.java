/*
 * MainRecipe02.java
 */
package com.oz.java7.threads.ch2.main;

import com.oz.java7.threads.ch2.utils.Cinema;
import com.oz.java7.threads.ch2.utils.TicketOffice1;
import com.oz.java7.threads.ch2.utils.TicketOffice2;

/**
 * Arranging independent attributes in synchronized classes.
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 6, 2014, 4:34:45 PM
 */
public class MainRecipe02 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Cinema cinema = new Cinema();

        TicketOffice1 ticketOffice1 = new TicketOffice1(cinema);
        Thread thread1 = new Thread(ticketOffice1);

        TicketOffice2 ricketOffice2 = new TicketOffice2(cinema);
        Thread thread2 = new Thread(ricketOffice2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacanciesCinema1());
        System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacanciesCinema2());
    }

}
