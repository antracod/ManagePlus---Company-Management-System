package com.teodor;

import com.teodor.models.BonusPayment;
import com.teodor.models.FinancialBalance;
import com.teodor.models.Payment;

import java.sql.SQLException;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        FinancialBalance x = new FinancialBalance();
        Payment y = new Payment(2, "20.10.2020");
        Payment z = new Payment(3, "Teodor" , 100, "12.12.2020");
        BonusPayment zz = new BonusPayment();
        x.addToFinancialBalance(y);
        x.addToFinancialBalance(zz);
       // x.printFinancialBalance();
        Vector<Payment> k = x.getFinancialBalance();
       // System.out.println("Size: "+k.size());
        try {
            DatabaseConnection myDatabase = new DatabaseConnection();
           // myDatabase.addTransaction(z);
        }catch(SQLException e)
        {

        }




    }
}
