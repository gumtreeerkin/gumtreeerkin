package com.gumtree.erkin;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * Main application.  It answers the questions asked in the coding challenge
 *
 */
public class App {

    final AddressBook addressBook;

    public App(AddressBook addressBook) throws IOException {        
        this.addressBook = addressBook;
    }
    public App(String url) throws IOException {
        this.addressBook = AddressBook.createFromUrl("https://raw.githubusercontent.com/gumtreeuk/address-book/master/AddressBook");
    }
    
    /**
     * 
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {
        App app = new App("https://raw.githubusercontent.com/gumtreeuk/address-book/master/AddressBook");
        System.out.println("How many males are in the address book?. The answer is=" + app.maleCount());
        System.out.println("Who is the oldest person in the address book?. The answer is=" + app.oldestPerson());
        System.out.println("How many days older is Bill than Paul?. The answer is=" + app.ageDifferenceBillAndPaul());


    }

    /**
     * Find and returns the oldest person in the address book
     * @return 
     */
    public Person oldestPerson() {
        Person oldestPerson = null;
        for (Map.Entry<String, Person> entry : addressBook.getPeople().entrySet()) {
            if (oldestPerson == null || entry.getValue().getBirthday().before(oldestPerson.getBirthday())) {
                oldestPerson = entry.getValue();

            }
        }
        return oldestPerson;
    }

    /**
     * It returns the male count in the address book
     * @return 
     */
    public int maleCount() {
        int maleCount = 0;
        for (Map.Entry<String, Person> entry : addressBook.getPeople().entrySet()) {
            if (entry.getValue().getGender().equals(Gender.Male)) {
                maleCount++;
            }
        }
        return maleCount;
    }

    /**
     * It calculates days difference between Bill's and Paul's birthdays.
     * It uses jodatime library to find the days between 2 date values
     * @return 
     */
    public int ageDifferenceBillAndPaul() {
        // this could be more dynamic and get 2 nane arguments. But for now it just simply answer the question. 
        Date billBirthDay = addressBook.getPeople().get("Bill McKnight").getBirthday();
        Date paulBirthDay = addressBook.getPeople().get("Paul Robinson").getBirthday();
        return Days.daysBetween(new DateTime(billBirthDay), new DateTime(paulBirthDay)).getDays();
    }
}
