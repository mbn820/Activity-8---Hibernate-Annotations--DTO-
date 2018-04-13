package com.exist.ecc.app;

import com.exist.ecc.core.model.Person;

public class DeletePersonForm {
	public static void show() {
		int targetPersonId = ConsoleInputUtil.getAnyInteger("\tEnter person id: ");

		ConsoleInputUtil.getAll("Press Enter to Continue.......");

		delete(new Person());
	}

	public static void delete(Person person) {
		System.out.println("Person has been deleted from the database");
	}
}
