package com.exist.ecc.app.forms;

import com.exist.ecc.app.ConsoleInputUtil;
import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Name;
import com.exist.ecc.core.model.Address;
import com.exist.ecc.core.model.Role;
import com.exist.ecc.core.model.Contact;
import com.exist.ecc.core.service.PersonService;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;

public class AddPersonForm {

    public static void show() {
        Set<Role> roles = new HashSet<Role>();
        Set<Contact> contacts = new HashSet<Contact>();

        Name name = PersonDetailsInput.getNameInformation();
        Address address = PersonDetailsInput.getAddressInformation();
        Date birthDate = PersonDetailsInput.getDateInformation("BIRTH DATE");
        Date dateHired = PersonDetailsInput.getDateInformation("DATE HIRED");
        boolean currentlyEmployed = PersonDetailsInput.getEmploymentStatusInformation();
        double gwa = PersonDetailsInput.getGwaInformation();
        roles = PersonDetailsInput.getRolesInformation(roles);
        contacts = PersonDetailsInput.getContactInformation(contacts);

        ConsoleInputUtil.getAll("Press Enter to Continue.......");

        Person person = new Person(name, address, birthDate, dateHired,
                                   currentlyEmployed, gwa, roles, contacts);
        person.getRoles().forEach(role -> role.addPerson(person));
        save(person);
    }

    private static void save(Person person) {
        Integer id = new PersonService().addPerson(person);
        person.getRoles().forEach(role -> new PersonService().addRole(role));
        System.out.println(person + " has been saved to the database with an id of: " + id);
    }

}
