package com.exist.ecc.core.model;

import java.util.Set;
import java.util.HashSet;
import java.util.Date;

public class Person {
    private int id;
    private Name name;
    private String firstName;
    private String lastName;
    private Address address;
    private Date birthDate;
    private Date dateHired;
    private double gwa;
    private boolean currentlyEmployed;
    // private Set<ContactInfo> contactInfos = new HashSet<ContacInfo>(); // -> change to map?
    // private Set<Role> roles = new HashSet<Role>();

    // public Person(Name name) {
    //     this.name = name;
    // }

    public Person() {}

    // getters
    public int getId() { return id; }
    public Name getName() { return name; }
    public Address getAddress() { return address; }
    public Date getBirthDate() { return birthDate; }
    public Date getDateHired() { return dateHired; }
    public double getGwa() { return gwa; }
    public boolean getEmploymentStatus() { return currentlyEmployed; }
    // public Set<ContacInfo> getContactInfos() { return contactInfos; }
    // public Set<Role> getRoles() { return roles; }

    // setters
    public void setFirst(String first) {
        firstName = first;
    }

    public void setLast(String last) {
        lastName = last;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setGwa(double gwa) {
        this.gwa = gwa;
    }

    public void setEmploymentStatus(boolean currentlyEmployed) {
        this.currentlyEmployed = currentlyEmployed;
    }

    // public void addContactInfo(ContactInfo contactInfo) {
    //       contactInfos.add(contactInfo);
    // }

    // public void addRole(Role role) {
    //       roles.add(role);
    // }

    public String toString() {
        return "Person: " + name.toString();
    }
}
