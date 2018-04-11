package com.exist.ecc.app;

import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Name;
import com.exist.ecc.core.model.Address;
import com.exist.ecc.core.dao.PersonDao;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;

public class AddPersonForm {
    private Person person;

    private Name name;
    private Address address;
    private Date birthDate;
    private Date dateHired;
    private boolean currentlyEmployed;
    private double gwa;

    private PersonDao personDao;

    public AddPersonForm(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void show() {
        getNameDetailsFromUser(); // -> retrieveNameDetails
        getAddressDetailsFromUser();
        getBirthDateFromUser();
        getEmploymentStatus();
        getGwa();

        saveOrCancel();
        // letUserReviewInput();
    }

    public void getNameDetailsFromUser() {
        System.out.println("(NAME DETAILS)");

        String firstName = ConsoleInputUtil.getAnyString("\tFirst name: ");
        String middleName = ConsoleInputUtil.getAnyString("\tMiddle name: ");
        String lastName = ConsoleInputUtil.getAnyString("\tLast name: ");

        name = new Name(firstName, middleName, lastName);
    }

    public void getAddressDetailsFromUser() {
        System.out.println("(ADDRESS DETAILS)");

        int streetNumber = ConsoleInputUtil.getAnyInteger("\tStreet Number: ");
        String barangay = ConsoleInputUtil.getAnyString("\tBarangay: ");
        String municipality = ConsoleInputUtil.getAnyString("\tMunicipality: ");
        String zipcode = ConsoleInputUtil.getAnyString("\tZipcode: ");

        address = new Address(streetNumber, barangay, municipality, zipcode);
    }

    public void getBirthDateFromUser() {
        System.out.println("(BIRTH DATE)");

        int month = ConsoleInputUtil.getIntegerBetween("\tMonth: ", 1, 12);
        int day = ConsoleInputUtil.getIntegerBetween("\tDay:", 1, 30);
        int year = ConsoleInputUtil.getIntegerBetween("\tYear:", 1900, 2017);

        birthDate = new Date();
        birthDate = DateUtils.setMonths(birthDate, month - 1);
        birthDate = DateUtils.setDays(birthDate, day);
        birthDate = DateUtils.setYears(birthDate, year);
    }

    public void getEmploymentStatus() {
        System.out.println("(EMPLOYMENT STATUS)");

        String choice = ConsoleInputUtil.getDesiredString("\tCurrently Employed? [y/n]: ", "y", "n");

        currentlyEmployed = choice.equals("y") ? true : false;
    }

    public void getGwa() {
        System.out.println("(GWA)");

        gwa = ConsoleInputUtil.getDoubleBetween("\tEnter GWA: ", 1.0, 5.0);
    }

    // public void getContactInfosFromUser() {
    //     String phoneNumber = ConsoleInputUtil.getAnyString("Phone Number: ");
    //     String landLine = ConsoleInputUtil.getAnyString("Landline Number: ");
    //     String email = ConsoleInputUtil.getAnyString("Email address: ");
    // }

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

    public void saveOrCancel() {
        String decision = ConsoleInputUtil.getDesiredString("Save or Cancel? [s/c] : ", "s", "c");

        switch(decision) {
            case "s" : addPersonToDatabase();
                       break;
            case "c" : break;
        }
    }

    public Person buildCurrentPerson() {
        person = new Person();
        person.setName(this.name);
        person.setAddress(this.address);
        person.setBirthDate(this.birthDate);
        person.setCurrentlyEmployed(this.currentlyEmployed);
        person.setGwa(this.gwa);

        return person;
    }

    public void addPersonToDatabase() {
        buildCurrentPerson();
        personDao.addPerson(this.person);
    }


}
