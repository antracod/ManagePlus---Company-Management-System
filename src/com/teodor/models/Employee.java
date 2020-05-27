package com.teodor.models;

public class Employee {
    protected String name;
    protected String surname;

    Employee(){}
    Employee(String name,String surname)
    { this.name = name;
      this.surname = surname;
    }

    public String getEmployeeName() { return this.name; }
    public void setEmployeeName(String name) { this.name = name; }

    public String getEmployeeSurname() { return this.surname; }
    public void setEmployeeSurname(String surname) { this.surname = surname; }


}
