package com.exist.ecc.app;

import com.exist.ecc.core.service.PersonService;
import com.exist.ecc.core.service.RoleService;
import com.exist.ecc.app.forms.*;
import com.exist.ecc.core.dao.*;


public class PersonManagementApp {
    public static void main(String[] args) {
        startMenu();
    }

    public static void startMenu() {
        System.out.println("\n\n~~~~~~~MAIN MENU~~~~~~~");
        System.out.println("[1] Manage Persons");
        System.out.println("[2] Manage Roles");
        System.out.println("[3] Exit");

        int choice = ConsoleInputUtil.getIntegerBetween("ENTER CHOICE: ", 1, 4);

        switch(choice) {
            case 1 : managePersonsMenu(); break;
            case 2 : manageRolesMenu();   break;
            case 3 : exit();              break;
            case 4 : purgeDatabase();     break;
        }
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void managePersonsMenu() {
        System.out.println("\n\n~~~~~~~MANAGE PERSONS~~~~~~~");
        System.out.println("[1] Add new Person");
        System.out.println("[2] View Person records");
        System.out.println("[3] Update Person details");
        System.out.println("[4] Delete Person records");
        System.out.println("[5] MANAGE ROLES");
        System.out.println("[6] Back");

        int choice = ConsoleInputUtil.getIntegerBetween("ENTER CHOICE: ", 1, 6);

        switch(choice) {
            case 1 : addNewPerson();        break;
            case 2 : viewPersonRecords();   break;
            case 3 : updatePersonDetails(); break;
            case 4 : deletePersonRecords(); break;
            case 5 : manageRolesMenu();     break;
            case 6 : startMenu();           break;
        }
    }

    public static void addNewPerson() {
        System.out.println("\n\n---ADD NEW PERSON---");
        AddPersonForm.show();
        managePersonsMenu();
    }

    public static void viewPersonRecords() {
        System.out.println("\n\n---VIEW PERSON RECORDS---");
        ViewPersonForm.show();
        managePersonsMenu();
    }

    public static void updatePersonDetails() {
        System.out.println("\n\n---UPDATE PERSON DETAILS---");
        UpdatePersonForm.show();
        managePersonsMenu();
    }

    public static void deletePersonRecords() {
        System.out.println("\n\n---DELETE PERSON RECORDS---");
        DeletePersonForm.show();
        managePersonsMenu();
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void manageRolesMenu() {
        System.out.println("\n\n~~~~~~~MANAGE ROLES~~~~~~~");
        System.out.println("[1] Add new Roles");
        System.out.println("[2] View Roles");
        System.out.println("[3] Delete Roles");
        System.out.println("[4] MANAGE PERSONS");
        System.out.println("[5] Back");

        int choice = ConsoleInputUtil.getIntegerBetween("ENTER CHOICE: ", 1, 5);

        switch(choice) {
            case 1 : addNewRoles();       break;
            case 2 : viewRoles();         break;
            case 3 : deleteRoles();       break;
            case 4 : managePersonsMenu(); break;
            case 5 : startMenu();         break;
        }
    }

    public static void addNewRoles() {
        System.out.println("\n\n---ADD ROLES---");
        AddRolesForm.show();
        manageRolesMenu();
    }

    public static void viewRoles() {
        System.out.println("\n\n---VIEW ROLES---");
        new RoleService().viewRoles();
        manageRolesMenu();
    }

    public static void deleteRoles() {
        System.out.println("\n\n---DELETE ROLES---");
        DeleteRolesForm.show();
        manageRolesMenu();
    }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static void exit() {
        System.out.println("\n\n---EXIT---");
        String decision = ConsoleInputUtil.getDesiredString("Are you sure? [y/n]: ", "y", "n");

        switch(decision) {
            case "y" : System.exit(0); break;
            case "n" : startMenu();    break;
        }
    }

    public static void purgeDatabase() {
        int passcode = ConsoleInputUtil.getAnyInteger("PASSWORD : ");
        if(passcode != 418323) {
            startMenu();
        }
        new PersonDao().deleteAllRecords();
        new RoleDao().deleteAllRoles();
        startMenu();
    }

}// 1 : 43 pm
