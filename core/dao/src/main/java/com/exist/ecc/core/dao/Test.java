package com.exist.ecc.core.dao;

import com.exist.ecc.core.model.*;
import org.apache.commons.lang3.time.DateUtils;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        PersonDao dao = new PersonDao();

        Name name = new Name("First", "Middle", "Last");
        Address address = new Address(12, "628", "Sta. Mesa", "7654");
        Date birthDate = new Date();
        birthDate = DateUtils.setDays(birthDate, 8);
        birthDate = DateUtils.setMonths(birthDate, 5);
        birthDate = DateUtils.setYears(birthDate, 1996);

        Date dateHired = new Date();
        birthDate = DateUtils.setDays(birthDate, 8);
        birthDate = DateUtils.setMonths(birthDate, 5);
        birthDate = DateUtils.setYears(birthDate, 1996);

        boolean currentlyEmployed = true;
        double gwa = 5.0;

        Set<Role> roles = new HashSet<Role>();
        roles.add(new Role("Mechanic"));
        roles.add(new Role("Medic"));
        roles.add(new Role("Mage"));

        ///////////////////////////////////////////////////

        Name name2 = new Name("First2", "Middle2", "Last2");
        Address address2 = new Address(12, "628", "Sta. Mesa", "7654");
        Date birthDate2 = new Date();
        birthDate2 = DateUtils.setDays(birthDate, 8);
        birthDate2 = DateUtils.setMonths(birthDate, 5);
        birthDate2 = DateUtils.setYears(birthDate, 1996);

        Date dateHired2 = new Date();
        dateHired2 = DateUtils.setDays(dateHired, 8);
        dateHired2 = DateUtils.setMonths(dateHired, 5);
        dateHired2 = DateUtils.setYears(dateHired, 1996);

        boolean currentlyEmployed2 = true;
        double gwa2 = 5.0;

        Set<Role> roles2 = new HashSet<Role>();
        roles.add(new Role("Warrior"));
        roles.add(new Role("Thief"));
        roles.add(new Role("Summoner"));

        Set<Contact> contacts = new HashSet<Contact>();
        contacts.add(new Contact("email", "email@sample.com"));
        contacts.add(new Contact("phone", "09063421021"));

        Set<Contact> contacts2 = new HashSet<Contact>();
        contacts2.add(new Contact("email", "samp@sample.com"));
        contacts2.add(new Contact("phone", "0999999999"));

        /////////////////////////////////////////////////////////////

        Person person = new Person(name, address, birthDate, dateHired, currentlyEmployed, gwa, roles, contacts);
        Person person2 = new Person(name2, address2, birthDate2, dateHired2, currentlyEmployed2, gwa2, roles2, contacts2);

        dao.addPerson(person);
        dao.addPerson(person2);
    }
}
