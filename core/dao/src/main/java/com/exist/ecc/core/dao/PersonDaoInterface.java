package com.exist.ecc.core.dao;

import com.exist.ecc.core.model.Person;
import java.util.List;

public interface PersonDaoInterface {
	public Integer addPerson(Person person);
	public Person getPerson(int id);
	public List<Person> getAllPerson(String orderBy);
	public void deletePerson(int id);
	public void updatePerson(Person person);
}
