package com.exist.ecc.app.forms;

import com.exist.ecc.app.ConsoleInputUtil;
import com.exist.ecc.core.service.PersonDatabaseOperations;

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
		System.out.println("Found person with id: " + targetPersonId);
		new PersonDatabaseOperations().displayPerson(targetPersonId);
	}

	public static void  viewAllPerson(){
		System.out.println("ORDER BY: ");
		System.out.println("[1] Last Name");
		System.out.println("[2] GWA");
		System.out.println("[3] Date Hired");
		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 3);

		switch(choice) {
			case 1 :
				System.out.println("ORDER BY LAST NAME");
				new PersonDatabaseOperations().displayAllPerson("name.lastName");
				break;
			case 2 :
			      System.out.println("ORDER BY GWA");
				new PersonDatabaseOperations().displayAllPerson("gwa");
				break;
			case 3 :
			      System.out.println("ORDER BY DATE HIRED");
				new PersonDatabaseOperations().displayAllPerson("dateHired");
				break;
		}
	}
}
