package com.exist.ecc.app.forms;

import com.exist.ecc.app.ConsoleInputUtil;
import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Name;
import com.exist.ecc.core.model.Address;
import com.exist.ecc.core.model.Contact;
import com.exist.ecc.core.model.Role;
import com.exist.ecc.core.service.PersonDatabaseOperations;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;



public class UpdatePersonForm {
	public static void show() {
		Set<Role> roles = new HashSet<Role>();

		int targetPersonId = ConsoleInputUtil.getAnyInteger("Enter person id: ");

		Person targetPerson = new PersonDatabaseOperations().getPerson(targetPersonId);

		displayOptions();

		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 8);

		switch(choice) {
			case 1 :
				Name newName = PersonDetailsInput.getNameInformation();
				targetPerson.setName(newName);
				break;
			case 2 :
				Address newAddress = PersonDetailsInput.getAddressInformation();
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
			case 7 : // PersonDetailsInput.getRolesInformation(roles); break;
			case 8 : break; // PersonDetailsInput.getContactInformation(); break;
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
	}

	public static void update(Person person) {
		new PersonDatabaseOperations().updatePerson(person);
		System.out.println("Person has been updated");
	}
}
