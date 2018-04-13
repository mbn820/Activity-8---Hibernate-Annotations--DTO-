package com.exist.ecc.app;

import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Name;
import com.exist.ecc.core.model.Address;
import com.exist.ecc.core.model.Contact;
import com.exist.ecc.core.model.Role;
import java.util.Date;
import java.util.Set;
import java.util.HashSet;


public class UpdatePersonForm {
	public static void show() {
		Set<Role> roles = new HashSet<Role>();

		int targetPersonId = ConsoleInputUtil.getAnyInteger("Enter person id: ");

		displayOptions();

		int choice = ConsoleInputUtil.getIntegerBetween("Choose information to be updated: ", 1, 8);

		switch(choice) {
			case 1 : PersonDetailsInput.getNameInformation(); break;
			case 2 : PersonDetailsInput.getAddressInformation(); break;
			case 3 : PersonDetailsInput.getDateInformation("BIRTHDATE"); break;
			case 4 : PersonDetailsInput.getDateInformation("DATE HIRED"); break;
			case 5 : PersonDetailsInput.getEmploymentStatusInformation(); break;
			case 6 : PersonDetailsInput.getGwaInformation(); break;
			case 7 : PersonDetailsInput.getRolesInformation(roles); break;
			case 8 : PersonDetailsInput.getContactInformation(); break;
		}

		ConsoleInputUtil.getAll("Press Enter to Continue.......");

		update(new Person());


	}

	public static void displayOptions() {
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
		System.out.println("Person has been updated");
	}
}
