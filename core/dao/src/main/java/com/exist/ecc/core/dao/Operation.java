package com.exist.ecc.core.dao;

import org.hibernate.Session;

public interface Operation {
	public Object execute(Session session);
}
