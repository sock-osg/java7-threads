/*
 * Event.java
 */
package com.oz.java7.threads.ch1.utils;

import java.util.Date;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 1, 2014, 1:19:19 PM
 */
public class Event {

    private Date date;
    private String event;

    /**
     * 
     */
    public Event() {
        super();
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the event
     */
    public String getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(String event) {
        this.event = event;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Event [date=").append(date).append(", event=").append(event).append("]");
        return builder.toString();
    }

}
