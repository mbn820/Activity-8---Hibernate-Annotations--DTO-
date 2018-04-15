package com.exist.ecc.core.model;

import java.util.Set;

public class Role {
	private int id;
	private String roleName;
	private Set<Person> persons;

	public Role() {}
	public Role(String roleName) {
		this.roleName = roleName;
	}

	public int getId() { return id; }
	public String getRoleName() { return roleName; }
	public Set<Person> getPersons() { return persons; }

	public void setId(int id) {
		this.id = id;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setPersons(Set<Person> person) {
		this.persons = persons;
	}

	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!this.getClass().equals(obj.getClass())) return false;

		Role obj2 = (Role)obj;
		if((this.id == obj2.getId()) && (this.roleName.equals(obj2.getRoleName()))) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		int tmp = 0;
		tmp = (id + roleName).hashCode();
		return tmp;
	}

	public String toString() {
		return roleName;
	}
}
