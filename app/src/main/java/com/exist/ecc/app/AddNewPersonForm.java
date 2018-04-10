package com.exist.ecc.app;

import com.exist.ecc.core.model.Name;
import com.exist.ecc.core.model.Address;
import java.util.Date;

public class AddNewPersonForm {
    private int id;
    private Name name;
    private Address address;
    private Date birthDate;
    private Date dateHired;
    private double gwa;
    private boolean currentlyEmployed;

    public void getAllDetails() {
        getNameDetailsFromUser();
        getAddressDetailsFromUser();
        getContactInfosFromUser();

        letUserReviewInput();
    }

    public void getNameDetailsFromUser() {
        String firstName = ConsoleInputUtil.getAnyString("First name: ");
        String middleName = ConsoleInputUtil.getAnyString("Middle name: ");
        String lastName = ConsoleInputUtil.getAnyString("Last name: ");

        name = new Name(firstName, middleName, lastName);
    }

    public void getAddressDetailsFromUser() {
        int streetNumber = ConsoleInputUtil.getAnyInteger("Street Number: ");
        String barangay = ConsoleInputUtil.getAnyString("Barangay: ");
        String municipality = ConsoleInputUtil.getAnyString("Municipality: ");
        String zipcode = ConsoleInputUtil.getAnyString("Zipcode: ");

        address = new Address(streetNumber, barangay, municipality, zipcode);
    }

    public void getContactInfosFromUser() {
        String phoneNumber = ConsoleInputUtil.getAnyString("Phone Number: ");
        String landLine = ConsoleInputUtil.getAnyString("Landline Number: ");
        String email = ConsoleInputUtil.getAnyString("Email address: ");

    }

    public void getRolesFromUser() {
        String role = ConsoleInputUtil.getAnyString("Enter role: ");
    }

    public void letUserReviewInput() {
        System.out.println("(Name Details)");
        System.out.println("First name: " + name.getFirstName());
        System.out.println("Middle name: " + name.getMiddleName());
        System.out.println("Last name: " + name.getLastName());

        System.out.println("(Address Details)");
        System.out.println(); // todo
    }


}
