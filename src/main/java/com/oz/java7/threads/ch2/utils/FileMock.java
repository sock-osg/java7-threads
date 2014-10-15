/*
 * FileMock.java
 */
package com.oz.java7.threads.ch2.utils;

/**
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 14, 2014, 4:45:06 PM
 */
public class FileMock {

    private String[] content;
    private int index;

    /**
     * @param content
     * @param index
     */
    public FileMock(int size, int length) {
        super();
        this.content = new String[size];
        for (int i = 0; i < this.content.length; i++) {
            StringBuilder buffer = new StringBuilder(length);

            for (int j = 0; j < length; j++) {
                int indice = (int) Math.random() * 255;
                buffer.append((char) indice);
            }
            this.content[i] = buffer.toString();
        }
        this.index = 0;
    }

    public boolean hasMoreLines() {
        return this.index < this.content.length;
    }

    public String getLine() {
        if (this.hasMoreLines()) {
            System.out.println("Mock: " + (this.content.length - this.index));
            return this.content[this.index++];
        }
        return null;
    }

}
