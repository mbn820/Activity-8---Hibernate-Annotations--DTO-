package com.exist.ecc.app.forms;

import com.exist.ecc.app.ConsoleInputUtil;
import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Name;
import com.exist.ecc.core.model.Address;
import com.exist.ecc.core.model.Role;
import com.exist.ecc.core.model.Contact;
import com.exist.ecc.core.service.PersonDatabaseOperations;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;


public class AddPersonForm {

    public static void show() {
        Set<Role> roles = new HashSet<Role>();

        Name name = PersonDetailsInput.getNameInformation();
        Address address = PersonDetailsInput.getAddressInformation();
        Date birthDate = PersonDetailsInput.getDateInformation("BIRTH DATE");
        Date dateHired = PersonDetailsInput.getDateInformation("DATE HIRED");
        boolean currentlyEmployed = PersonDetailsInput.getEmploymentStatusInformation();
        double gwa = PersonDetailsInput.getGwaInformation();
        roles = PersonDetailsInput.getRolesInformation(roles);
        Set<Contact> contacts = PersonDetailsInput.getContactInformation();

        ConsoleInputUtil.getAll("Press Enter to Continue.......");

        Person person = new Person(name, address, birthDate, dateHired,
                                   currentlyEmployed, gwa, roles, contacts);

        save(person);
    }

    private static void save(Person person) {
        Integer id = new PersonDatabaseOperations().addPerson(person);
        System.out.println(person + "has been saved to the database with an id of: " + id);
    }

}
