package com.exist.ecc.core.model;

public class Address {
    private int streetNumber;
    private String barangay;
    private String municipality;
    private String zipcode;

    public Address(int streetNumber, String barangay, String municipality, String zipcode) {
        this.streetNumber = streetNumber;
        this.barangay = barangay;
        this.municipality = municipality;
        this.zipcode = zipcode;
    }

    // getters
    public int getStreetNumber() { return streetNumber; }
    public String getBarangay() { return barangay; }
    public String municipality() { return municipality; }
    public String zipcode() { return zipcode; }

    // setters
    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String toString() {
        return String.format("no. %d, brgy. %s, %s, zipcode: %s", streetNumber, barangay, municipality, zipcode);
    }
}
