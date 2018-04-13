package com.exist.ecc.app;

import com.exist.ecc.core.model.Person;
import com.exist.ecc.core.model.Name;

public class App {
    public static void main( String[] args ) {
        UserInterface.menu();
        Name name = new Name("Mikhail", "Bagalihog", "Nunez");
        // Person person = new Person(name);
        //
        // System.out.println(person);
        // ConsoleInputUtil.getDesiredPattern(String msg, String pattern)
    }
}
