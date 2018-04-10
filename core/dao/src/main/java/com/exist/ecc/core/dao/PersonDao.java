package com.exist.ecc.core.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.io.File;

import com.exist.ecc.core.model.Person;

public class PersonDao {
	public static void main(String[] args) {

		//creating configuration object
		Configuration cfg=new Configuration();
		File file = new File("/home/mnunez/Desktop/Activity 1 - 5 (gitrepository)/Activity 7 - Hibernate/infra/persistence/hibernate.cfg.xml");
		cfg.configure(file);//populates the data of the configuration file

		//creating seession factory object
		SessionFactory factory=cfg.buildSessionFactory();

		//creating session object
		Session session=factory.openSession();

		//creating transaction object
		Transaction t=session.beginTransaction();

		Person person = new Person();
		person.setFirst("Juan");
		person.setLast("Dela Cruz");

		session.persist(person);//persisting the object

		t.commit();//transaction is commited
		session.close();

		System.out.println("successfully saved");

	}
}
