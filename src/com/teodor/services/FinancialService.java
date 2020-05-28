package com.teodor.services;

import com.teodor.models.Payment;
import com.teodor.repositories.FinancialRepository;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class FinancialService implements IService<Payment>{

    FinancialRepository financialRep = new FinancialRepository();

    public FinancialService() throws SQLException {


    }


    @Override
    public void addEntry(Payment entry) {
        financialRep.addEntry(entry);
    }

    @Override
    public Collection<Payment> getEntry() {
        return financialRep.getEntry();
    }

    @Override
    public void deleteEntry(int id) {
        financialRep.deleteEntry(id);
    }

    @Override
    public void updateEntry(Payment entry) {
        financialRep.updateEntry(entry);
    }
}
