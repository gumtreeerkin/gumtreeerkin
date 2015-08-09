/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gumtree.erkin;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Person class 
 * 
 * 
 * @author erkin
 */
public class Person {
 
    private String name;
    private Gender gender;
    private Date birthday;
    private final static DateFormat format = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);

    public Person(String name, Gender gender, Date birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }
    
    
    
    
    /**
     * It creates a person object from a well formatted address book line.
     * Line should be in this format    
     * name, Gender(Male or female), Date of birth (dd/MM/yy)
     * 
     * @param line well formatted address book line 
     * @return  Person object
     * @throws Illegal argument exception is thrown 
     *  if the line is null 
     *  if the line doesn't contain name,gender and birthday seperated by commas
     *  if the birthdays is not in dd/MM/yy format
     *  if the gender is not either Male or Female
     */
    static Person createFromAddressBookLine(String line) {
        if (line == null) {
            throw new IllegalArgumentException("Line can not be null");
        }        
        String[] details = line.split(",");
        if (details.length != 3) {
            throw new IllegalArgumentException("Line should contain the person name,gender and the birthday. line was=" + line);
        }
        try {
            return  new Person(details[0].trim(), 
                Gender.valueOf(details[1].trim()),
                format.parse(details[2].trim()));
        } catch (ParseException ex) {
             throw new IllegalArgumentException("person's date must be in dd/mm/yy format. such as 16/03/77. line was=" + line);
        }
        
       
        
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 37 * hash + (this.gender != null ? this.gender.hashCode() : 0);
        hash = 37 * hash + (this.birthday != null ? this.birthday.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        if (this.birthday != other.birthday && (this.birthday == null || !this.birthday.equals(other.birthday))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", gender=" + gender + ", birthday=" + birthday + '}';
    }
    
    
    
    
}
