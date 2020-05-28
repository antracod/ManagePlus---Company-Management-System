package com.teodor.models;

import com.teodor.csvhelper.CsvFileSerializable;

public class Payment {
    protected int paymentID;
    protected int paymentValue;
    protected String paymentDate;
    protected String paymentReceiver;

    public Payment(){}
    public Payment(int paymentValue)
    {
        this.paymentValue = paymentValue;
    }
    public Payment(int paymentValue,String paymentDate)
    {
        this.paymentValue = paymentValue;
        this.paymentDate = paymentDate;
    }
    public Payment(int paymentID,String paymentReceiver,int paymentValue, String paymentDate)
    {
        this.paymentID = paymentID;
        this.paymentReceiver = paymentReceiver;
        this.paymentValue = paymentValue;
        this.paymentDate = paymentDate;
    }
    public int getPaymentID()
    {
        return this.paymentID;
    }

    public void setPaymentID(int paymentValue)
    {
        this.paymentValue = paymentID;
    }

    public String getPaymentReceiver()
    {
        return this.paymentReceiver;
    }

    public void setPaymentReceiver(String paymentReceiver)
    {
        this.paymentReceiver = paymentReceiver;
    }

    public int getPaymentValue()
    {
        return this.paymentValue;
    }

    public void setPaymentValue(int paymentValue)
    {
        this.paymentValue = paymentValue;
    }

    public String getPaymentDate()
    {
        return this.paymentDate;
    }

    public void setPaymentDate(String paymentDate)
    {
        this.paymentDate = paymentDate;
    }






}
