package com.exist.ecc.core.dao;

import org.hibernate.Session;

public class GetOperation implements Operation{
	private Class clazz;
	private int id;

	public GetOperation(Class clazz, int id) {
		this.clazz = clazz;
		this.id = id;
	}
	public Object operate(Session session) {
		return session.get(clazz, id);
	}
}
