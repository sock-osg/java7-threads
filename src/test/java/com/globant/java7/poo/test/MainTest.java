/*
 * MainTest.java
 */
package com.globant.java7.poo.test;

import org.testng.annotations.Test;

import com.globant.java7.poo.def.AbstractAnimal;
import com.globant.java7.poo.impl.DogAbstractImpl;

/**
 * 
 * @author <a href="mailto:sock.sqt@gmail.com">Samuel Quintana</a>
 * @since Oct 30, 2014, 2:38:02 PM
 */
public class MainTest {
    
    @Test
    public void test() {
        AbstractAnimal animal = new DogAbstractImpl();
    }

}
