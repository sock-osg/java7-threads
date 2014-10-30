/*
 * DogAbstractImpl.java
 */
package com.globant.java7.poo.impl;

import com.globant.java7.poo.def.AbstractAnimal;

public class DogAbstractImpl extends AbstractAnimal {

    @Override
    public void speak() {
        System.out.printf("Hi, i'm a dog xD");
//      System.out.printf("Version : %n", VERSION); // Error, el scope de VERSION es el de clase/paquete
    }

}
