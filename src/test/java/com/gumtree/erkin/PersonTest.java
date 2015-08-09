/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gumtree.erkin;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Assert;

import org.junit.Test;

/**
 * Tests Person class
 * @author erkin
 */
public class PersonTest {

    @Test
    public void createPerson() {
        Person expected = new Person("Paul Robinson", Gender.Male, new GregorianCalendar(1985, 0, 15).getTime());
        Assert.assertEquals(expected, Person.createFromAddressBookLine("Paul Robinson, Male, 15/01/85"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullLine() {
        Person.createFromAddressBookLine(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidLine() {
        Person.createFromAddressBookLine("Paul Robinson, Male");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidGender() {
        Person.createFromAddressBookLine("Paul Robinson, M, 15/01/85");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidDate() {
        Person.createFromAddressBookLine("Paul Robinson, M, 15/01/1985");
    }
}
