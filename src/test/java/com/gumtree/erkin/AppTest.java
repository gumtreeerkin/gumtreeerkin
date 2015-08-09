package com.gumtree.erkin;

import java.io.IOException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests Application by a test address book
 * @author erkin
 */
public class AppTest     {
   
    static App app; 
    
    @BeforeClass
    public static void setup() throws IOException {
        app = new App(AddressBookTest.createTestAddresBook());
    }
    
    
    @Test
    public void testMaleCount() {
        Assert.assertEquals(3, app.maleCount());
        
    }
    
    @Test
    public void testOldestPerson() {
        Assert.assertEquals("Wes Jackson", app.oldestPerson().getName());
        
    }
    
    @Test
    public void ageDifference() {
        Assert.assertEquals(2862, app.ageDifferenceBillAndPaul());
        
    }    
}
