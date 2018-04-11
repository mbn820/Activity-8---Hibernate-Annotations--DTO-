package com.exist.ecc.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.util.List;

import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Name;
import com.exist.ecc.core.model.Address;

public class PersonDao {
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {
		PersonDao personDao = new PersonDao();

		Name name = new Name("Vincent", "V", "Valentine");
		Address address = new Address(12, "Mansion", "Shinra Corp.", "2213");
		Person person = new Person(name, address);

		Name name2 = new Name("Cloud", "V", "Cloud");
		Address address2 = new Address(12, "Ivalice", "Shinra Corp.", "2233");
		Person person2 = new Person(name2, address2);


		//create
		personDao.addPerson(person);
		personDao.addPerson(person2);

		//read
		List<Person> persons = personDao.retrieveAllRecords();
		persons.forEach(p -> System.out.println(p));

		//update
		Name newName = new Name("Tyrion", "A", "Lannister");
		personDao.updatePersonName(1, newName);

		//delete
		personDao.deletePersonRecord(2);


	}

	public void addPerson(Person person) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.save(person);
		transaction.commit();
		session.close();
	}

	public List<Person> retrieveAllRecords() {
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
