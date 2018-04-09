package com.exist.ecc.app;

public class UserInterface {
      public static void menu() {
            System.out.println( "[1] Add new Person" );
            System.out.println( "[2] View Person records" );
            System.out.println( "[3] Update Person details" );
            System.out.println( "[4] Delete Person records" );
            System.out.println( "[5] View Roles" );
            System.out.println( "[6] Exit" );
            int choice = ConsoleInputUtil.getAnyInteger( "ENTER CHOICE: " );

            // switch( choice ) {
            //       case 1 :
            // }
      }
}
