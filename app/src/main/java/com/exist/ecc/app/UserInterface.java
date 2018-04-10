package com.exist.ecc.app;

public class UserInterface {
    public static void menu() {
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
        new AddNewPersonForm().getAllDetails();
        menu();
    }

    public static void viewPersonRecords() {
        System.out.println("---VIEW PERSON RECORDS---");
    }

    public static void updatePersonDetails() {
        System.out.println("---UPDATE PERSON DETAILS---");
    }

    public static void deletePersonRecords() {
        System.out.println("---DELETE PERSON RECORDS---");
    }

    public static void viewRoles() {
        System.out.println("---VIEW ROLES---");
    }

    public static void exit() {
        System.out.println("---EXIT---");
    }

}
