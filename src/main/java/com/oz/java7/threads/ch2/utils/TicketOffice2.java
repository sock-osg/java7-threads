/*
 * TicketOffice2.java
 */
package com.oz.java7.threads.ch2.utils;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 6, 2014, 4:31:14 PM
 */
public class TicketOffice2 implements Runnable {
    
    private Cinema cinema;
    
    /**
     * @param cinema
     */
    public TicketOffice2(Cinema cinema) {
        super();
        this.cinema = cinema;
    }

    /* (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run() {
        this.cinema.sellTickets2(2);
        this.cinema.sellTickets2(4);
        this.cinema.sellTickets1(2);
        this.cinema.sellTickets1(1);
        this.cinema.returnTickets2(2);
        this.cinema.sellTickets1(3);
        this.cinema.sellTickets2(2);
        this.cinema.sellTickets1(2);
    }

}
