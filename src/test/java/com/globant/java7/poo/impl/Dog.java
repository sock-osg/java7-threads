/*
 * Dog.java
 */
package com.globant.java7.poo.impl;

import com.globant.java7.poo.def.Animal;

public class Dog extends Animal {

    @Override
    public void speak() {
        System.out.printf("Hi, i'm a dog xD");
//        System.out.printf("Version : %n", VERSION); // Error, el scope de VERSION es el de clase/paquete
    }

}
