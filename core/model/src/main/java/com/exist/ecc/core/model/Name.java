package com.exist.ecc.core.model;

public class Name {
      private String firstName;
      private String lastName;
      private String middleName;
      // private String suffix; // jr, III, sr., etc
      // private String title; // dr., atty., etc

      public Name(String firstName, String middleName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
      }

      // getters
      public String getFirstName() { return firstName; }
      public String getLastName() { return lastName; }
      public String getMiddleName() { return middleName; }

      //setters
      public void setFirstName(String firstName) {
            this.firstName = firstName;
      }

      public void setLastName(String firstName) {
            this.firstName = firstName;
      }

      public void setMiddletName(String firstName) {
            this.firstName = firstName;
      }

      public String toString() {
            return String.format("%s %c. %s", firstName, middleName.charAt(0), lastName);
      }
}
