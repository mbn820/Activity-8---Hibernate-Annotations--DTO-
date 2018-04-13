package com.exist.ecc.core.dao;

import org.hibernate.Session;

public class AddOperation implements Operation{
	private Object obj;

	public AddOperation(Object obj) {
		this.obj = obj;
	}

	public Object operate(Session session) {
		Object result = session.save(obj);
		return result;
	}
}
