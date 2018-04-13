package com.exist.ecc.core.dao;

import org.hibernate.Session;
import com.exist.ecc.core.model.Person;

public class AddPersonOperation implements Operation{
	private Person person;

	public AddPersonOperation(Person person) {
		this.person = person;
	}

	public Object operate(Session session) {
		Object obj = session.save(person);
		return obj;
	}
}
