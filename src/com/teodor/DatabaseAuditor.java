package com.teodor;

import com.teodor.models.Payment;
import com.teodor.services.FinancialService;
import com.teodor.services.IService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Date;

import static java.nio.charset.StandardCharsets.UTF_8;

public class DatabaseAuditor implements IService {
    private BufferedWriter auditorWriter;
    private FinancialService financialRep;

    public DatabaseAuditor(String filePath, FinancialService financialDB) throws IOException {
        this.financialRep = financialDB;
        Path path = Paths.get(filePath);
        this.auditorWriter = Files.newBufferedWriter(path, UTF_8);
    }

    @Override
    public void addEntry(Object entry) {
        addActionToLog("EntryAdded");
        financialRep.addEntry((Payment)entry);
    }

    @Override
    public Collection<Payment> getEntry() {
        addActionToLog("EntryReturned");
        return financialRep.getEntry();
    }

    @Override
    public void deleteEntry(int id) {
        addActionToLog("EntryDeleted");
        financialRep.deleteEntry(id);

    }

    @Override
    public void updateEntry(Object entry) {
        addActionToLog("EntryUpdated");
        financialRep.updateEntry((Payment)entry);
    }

    private void addActionToLog(String actionName) {
        Date timestamp = new Date();
        String currentThreadName = Thread.currentThread().getName();
        String line = actionName + timestamp + currentThreadName + "\n";
        try {
            auditorWriter.write(line);
            auditorWriter.flush();
        } catch (IOException e) {
            System.err.print("Cannot Write to Log file");
            e.printStackTrace();
        }
    }
}
