package com.exist.ecc.app.forms;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import com.exist.ecc.app.ConsoleInputUtil;
import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Name;
import com.exist.ecc.core.model.Address;
import com.exist.ecc.core.model.Role;
import com.exist.ecc.core.model.Contact;
import org.apache.commons.lang3.time.DateUtils;

public class PersonDetailsInput {

	public static Name getNameInformation() {
		System.out.println("**NAME**");
        String firstName = ConsoleInputUtil.getAnyString("\tFirst name: ");
        String middleName = ConsoleInputUtil.getAnyString("\tMiddle name: ");
        String lastName = ConsoleInputUtil.getAnyString("\tLast name: ");

        return new Name(firstName, middleName, lastName);
    }

    public static Address getAddressInformation() {
		System.out.println("**ADDRESS**");
        int streetNumber = ConsoleInputUtil.getAnyInteger("\tStreet Number: ");
        String barangay = ConsoleInputUtil.getAnyString("\tBarangay: ");
        String municipality = ConsoleInputUtil.getAnyString("\tMunicipality: ");
        String zipcode = ConsoleInputUtil.getAnyString("\tZipcode: ");

        return new Address(streetNumber, barangay, municipality, zipcode);
    }

    public static Date getDateInformation(String header) {
		System.out.printf("**%s**", header);
        int month = ConsoleInputUtil.getIntegerBetween("\tMonth: ", 1, 12);
        int day = ConsoleInputUtil.getIntegerBetween("\tDay:", 1, 30);
        int year = ConsoleInputUtil.getIntegerBetween("\tYear:", 1900, 2017);

        Date date = new Date();
        date = DateUtils.setMonths(date, month - 1);
        date = DateUtils.setDays(date, day);
        date = DateUtils.setYears(date, year);

		return date;
    }

    public static boolean getEmploymentStatusInformation() {
		System.out.println("**EMPLOYMENT**");
        String choice = ConsoleInputUtil.getDesiredString("\tCurrently Employed? [y/n]: ", "y", "n");
        return (choice.equals("y"));
    }

    public static double getGwaInformation() {
		System.out.println("**GWA**");
        return ConsoleInputUtil.getDoubleBetween("\tEnter GWA: ", 1.0, 5.0);
    }

	public static Role getSingleRoleInformation() {
		System.out.println("**ROLE**");
		String roleName = ConsoleInputUtil.getAnyString("\tRole: ");
		return new Role(roleName);
	}

	public static Set<Role> getRolesInformation(Set<Role> roles) {
		roles.add(getSingleRoleInformation());
		String decision = ConsoleInputUtil.getDesiredString("\tAdd more role or proceed? [a/p]:", "a", "p");

		switch(decision) {
			case "a" : getRolesInformation(roles);
			           break;
			case "p" : break;
		}

		return roles;
	}

	public static Set<Contact> getContactInformation() {
		System.out.println("**CONTACTS**");
		Set<Contact> contacts = new HashSet<Contact>();

		String emailDetails = ConsoleInputUtil.getAnyString("\tEmail address: ");
		contacts.add(new Contact("email", emailDetails));

		String phoneDetails = ConsoleInputUtil.getAnyString("\tPhone: ");
		contacts.add(new Contact("phone", phoneDetails));

		String landLineDetails = ConsoleInputUtil.getAnyString("\tLandline: ");
		contacts.add(new Contact("landline", landLineDetails));

		return contacts;
	}
}
