/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gumtree.erkin;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * AddressBook keeps a list of people in the.
 * @author erkin
 */
public class AddressBook {

    private Map<String, Person> people = new HashMap<>();   
    
    /**
     * It creates the Address book from a address book file. File should be formatted correctly. File format should be:
     * name, Gender(Male or female), Date of birth (dd/MM/yy)
     * 
     * @param scanner
     * @return 
     */
    public static AddressBook createFromScanner(Scanner scanner) {
        AddressBook addressBook = new AddressBook();
        scanner.useDelimiter("\r\n");
        while (scanner.hasNext()) {
            Person p = Person.createFromAddressBookLine(scanner.next());
            addressBook.people.put(p.getName(), p);
        }
        scanner.close();
        return addressBook;
    }
    
    
    /**
     * It creates the Address book from a url
     * 
     * @param urllocation Location of the address book file
     * @return Addressbook 
     * @throws IOException  IOException is thrown if the url location doesn't exist or unreachable.
     */
    public static AddressBook createFromUrl(String url) throws IOException {        
        return createFromScanner(new Scanner( new URL(url).openStream()));

    }

    /**
     * Returns the people in address book 
     * @return  Map of people 
     */
    public Map<String, Person> getPeople() {
        // This could return Collections.unmodifiableMap(map); to prevent clients to modify the address book
        return people;
    }
    
    
    
}
