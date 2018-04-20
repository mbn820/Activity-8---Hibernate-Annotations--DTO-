package com.exist.ecc.app.forms;

import com.exist.ecc.app.ConsoleInputUtil;
import com.exist.ecc.core.model.Contact;
import com.exist.ecc.core.model.Address;
import com.exist.ecc.core.service.PersonDtoService;
import com.exist.ecc.core.service.PersonDto;
import com.exist.ecc.util.Util;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Comparator;

public class ViewPersonForm {
	public static void show() {
		if(new PersonDtoService().databaseIsEmpty()) {
			System.out.println("No records");
			return;
		}
		System.out.println("[1] Find Person");
		System.out.println("[2] View All Person");
		System.out.println("[3] Back");
		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 3);

		switch(choice) {
			case 1 : findPerson();    break;
			case 2 : viewAllPerson(); break;
			case 3 :                  break;
		}
	}

	public static void findPerson() {
		String lastName = ConsoleInputUtil.getAnyString("Enter last name: ");
		List<PersonDto> persons = new PersonDtoService().getPersonDtosByLastName(lastName);

		if(persons.isEmpty()) {
			System.out.println("No record found with last name : " + lastName);
			return;
		}

		if(persons.size() == 1) {
			displayInfo(persons.get(0));
			return;
		}

		Util.printBasicPersonDtoInfo(persons);

		List<Integer> desiredInputs = new ArrayList<Integer>();
		persons.forEach(person -> desiredInputs.add(person.getId()));
		int targetPersonId = ConsoleInputUtil.getDesiredIntegers("Choose id: ", desiredInputs);
		PersonDto targetPerson = null;

		for(PersonDto person : persons) {
			if(person.getId() == targetPersonId) {
				targetPerson = person;
				break;
			}
		}

		displayInfo(targetPerson);
	}

	public static void displayInfo(PersonDto person) {
		System.out.println(Util.PERSON_HEADER);
		Util.printPersonDtoInfo(person);
		viewContactOrAddress(person);
	}

	public static void  viewAllPerson(){
		List<PersonDto> persons = new PersonDtoService().getAllPersonDto("id");
		Util.printPersonDtoInfo(persons);

		System.out.println("\nORDER BY: ");
		System.out.println("[1] Last Name");
		System.out.println("[2] GWA");
		System.out.println("[3] Date Hired");
		System.out.println("[4] Cancel");
		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 4);

		switch(choice) {
			case 1 :
				System.out.println("\nORDER BY LAST NAME");
				persons = new PersonDtoService().getPersonDtosByLastName(""); // criteria
				Util.printPersonDtoInfo(persons);
				break;
			case 2 :
			    System.out.println("\nORDER BY GWA");
				persons.sort(Comparator.comparing(PersonDto :: getGwa)); // java sort
				Util.printPersonDtoInfo(persons);
				break;
			case 3 :
			    System.out.println("\nORDER BY DATE HIRED");
				persons = new PersonDtoService().getAllPersonDto("dateHired"); // hql
				Util.printPersonDtoInfo(persons);
				break;
			case 4 :
				show();
			    break;
		}
	}

	public static void viewContactOrAddress(PersonDto person) {
		System.out.println("[1] View Contacts");
		System.out.println("[2] View Address");
		System.out.println("[3] Exit");

		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 3);

		switch(choice) {
			case 1 : viewContacts(person); break;
			case 2 : viewAddress(person);  break;
			case 3 :                       break;
		}
	}

	public static void viewContacts(PersonDto person) {
		Set<Contact> contacts = person.getContacts();
		System.out.printf("%s's Contacts: \n", person.getName().getFirstName());
		contacts.forEach(c -> System.out.println("\t" + c));
		viewContactOrAddress(person);
	}

	public static void viewAddress(PersonDto person) {
		Address address = person.getAddress();
		System.out.printf("%s's Address: \n", person.getName().getFirstName());
		System.out.println("\t" + address);
		viewContactOrAddress(person);
	}
}
