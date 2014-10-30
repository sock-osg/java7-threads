/*
 * Animal.java
 */
package com.globant.java7.poo.def;

public abstract class AbstractAnimal {
    
    public enum GenderType {
        MALE, FEMALE,
    }

    protected String name;
    private GenderType gender;
    static final int VERSION = 100;

    public abstract void speak();

    public GenderType getGender() {
        return this.gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }
    
}
