package com.exist.ecc.app.forms;

import com.exist.ecc.app.ConsoleInputUtil;
import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.service.PersonService;
import com.exist.ecc.core.service.PersonUtil;
import java.util.List;

public class ViewPersonForm {
	public static void show() {
		System.out.println("[1] Find Person");
		System.out.println("[2] View All Person");

		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 2);

		switch(choice) {
			case 1 : viewPerson(); break;
			case 2 : viewAllPerson(); break;
		}
	}

	public static void viewPerson() {
		int targetPersonId = ConsoleInputUtil.getAnyInteger("Enter person id: ");
		Person targetPerson = new PersonService().getPerson(targetPersonId);
		if(targetPerson == null) {
			System.out.println("Record does not exist");
			return;
		}
		System.out.println(PersonUtil.HEADER);
		PersonUtil.printInfo(targetPerson);

	}

	public static void  viewAllPerson(){
		List<Person> persons = null;
		System.out.println("ORDER BY: ");
		System.out.println("[1] ID");
		System.out.println("[2] Last Name");
		System.out.println("[3] GWA");
		System.out.println("[4] Date Hired");
		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 3);

		switch(choice) {
			case 1 :
				System.out.println("ORDER BY ID");
				persons = new PersonService().getAllPerson("id");
				PersonUtil.printInfo(persons);
				break;
			case 2 :
				System.out.println("ORDER BY LAST NAME");
				persons = new PersonService().getAllPerson("name.lastName");
				PersonUtil.printInfo(persons);
				break;
			case 3 :
			    System.out.println("ORDER BY GWA");
				persons = new PersonService().getAllPerson("gwa");
				PersonUtil.printInfo(persons);
				break;
			case 4 :
			    System.out.println("ORDER BY DATE HIRED");
				persons = new PersonService().getAllPerson("dateHired");
				PersonUtil.printInfo(persons);
				break;
		}
	}
}
