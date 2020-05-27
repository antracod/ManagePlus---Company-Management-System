package com.teodor.models;

public class Salary extends Payment{
    private int salaryTax = this.getPaymentValue()/2;

    public int getSalaryTax()
    {
        return salaryTax;
    }

    public void setSpecialSalaryTax(int specialTax)
    {
        this.salaryTax = specialTax;

    }
}
