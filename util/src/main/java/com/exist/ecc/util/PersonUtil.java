package com.exist.ecc.core.util;

import com.exist.ecc.core.model.Person;
import java.util.List;

public class PersonUtil {
	public static final String FORMAT = "%-4s %-30s %-20s %-20s %-20s %-8s %-20s\n";
	public static final String HEADER = String.format(FORMAT, "ID", "NAME", "DATE OF BIRTH", "DATE HIRED", "CURRENTLY_EMPLOYED", "GWA", "ROLE(S)");

	public static void printInfo(Person person) {
		System.out.printf(FORMAT, person.getId(), person.getName(), person.getBirthDate(), person.getDateHired(), person.getCurrentlyEmployed(), person.getGwa(), person.getRoles());
	}

	public static void printInfo(List<Person> persons) {
		System.out.println(HEADER);
		persons.forEach(person -> printInfo(person));
	}
}
