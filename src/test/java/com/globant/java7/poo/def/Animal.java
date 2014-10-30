/*
 * Animal.java
 */
package com.globant.java7.poo.def;

public class Animal {
    
    public enum GenderType {
        MALE, FEMALE,
    }

    protected String name;
    private GenderType gender;
    static final int VERSION = 100;

    public Animal() {
        super();
    }

    public void speak() {
        System.out.printf("Generic Hi");
    }

    public GenderType getGender() {
        return this.gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }
    
}
