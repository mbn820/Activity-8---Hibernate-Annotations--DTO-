package com.exist.ecc.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Name;
import com.exist.ecc.core.model.Address;

public class PersonDao {
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(); // create HibernateUtil

	public void addPerson(Person person) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(person);
		transaction.commit();
		session.close();
	}

	public Person retrievePerson(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Person person = (Person) session.get(Person.class, id);
		transaction.commit();
		session.close();

		return person;
	}

	public List<Person> retrieveAllPerson() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction(); // --> refactor later(duplicate)

		List<Person> persons = session.createQuery("FROM Person").list();
		transaction.commit();
		session.close();

		return persons;
	}

	public void updatePersonName(int id, Name newName) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Person person = (Person) session.get(Person.class, id); // same as delete, create retrieveSinglePerson(id) method
		person.setName(newName);

		session.update(person);
		transaction.commit();
		session.close();
	}

	public void deletePersonRecord(int id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Person person = (Person) session.get(Person.class, id);

		session.delete(person);
		transaction.commit();
		session.close();
	}
}
