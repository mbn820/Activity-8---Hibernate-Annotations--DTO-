package com.exist.ecc.app.forms;

import com.exist.ecc.app.ConsoleInputUtil;
import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Contact;
import com.exist.ecc.core.model.Address;
import com.exist.ecc.core.service.PersonService;
import com.exist.ecc.util.Util;
import java.util.List;
import java.util.Set;

public class ViewPersonForm {
	public static void show() {
		System.out.println("[1] Find Person");
		System.out.println("[2] View All Person");
		System.out.println("[3] Back");
		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 3);

		switch(choice) {
			case 1 : viewPerson(); break;
			case 2 : viewAllPerson(); break;
			case 3 : break;
		}
	}

	public static void viewPerson() {
		int targetPersonId = ConsoleInputUtil.getAnyInteger("Enter person id: ");
		Person targetPerson = new PersonService().getPerson(targetPersonId);
		if(targetPerson == null) {
			System.out.println("Record does not exist");
			return;
		}
		System.out.println(Util.PERSON_HEADER);
		Util.printPersonInfo(targetPerson);

		viewContactOrAddress(targetPerson);
	}

	public static void  viewAllPerson(){
		List<Person> persons = new PersonService().getAllPerson("id");
		Util.printPersonInfo(persons);

		System.out.println("\nORDER BY: ");
		System.out.println("[1] Last Name");
		System.out.println("[2] GWA");
		System.out.println("[3] Date Hired");
		System.out.println("[4] Cancel");
		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 4);

		switch(choice) {
			case 1 :
				System.out.println("ORDER BY LAST NAME");
				persons = new PersonService().getAllPerson("name.lastName");
				Util.printPersonInfo(persons);
				break;
			case 2 :
			    System.out.println("ORDER BY GWA");
				persons = new PersonService().getAllPerson("gwa");
				Util.printPersonInfo(persons);
				break;
			case 3 :
			    System.out.println("ORDER BY DATE HIRED");
				persons = new PersonService().getAllPerson("dateHired");
				Util.printPersonInfo(persons);
				break;
			case 4 :
				show();
			    break;
		}
	}

	public static void viewContactOrAddress(Person person) {
		System.out.println("[1] View Contacts");
		System.out.println("[2] View Address");
		System.out.println("[3] Exit");

		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 3);

		switch(choice) {
			case 1 : viewContacts(person); break;
			case 2 : viewAddress(person); break;
			case 3 : break;
		}
	}

	public static void viewContacts(Person person) {
		Set<Contact> contacts = person.getContacts();
		System.out.printf("%s's Contacts: \n", person.getName().getFirstName());
		contacts.forEach(c -> System.out.println("\t" + c));
		viewContactOrAddress(person);
	}

	public static void viewAddress(Person person) {
		Address address = person.getAddress();
		System.out.printf("%s's Address: \n", person.getName().getFirstName());
		System.out.println(address);
		viewContactOrAddress(person);
	}
}
