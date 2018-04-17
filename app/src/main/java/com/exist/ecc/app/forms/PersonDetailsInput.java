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

	public static String formatter(String str) {
		return String.format("\t%-20s: ", str);
	}

	public static Name getNameInformation() {
		System.out.println("**NAME**");
        String firstName = ConsoleInputUtil.getAnyString( formatter("First Name") );
        String middleName = ConsoleInputUtil.getAnyString( formatter("Middle Name") );
        String lastName = ConsoleInputUtil.getAnyString( formatter("Last Name") );
		String suffix = ConsoleInputUtil.getAnyString( formatter("Suffix") );
		String title = ConsoleInputUtil.getAnyString( formatter("Title") );

        return new Name(firstName, middleName, lastName, suffix, title);
    }

    public static Address getAddressInformation() {
		System.out.println("**ADDRESS**");
        int streetNumber = ConsoleInputUtil.getAnyInteger( formatter("Street Number") );
        String barangay = ConsoleInputUtil.getAnyString( formatter("Barangay") );
        String municipality = ConsoleInputUtil.getAnyString( formatter("Municipality") );
        String zipcode = ConsoleInputUtil.getDesiredPattern( formatter("Zipcode"), "[0-9]{4}", "Invalid Input | Please enter 4 digit zipcode");

        return new Address(streetNumber, barangay, municipality, zipcode);
    }

    public static Date getDateInformation(String header) {
		System.out.printf("**%s**\n", header);
        int month = ConsoleInputUtil.getIntegerBetween( formatter("Month [1-12]"), 1, 12 );
        int day = ConsoleInputUtil.getIntegerBetween( formatter("Day   [1-31]"), 1, 31 );
        int year = ConsoleInputUtil.getIntegerBetween( formatter("Year  [yyyy]"), 1900, 2018 );

        Date date = new Date();

		try {
	        date = DateUtils.setMonths(date, month - 1);
	        date = DateUtils.setDays(date, day);
	        date = DateUtils.setYears(date, year);
		} catch (IllegalArgumentException e) {
			System.out.println("Invalid Date");
			getDateInformation(header);
		}

		return date;
    }

    public static boolean getEmploymentStatusInformation() {
		System.out.println("**EMPLOYMENT**");
        String choice = ConsoleInputUtil.getDesiredString( formatter("Currently Employed? [y/n]"), "y", "n" );
        return (choice.equals("y"));
    }

    public static double getGwaInformation() {
		System.out.println("**GWA**");
        return ConsoleInputUtil.getDoubleBetween( formatter("Enter GWA [1.0-5.0]"), 1.0, 5.0);
    }

	public static Role getSingleRoleInformation() {
		System.out.println("**ROLE**");
		String roleName = ConsoleInputUtil.getAnyString( formatter("Role") );
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

	public static Contact getSingleContact(String contactType, String pattern, String errorMsg) {
		System.out.println("**CONTACT**");
		String details = ConsoleInputUtil.getDesiredPattern( formatter(contactType), pattern, errorMsg );
		return new Contact(contactType, details);
	}

	public static Set<Contact> getContactInformation(Set<Contact> contacts) {
		System.out.println("Choose contact type to add: ");
		System.out.println("[1] Email");
		System.out.println("[2] Phone");
		System.out.println("[3] Landline");
		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 3);

		String contactType = null;
		String pattern = null;
		String errorMsg = null;

		switch(choice) {
			case 1 : contactType = "email";
			         pattern = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
					 errorMsg = "Invalid input | Correct Sample Format : sample@mail.com";
					 break;
			case 2 : contactType = "phone";
					 pattern = "\\d{10,11}";
					 errorMsg = "Invalid input | Please Enter 10 - 11 digit cellphone number";
					 break;
			case 3 : contactType = "landline";
			         pattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
					 errorMsg = "Invalid input | Correct Formats : 123-123-1111, 1234567890, (123)123-1111";
			         break;
		}
		contacts.add(getSingleContact(contactType, pattern, errorMsg));

		String decision = ConsoleInputUtil.getDesiredString("\tAdd more contact or proceed? [a/p]:", "a", "p");

		switch(decision) {
			case "a" : getContactInformation(contacts);
			           break;
			case "p" : break;
		}

		return contacts;
	}
}
