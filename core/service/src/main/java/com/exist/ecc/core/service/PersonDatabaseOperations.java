package com.exist.ecc.core.service;

import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Role;
import com.exist.ecc.core.dao.PersonDao;
import java.util.List;
import java.util.Set;

public class PersonDatabaseOperations {
	public Integer addPerson(Person person) {
		return new PersonDao().addPerson(person);
	}

	public Person getPerson(int id) {
		return new PersonDao().getPerson(id);
	}

	public List<Person> getAllPerson() {
		return new PersonDao().getAllPerson();
	}

	public void deletePerson(int id) {
		new PersonDao().deletePerson(id);
	}

	public void updatePerson(Person person) {
		new PersonDao().updatePerson(person);
	}

	////////////////////////////////////////////////////////

	public void viewRoles() {
		List<Role> roles = new PersonDao().retrieveRoles();
		System.out.println("ROLE          PERSONS");
		roles.forEach(r -> System.out.println(r.getRoleName() + "          " + r.getPersons()));
	}

	public void displayPerson(int id) { // --> to separate class, static final String FORMAT = "%-30s......"
		Person person = getPerson(id);
		System.out.printf("%-30s %-20s %-20s %-20s\n", "NAME", "DATE OF BIRTH", "CURRENTLY_EMPLOYED", "GWA");
	    displayPersonInfo(person);
	}

	public void displayPersonInfo(Person person) {
		System.out.printf("%-4s %-30s %-20s %-20s %-20s\n", person.getId(), person.getName(), person.getBirthDate(),
		                                                    person.getCurrentlyEmployed(), person.getGwa());
	}

	public void displayAllPerson() {
		List<Person> persons = getAllPerson();
		System.out.printf("%-4s %-30s %-20s %-20s %-20s\n", "ID", "NAME", "DATE OF BIRTH", "CURRENTLY_EMPLOYED", "GWA");
		persons.forEach(p -> displayPersonInfo(p));
	}
}
