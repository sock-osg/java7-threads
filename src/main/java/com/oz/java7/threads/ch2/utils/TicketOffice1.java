/*
 * TicketOffice1.java
 */
package com.oz.java7.threads.ch2.utils;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 6, 2014, 4:27:38 PM
 */
public class TicketOffice1 implements Runnable {
    
    private Cinema cinema;
    
    /**
     * @param cinema
     */
    public TicketOffice1(Cinema cinema) {
        super();
        this.cinema = cinema;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        this.cinema.sellTickets1(3);
        this.cinema.sellTickets1(2);
        this.cinema.sellTickets2(2);
        this.cinema.returnTickets1(3);
        this.cinema.sellTickets1(5);
        this.cinema.sellTickets2(2);
        this.cinema.sellTickets2(2);
        this.cinema.sellTickets2(2);
    }

}
