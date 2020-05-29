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
        Payment p = new Payment(3, "Radu Teodor-George" , 15252, "12.12.2020");
        Payment p2 = new Payment(5, "Udar Rodoet-Egroeg" , 15252, "12.12.2020");

        ///TESTING CLASS OPERATIONS AND SERVICE
        ClassTests testClassSimpleService = new ClassTests();

        ///TESTING CSV
        try{
            CsvTests csvTests = new CsvTests();
            csvTests.startCsvTesting();
        }catch(IOException e){

        }

        ///Testing Database Service
        try{
            FinancialService financialDB = new FinancialService();
            financialDB.addEntry(p);
            Collection<Payment> kek = financialDB.getEntry();
            p.setPaymentReceiver("RandomName");
            financialDB.updateEntry(p);
            System.out.println(kek.size());

            DatabaseAuditor testAuditor = new DatabaseAuditor("Auditor.txt",financialDB);
            testAuditor.addEntry(p2);
          //  testAuditor.deleteEntry(3);
         //   testAuditor.deleteEntry(5);

        }catch(Exception e)
        {
            System.out.println(e);
        }

        ///UI
        new Thread(() -> Application.launch(MainScreen.class)).start();
        MainScreen startUpTest = MainScreen.waitForMainScreen();
        startUpTest.printSomething();
    }
}
