package com.exist.ecc.core.dao;

import org.hibernate.Session;

public interface Operation {
	public Object operate(Session session);
}
