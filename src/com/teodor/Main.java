package com.teodor;

import com.teodor.models.BonusPayment;
import com.teodor.models.FinancialBalance;
import com.teodor.models.Payment;
import com.teodor.repositories.FinancialRepository;
import com.teodor.tests.CsvTests;
import com.teodor.ui.MainScreen;
import javafx.application.Application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        /*FinancialBalance x = new FinancialBalance();
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
        */
        try{
            CsvTests csvTests = new CsvTests();
            csvTests.startCsvTesting();
        }catch(IOException e){

        }

        Payment p = new Payment(3, "Tarfa de Ma-ta" , 1000, "12.12.2020");
        try{
            FinancialRepository financialDB = new FinancialRepository();
            financialDB.addEntry(p);
            List<Payment> kek = financialDB.getEntry();
            financialDB.deleteEntry(3);
            System.out.println(kek.size());


        }catch(Exception e)
        {
            System.out.println(e);
        }

        new Thread(() -> Application.launch(MainScreen.class)).start();
        MainScreen startUpTest = MainScreen.waitForMainScreen();
        startUpTest.printSomething();
    }
}
