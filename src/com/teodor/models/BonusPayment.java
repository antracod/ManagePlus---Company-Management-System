package com.teodor.models;

public class BonusPayment extends Payment{
    private String bonusReason;

    public BonusPayment(){ }
    public BonusPayment(int paymentValue)
    {
        this.paymentValue = paymentValue;
    }

    public BonusPayment(int paymentID,String paymentReceiver,int paymentValue,String paymentDate,String bonusReason)
    {
        this.paymentID = paymentID;
        this.paymentReceiver = paymentReceiver;
        this.paymentValue = paymentValue;
        this.paymentDate = paymentDate;
        this.bonusReason = bonusReason;
    }

}
