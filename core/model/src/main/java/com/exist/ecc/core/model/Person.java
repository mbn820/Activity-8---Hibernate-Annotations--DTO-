package com.exist.ecc.core.model;

import java.util.Set;
import java.util.HashSet;
import java.util.Date;

public class Person {
    private int personId;
    private Name name;
    private Address address;
    private Date birthDate;
    private Date dateHired;
    private boolean currentlyEmployed;
    private double gwa;

    public Person() {

    }

    public Person(Name name, Address address, Date birthDate, Date dateHired, boolean currentlyEmployed, double gwa) {
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.currentlyEmployed = currentlyEmployed;
        this.gwa = gwa;
    }

    // getters
    public int getPersonId() { return personId; }
    public Name getName() { return name; }
    public Address getAddress() { return address; }
    public Date getBirthDate() { return birthDate; }
    public Date getDateHired() { return dateHired; }
    public boolean getCurrentlyEmployed() { return currentlyEmployed; }
    public double getGwa() { return gwa; }


    // setters
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public void setCurrentlyEmployed(boolean currentlyEmployed) {
        this.currentlyEmployed = currentlyEmployed;
    }

    public void setGwa(double gwa) {
        this.gwa = gwa;
    }

    public String toString() {
        return "Person: " + name.toString();
    }
}
