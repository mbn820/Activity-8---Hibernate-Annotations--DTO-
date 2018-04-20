package com.exist.ecc.core.service;

import com.exist.ecc.core.model.*;
import java.util.*;

public class PersonDto {

    private int id;
    private Name name;
    private Address address;
    private Date birthDate;
    private Date dateHired;
    private boolean currentlyEmployed;
    private double gwa;
    private Set<Role> roles;
    private Set<Contact> contacts;

    public PersonDto() {}
    public PersonDto(Name name, Address address, Date birthDate, Date dateHired,
                  boolean currentlyEmployed, double gwa, Set<Role> roles, Set<Contact> contacts) {

        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.dateHired = dateHired;
        this.currentlyEmployed = currentlyEmployed;
        this.gwa = gwa;
        this.roles = roles;
        this.contacts = contacts;
    }

    // getters
    public int getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public boolean getCurrentlyEmployed() {
        return currentlyEmployed;
    }

    public double getGwa() {
        return gwa;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    // setters
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

    public void setCurrentlyEmployed(boolean currentlyEmployed) {
        this.currentlyEmployed = currentlyEmployed;
    }

    public void setGwa(double gwa) {
        this.gwa = gwa;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

	public void addRole(Role role) {
        if(roles == null) {
            roles = new HashSet<Role>();
        }
        roles.add(role);
        role.addPerson( new MapperUtil().mapToPerson(this) );
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.removePerson( new MapperUtil().mapToPerson(this) );
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public String toString() {
        return "Person: " + name.toString();
    }
}
