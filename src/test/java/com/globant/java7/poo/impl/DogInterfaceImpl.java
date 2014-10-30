/*
 * DogInterfaceImpl.java
 */
package com.globant.java7.poo.impl;

import com.globant.java7.poo.def.InterfaceAnimal;

public class DogInterfaceImpl implements InterfaceAnimal {
    
    protected String name;
    private GenderType gender;
    static final int VERSION = 100;

    @Override
    public void speak() {
        System.out.printf("Hi, i'm a dog xD");
    }

    @Override
    public GenderType getGender() {
        return this.gender;
    }

    @Override
    public void setGender(GenderType gender) {
        this.gender = gender;
    }

}
