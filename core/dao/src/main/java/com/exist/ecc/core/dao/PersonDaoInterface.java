package com.exist.ecc.core.dao;

import com.exist.ecc.core.model.Person;
import java.util.List;

public interface PersonDaoInterface {
	public void addPerson(Person person);
	public Person getPerson(int id);
	public List<Person> getAllPerson();
	public void deletePerson(int id);
	public void updatePerson(Person person);
}
