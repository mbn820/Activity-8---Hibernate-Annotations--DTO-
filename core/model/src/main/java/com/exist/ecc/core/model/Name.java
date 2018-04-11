package com.exist.ecc.core.model;

public class Name {
    private String firstName;
    private String lastName;
    private String middleName;

    public Name() {

    }

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    // getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getMiddleName() { return middleName; }

    //setters
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String toString() {
        return String.format("%s %c. %s", firstName, middleName.charAt(0), lastName);
    }
}
