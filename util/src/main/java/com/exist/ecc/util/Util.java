package com.exist.ecc.util;

import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Role;
import com.exist.ecc.core.model.dto.RoleDto;
import com.exist.ecc.core.model.dto.PersonDto;
import java.util.List;

public class Util {
	public static final String PERSON_FORMAT = "%-4s %-30s %-20s %-20s %-20s %-8s %-20s\n";
	public static final String PERSON_HEADER = String.format(PERSON_FORMAT, "ID", "NAME", "DATE OF BIRTH", "DATE HIRED", "CURRENTLY_EMPLOYED", "GWA", "ROLE(S)");

	public static final String ROLE_FORMAT = "%-4s %-15s %s\n";
	public static final String ROLE_HEADER = String.format(ROLE_FORMAT, "ID", "ROLE", "PERSON(S)");

	public static void printPersonInfo(Person person) {
		System.out.printf(PERSON_FORMAT, person.getId(), person.getName(), person.getBirthDate(), person.getDateHired(), person.getCurrentlyEmployed(), person.getGwa(), person.getRoles());
	}

	public static void printPersonInfo(List<Person> persons) {
		System.out.println(PERSON_HEADER);
		persons.forEach(person -> printPersonInfo(person));
	}

	public static void printBasicPersonInfo(List<Person> persons) {
		System.out.println("ID       NAME");
		persons.forEach(person -> System.out.printf("%-9s%s\n", person.getId(), person.getName()));
	}

	public static void printRoleInfo(RoleDto role) {
		System.out.printf(ROLE_FORMAT, role.getId(), role.getRoleName(), role.getPersons());
	}

	public static void printRoleInfo(List<RoleDto> roles) {
		System.out.println(ROLE_HEADER);
		roles.forEach(role -> printRoleInfo(role));
	}

////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void printPersonDtoInfo(PersonDto person) {
		System.out.printf(PERSON_FORMAT, person.getId(), person.getName(), person.getBirthDate(), person.getDateHired(), person.getCurrentlyEmployed(), person.getGwa(), person.getRoles());
	}

	public static void printPersonDtoInfo(List<PersonDto> persons) {
		System.out.println(PERSON_HEADER);
		persons.forEach(person -> printPersonDtoInfo(person));
	}

	public static void printBasicPersonDtoInfo(List<PersonDto> persons) {
		System.out.println("ID       NAME");
		persons.forEach(person -> System.out.printf("%-9s%s\n", person.getId(), person.getName()));
	}
}
