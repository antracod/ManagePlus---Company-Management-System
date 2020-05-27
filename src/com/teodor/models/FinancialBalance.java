package com.teodor.models;

import java.util.Vector;

public class FinancialBalance {
    private Vector<Payment> paymentList = new Vector<Payment>();

    public void printFinancialBalance()
    {
        int paymentListSize = this.paymentList.size();
        for(int i=0;i<paymentListSize;i++)
        {
            Payment tmpPayment = this.paymentList.get(i);
            System.out.println("Payment Value: "+ tmpPayment.getPaymentValue() + " PaymentDate: " + tmpPayment.getPaymentDate() );

        }
    }
    public Vector<Payment> getFinancialBalance()
    {
            return this.paymentList;
    }

    public void addToFinancialBalance(Payment newPayment)
    {
        this.paymentList.add(newPayment);
    }
}
