/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gumtree.erkin;

import java.io.IOException;
import java.util.Scanner;
import org.junit.Assert;

import org.junit.Test;

/**
 *
 * @author erkin
 */
public class AddressBookTest {


    /**
     * Tests creating an address book from a scanner
     *
     * @throws IOException
     */
    @Test
    public void testCreateAddressBookByScanner() throws IOException {

        Assert.assertEquals(5, AddressBookTest.createTestAddresBook().getPeople().size());
    }
    
    public static AddressBook createTestAddresBook() {
        Scanner scanner = new Scanner("Bill McKnight, Male, 16/03/77\r\n"
                + "Paul Robinson, Male, 15/01/85\r\n"
                + "Gemma Lane, Female, 20/11/91\r\n"
                + "Sarah Stone, Female, 20/09/80\r\n"
                + "Wes Jackson, Male, 14/08/74"
                + "");

        return AddressBook.createFromScanner(scanner);        
    }    
}
