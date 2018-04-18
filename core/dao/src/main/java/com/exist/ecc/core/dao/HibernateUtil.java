package com.exist.ecc.core.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import com.exist.ecc.core.model.Address;


public class HibernateUtil {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            AnnotationConfiguration configuration = new AnnotationConfiguration().configure();

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }

	public Object transact(Operation operation) {
		sessionFactory = getSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		Object result = null;

		try {
			transaction = session.beginTransaction();
			result = operation.execute(session);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			throw e;
		} finally {
			session.close();
		}

		return result;
	}


}
