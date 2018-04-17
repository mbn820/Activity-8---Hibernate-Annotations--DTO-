package com.exist.ecc.app;

import com.exist.ecc.core.service.PersonService;
import com.exist.ecc.app.forms.AddPersonForm;
import com.exist.ecc.app.forms.DeletePersonForm;
import com.exist.ecc.app.forms.ViewPersonForm;
import com.exist.ecc.app.forms.UpdatePersonForm;


public class PersonManagementApp {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        if(new PersonService().isEmpty()) {
            showAddAndExitOnly();
        } else {
            showAllOptions();
        }
    }

    public static void showAddAndExitOnly() {
        System.out.println("\n\n");
        System.out.println("[1] Add new Person");
        System.out.println("[2] Exit");

        int choice = ConsoleInputUtil.getIntegerBetween("ENTER CHOICE: ", 1, 2);

        switch(choice) {
            case 1 : addNewPerson();
                     break;
            case 2 : exit();
                     break;
        }
    }

    public static void showAllOptions() {
        System.out.println("\n\n");
        System.out.println("[1] Add new Person");
        System.out.println("[2] View Person records");
        System.out.println("[3] Update Person details");
        System.out.println("[4] Delete Person records");
        System.out.println("[5] View Roles");
        System.out.println("[6] Exit");

        int choice = ConsoleInputUtil.getIntegerBetween("ENTER CHOICE: ", 1, 6);

        switch(choice) {
            case 1 : addNewPerson();
                     break;
            case 2 : viewPersonRecords();
                     break;
            case 3 : updatePersonDetails();
                     break;
            case 4 : deletePersonRecords();
                     break;
            case 5 : viewRoles();
                     break;
            case 6 : exit();
                     break;
            default: menu();
                     break;
        }
    }

    public static void addNewPerson() {
        System.out.println("---ADD NEW PERSON---");
        AddPersonForm.show();
        menu();
    }

    public static void viewPersonRecords() {
        System.out.println("---VIEW PERSON RECORDS---");
        ViewPersonForm.show();
        menu();
    }

    public static void updatePersonDetails() {
        System.out.println("---UPDATE PERSON DETAILS---");
        UpdatePersonForm.show();
        menu();
    }

    public static void deletePersonRecords() {
        System.out.println("---DELETE PERSON RECORDS---");
        DeletePersonForm.show();
        menu();
    }

    public static void viewRoles() {
        System.out.println("---VIEW ROLES---");
        new PersonService().viewRoles();
        menu();
    }

    public static void exit() {
        System.out.println("---EXIT---");
        String decision = ConsoleInputUtil.getDesiredString("Are you sure? [y/n]: ", "y", "n");

        switch(decision) {
            case "y" : System.exit(0);
            case "n" : menu(); break;
            default : menu();
        }
    }

}
