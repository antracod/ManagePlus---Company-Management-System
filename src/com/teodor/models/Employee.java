package com.teodor.models;

import com.teodor.csvhelper.CsvFileSerializable;

public class Employee implements CsvFileSerializable {
    protected String name;
    protected String surname;

    public Employee(){}
    public Employee(String name,String surname)
    { this.name = name;
      this.surname = surname;
    }

    public String getEmployeeName() { return this.name; }
    public void setEmployeeName(String name) { this.name = name; }

    public String getEmployeeSurname() { return this.surname; }
    public void setEmployeeSurname(String surname) { this.surname = surname; }

    @Override
    public String[] getColumnNames() {
        return new String[]{"name","surname"};
    }

    @Override
    public String[] convertToStringList() {
        return new String[]{ name , surname };
    }

    @Override
    public void convertFromStringsList(String[] input) {
        name =input[0];
        surname = input[1];
    }

    //Not impl
    @Override
    public String[] processStringList() {
        return new String[0];
    }

}
