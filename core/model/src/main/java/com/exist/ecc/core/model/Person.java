package com.exist.ecc.core.model;

import java.util.Set;
import java.util.HashSet;
import java.util.Date;

public class Person {
    private int id;
    private Name name;
    private Address address;

    public Person() {

    }

    public Person(Name name, Address address) {
        this.name = name;
        this.address = address;
    }

    // getters
    public int getId() { return id; }
    public Name getName() { return name; }
    public Address getAddress() { return address; }


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

    public String toString() {
        return "Person: " + name.toString();
    }
}
