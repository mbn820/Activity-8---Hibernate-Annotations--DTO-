package com.exist.ecc.app;

import com.exist.ecc.core.dao.PersonDao;
import com.exist.ecc.core.model.Person;

public class DeletePersonForm {
	private int id;
	private PersonDao personDao;

	public DeletePersonForm(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void show() {
		getPersonId();
		showPersonDetails();
		deleteOrCancel();
	}

	public void getPersonId() {
		id = ConsoleInputUtil.getAnyInteger("Enter Person Id: ");
	}

	public void showPersonDetails() {
		Person person = personDao.retrievePerson(id);
		System.out.println(person);
	}

	public void deleteOrCancel() {
		String decision = ConsoleInputUtil.getDesiredString("Delete or Cancel? [d/c]: ", "d", "c");

		switch(decision) {
			case "d" : deletePerson();
			           break;
		    case "c" : break;
		}
	}

	public void deletePerson() {
		personDao.deletePersonRecord(id);
	}
}
