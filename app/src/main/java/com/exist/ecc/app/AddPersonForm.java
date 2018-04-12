package com.exist.ecc.app;

import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Name;
import com.exist.ecc.core.model.Address;
import com.exist.ecc.core.model.Role;
import com.exist.ecc.core.model.Contact;
import com.exist.ecc.core.dao.PersonDao;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;


public class AddPersonForm {

    public void show() {
        Set<Role> roles = new HashSet<Role>();

        Name name = PersonDetailsInput.getNameInformation();
        Address address = PersonDetailsInput.getAddressInformation();
        Date birthDate = PersonDetailsInput.getDateInformation();
        Date dateHired = PersonDetailsInput.getDateInformation();
        boolean currentlyEmployed = PersonDetailsInput.getEmploymentStatusInformation();
        roles = PersonDetailsInput.getRolesInformation(roles);
        Set<Contact> contacts = PersonDetailsInput.getContactInformation();

        ConsoleInputUtil.getAll("Press Enter to Continue.......");
    }

}
