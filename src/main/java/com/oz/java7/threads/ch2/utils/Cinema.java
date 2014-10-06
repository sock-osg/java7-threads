/*
 * Cinema.java
 */
package com.oz.java7.threads.ch2.utils;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 6, 2014, 4:18:04 PM
 */
public class Cinema {

    private long vacanciesCinema1;
    private long vacanciesCinema2;

    private Object controlCinema1;
    private Object controlCinema2;

    /**
     */
    public Cinema() {
        super();
        this.vacanciesCinema1 = 20;
        this.vacanciesCinema2 = 20;
        this.controlCinema1 = new Object();
        this.controlCinema2 = new Object();
    }

    public boolean sellTickets1(int number) {
        synchronized (this.controlCinema1) {
            if (number < this.vacanciesCinema1) {
                this.vacanciesCinema1 -= number;
                return true;
            } else {
                return false;
            }
        }
    }
    
    public boolean sellTickets2(int number) {
        synchronized (this.controlCinema2) {
            if (number < this.vacanciesCinema2) {
                this.vacanciesCinema2 -= number;
                return true;
            } else {
                return false;
            }
        }
    }
    
    public boolean returnTickets1(int number) {
        synchronized (this.controlCinema1) {
            this.vacanciesCinema1 += number;
            return true;
        }
    }
    
    public boolean returnTickets2(int number) {
        synchronized (this.controlCinema2) {
            this.vacanciesCinema2 += number;
            return true;
        }
    }

    /**
     * @return the vacanciesCinema1
     */
    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    /**
     * @return the vacanciesCinema2
     */
    public long getVacanciesCinema2() {
        return vacanciesCinema2;
    }

}
