package com.exist.ecc.app.forms;

import com.exist.ecc.app.ConsoleInputUtil;
import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Name;
import com.exist.ecc.core.model.Address;
import com.exist.ecc.core.model.Role;
import com.exist.ecc.core.model.Contact;
import com.exist.ecc.core.service.PersonDto;
import com.exist.ecc.core.service.PersonDtoService;
import com.exist.ecc.core.service.RoleService;
import com.exist.ecc.core.service.MapperUtil;
import java.util.Date;
import java.util.Set;
import java.util.List;
import java.util.HashSet;

public class AddPersonForm {

    public static void show() {
        Set<Contact> contacts = new HashSet<Contact>();

        Name name = PersonDetailsInput.getNameInformation();
        Address address = PersonDetailsInput.getAddressInformation();
        Date birthDate = PersonDetailsInput.getDateInformation("BIRTH DATE");
        Date dateHired = PersonDetailsInput.getDateInformation("DATE HIRED");
        boolean currentlyEmployed = PersonDetailsInput.getEmploymentStatusInformation();
        double gwa = PersonDetailsInput.getGwaInformation();
        Set<Role> roles = chooseRoles();
        contacts = PersonDetailsInput.getContactInformation(contacts);

        ConsoleInputUtil.getAll("Press Enter to Continue.......");

        PersonDto personDto = new PersonDto(name, address, birthDate, dateHired,
                                   currentlyEmployed, gwa, roles, contacts);
        personDto.getRoles().forEach(role -> role.addPerson( new MapperUtil().mapToPerson(personDto) ));
        save(personDto);
    }

    public static Set<Role> chooseRoles() {
        Set<Role> roles = new HashSet<Role>();
        // display roles
        List<Role> existingRoles = new RoleService().getAllRoles();
        if(existingRoles.isEmpty()) {
            return roles;
        }
        System.out.println("ID    ROLE");
        existingRoles.forEach( role -> System.out.printf("[%s]   %s\n", role.getId(), role.getRoleName()) );
        // get roles by id
        return PersonDetailsInput.getRolesInformation(roles);


    }



    private static void save(PersonDto person) {
        Integer id = new PersonDtoService().addPerson(person);
        System.out.println(person + " has been saved to the database with an id of: " + id);
    }

}
