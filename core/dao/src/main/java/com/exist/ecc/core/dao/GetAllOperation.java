package com.exist.ecc.core.dao;

import org.hibernate.Session;

public class GetAllOperation implements Operation {
	String entityName;

	public GetAllOperation(String entityName) {
		this.entityName = entityName;
	}
	
	public Object operate(Session session) {
		return session.createQuery("FROM " + entityName);
	}
}
