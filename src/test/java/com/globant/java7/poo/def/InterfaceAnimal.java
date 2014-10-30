/*
 * IntAnimal.java
 */
package com.globant.java7.poo.def;

public interface InterfaceAnimal {
    
    enum GenderType {
        MALE, FEMALE,
    }
    
    int VERSION = 0;

    void speak();

    GenderType getGender();

    void setGender(GenderType gender);

}
