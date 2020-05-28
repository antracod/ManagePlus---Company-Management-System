package com.teodor;
///Radu Teodor-George
import com.teodor.models.BonusPayment;
import com.teodor.models.FinancialBalance;
import com.teodor.models.Payment;
import com.teodor.repositories.FinancialRepository;
import com.teodor.services.FinancialService;
import com.teodor.tests.ClassService;
import com.teodor.tests.ClassTests;
import com.teodor.tests.CsvTests;
import com.teodor.ui.MainScreen;
import javafx.application.Application;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
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

       // ClassTests testClassSimpleService = new ClassTests();

        try{
            CsvTests csvTests = new CsvTests();
            csvTests.startCsvTesting();
        }catch(IOException e){

        }

        Payment p = new Payment(3, "Test Test" , 1000, "12.12.2020");
        Payment p2 = new Payment(3, "Test2 Test2" , 1000, "12.12.2020");

        ///Testing Database Service
        try{

            FinancialService financialDB = new FinancialService();
            financialDB.addEntry(p);
            Collection<Payment> kek = financialDB.getEntry();
            p.setPaymentReceiver("RandomName");
            financialDB.updateEntry(p);
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
