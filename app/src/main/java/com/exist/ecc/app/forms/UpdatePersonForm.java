package com.exist.ecc.app.forms;

import java.util.Date;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import com.exist.ecc.app.ConsoleInputUtil;
import com.exist.ecc.core.model.*;
import com.exist.ecc.core.service.PersonDtoService;
import com.exist.ecc.core.service.RoleService;
import com.exist.ecc.util.Util;
import com.exist.ecc.core.model.dto.*;


public class UpdatePersonForm {
	public static void show() {
		List<PersonDto> allPersons = new PersonDtoService().getAllPersonDto("id");
		Util.printBasicPersonDtoInfo(allPersons);

		int targetPersonId = ConsoleInputUtil.getAnyInteger("Enter person id: ");

		PersonDto targetPerson = new PersonDtoService().getPersonDto(targetPersonId);

		if(targetPerson == null) {
			System.out.println("Record does not exist");
			return;
		}

		displayOptions();

		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 9);

		switch(choice) {
			case 1 :
				NameDto newName = PersonDetailsInput.getNameInformation();
				targetPerson.setName(newName);
				break;
			case 2 :
				AddressDto newAddress = PersonDetailsInput.getAddressInformation();
				targetPerson.setAddress(newAddress);
				break;
			case 3 :
				Date newBirthDate = PersonDetailsInput.getDateInformation("BIRTHDATE");
				targetPerson.setBirthDate(newBirthDate);
			    break;
			case 4 :
				Date newDateHired = PersonDetailsInput.getDateInformation("DATE HIRED");
				targetPerson.setDateHired(newDateHired);
			    break;
			case 5 :
				boolean newEmploymentStatus = PersonDetailsInput.getEmploymentStatusInformation();
				targetPerson.setCurrentlyEmployed(newEmploymentStatus);
				break;
			case 6 :
				double newGwa = PersonDetailsInput.getGwaInformation();
				targetPerson.setGwa(newGwa);
				break;
			case 7 :
				updateRoles(targetPerson);
				break;
			case 8 :
				updateContacts(targetPerson);
				break;
			case 9 :
			    break;
		}

		ConsoleInputUtil.getAll("Press Enter to Continue.......");

		update(targetPerson);


	}

	public static void displayOptions() {
		System.out.println("Choose information to update: ");
		System.out.println("[1] Name");
		System.out.println("[2] Address");
		System.out.println("[3] Birth Date");
		System.out.println("[4] Date Hired");
		System.out.println("[5] Employment");
		System.out.println("[6] GWA");
		System.out.println("[7] Roles");
		System.out.println("[8] Contacts");
		System.out.println("[9] Cancel");
	}

	public static void update(PersonDto person) {
		new PersonDtoService().updatePerson(person);
		System.out.println("Person has been updated");
	}

	public static void updateRoles(PersonDto targetPerson) {
		Util.printRoleInfo( new ArrayList(targetPerson.getRoles()) );
		System.out.println("\nUPDATE ROLES");
		System.out.println("[1] Remove Role");
		System.out.println("[2] Add Roles");
		int choice = ConsoleInputUtil.getIntegerBetween("ENTER CHOICE: ", 1, 2);

		switch(choice) {
			case 1 : int roleId = ConsoleInputUtil.getAnyInteger("Enter role id: ");
			         targetPerson.removeRole(new RoleService().getRole(roleId));
					 break;
			case 2 : Set<RoleDto> newRoles = PersonDetailsInput.getRolesInformation(targetPerson.getRoles());
			         newRoles.forEach(role -> targetPerson.addRole(role));
					 break;
		}
	}

	public static void updateContacts(PersonDto targetPerson) {
		Set<ContactDto> targetPersonContacts = targetPerson.getContacts();

		System.out.println("Current list of Contacts: ");
		targetPersonContacts.forEach(contact -> System.out.printf("[%s]  %s\n", contact.getId(), contact));
		System.out.println("UPDATE CONTACTS");
		System.out.println("[1] Add Contact");
		System.out.println("[2] Remove Contact");
		int choice = ConsoleInputUtil.getIntegerBetween("ENTER CHOICE: ", 1, 2);

		switch(choice) {
			case 1 : System.out.println("Add Contact Information");
					 Set<ContactDto> newContacts = PersonDetailsInput.getContactInformation(targetPerson.getContacts());
					 targetPersonContacts.addAll(newContacts);
					 break;
			case 2 : int chosenId = ConsoleInputUtil.getAnyInteger("Enter the id of contact to remove: ");
					 targetPersonContacts.removeIf(contact -> contact.getId() == chosenId);
					 break;
		}
	}
}
