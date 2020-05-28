package com.teodor.repositories;

import com.teodor.models.Payment;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FinancialRepository implements IRepository {

    private Connection financialDBConnection = null;

    public FinancialRepository() throws SQLException {
        financialDBConnection = DriverManager.getConnection("jdbc:sqlite:Financial.db");
        String createCompaniesTableSql =
                "CREATE TABLE IF NOT EXISTS FinancialBalance (" +
                        "TransactionID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "\"TransactionReceiver\"\tTEXT,"+
                        "\"TransactionValue\"\t INTEGER," +
                        "\"PaymentDate\"\tTEXT" +

                        ")";

        try (Statement stmt = financialDBConnection.createStatement()) {
            stmt.execute(createCompaniesTableSql);
        }catch(SQLException e){
            System.out.println("Conenction Error: " + e);
        }
    }

    @Override
    public void addEntry(Object entry) {
        String insertCompanySql =
                "INSERT INTO FinancialBalance " +
                        "(TransactionID, TransactionReceiver,TransactionValue, PaymentDate) " +
                        "VALUES " +
                        "('" + ((Payment)entry).getPaymentID() + "', '" + ((Payment)entry).getPaymentReceiver() + "','"
                        + ((Payment)entry).getPaymentValue() +"' ,'"+ ((Payment)entry).getPaymentDate() +"')";

        try (Statement stmt = financialDBConnection.createStatement()) {
            int insertedRows = stmt.executeUpdate(insertCompanySql);
            if (insertedRows != 1) {
                throw new SQLException("Failed to insert company into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Payment> getEntry() {
        String getSql = "SELECT * FROM FinancialBalance";
        try (Statement stmt = financialDBConnection.createStatement()) {
            ArrayList<Payment> payments = new ArrayList<>();
            ResultSet result = stmt.executeQuery(getSql);
            while (result.next()) {
                Payment payment = new Payment(result.getInt("TransactionID"),
                        result.getString("TransactionReceiver"),
                        result.getInt("TransactionValue"),
                        result.getString("PaymentDate"));
                payments.add(payment);
            }
            return payments;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntry(int id) {

        String deleteSql = "DELETE FROM FinancialBalance WHERE TransactionID = " + id;

        try (Statement stmt = financialDBConnection.createStatement()) {
            int deletedEntry = stmt.executeUpdate(deleteSql);
            if (deletedEntry != 1) {
                throw new SQLException("Failed to delete company into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateEntry(Object entry) {
        String insertCompanySql =
                "UPDATE FinancialBalance SET" +
                        "TransactionID = " + ((Payment)entry).getPaymentID() + "','" +
                        "TransactionReceiver,"  + ((Payment)entry).getPaymentReceiver() + "','" +
                        "TransactionValue, "  + ((Payment)entry).getPaymentValue() + "','" +
                        "PaymentDate) "  + ((Payment)entry).getPaymentDate() + "','" +
                        "WHERE TransactionID = "  + ((Payment)entry).getPaymentID() ;


        try (Statement stmt = financialDBConnection.createStatement()) {
            int insertedRows = stmt.executeUpdate(insertCompanySql);
            if (insertedRows != 1) {
                throw new SQLException("Failed to insert company into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
