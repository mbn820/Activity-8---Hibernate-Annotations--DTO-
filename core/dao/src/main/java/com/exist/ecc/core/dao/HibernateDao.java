package com.exist.ecc.core.dao;

import java.util.List;
import org.apache.commons.lang3.ClassUtils;

public class HibernateDao<T> {
	public Integer persist(T entity) {
		return (Integer) new HibernateUtil().transact(session -> session.save(entity));
	}

	public T fetchById(Class classObj, int id) {
		return (T) new HibernateUtil().transact(session -> session.get(classObj, id));
	}

	// public List<T> fetchAll() {
	// 	return (List<T>) new HibernateUtil().transact( session -> session.createQuery("FROM " + new T().getClass().getSimpleName()).list() );
	// }

	public void update(T entity) {
		new HibernateUtil().transact(session -> session.save(entity));
	}

	public void delete(T entity) {
		new HibernateUtil().transact(session -> session.save(entity));
	}
}
