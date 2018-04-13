package com.exist.ecc.core.service;

import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.dao.PersonDao;
import java.util.List;

public class PersonDatabaseOperations {
	public void addPerson(Person person) {
		new PersonDao().addPerson(person);
	}

	public Person findPerson(int id) {
		return null;
	}

	public List<Person> findAllPerson() {
		return null;
	}

	public void deletePerson(int id) {

	}

	public void updatePerson(Person person) {

	}
}
