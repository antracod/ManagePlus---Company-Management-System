package com.teodor;

import com.teodor.models.Payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static java.sql.JDBCType.NULL;

public class DatabaseConnection {
    private Connection conn = null;

    public DatabaseConnection() throws SQLException {
        conn = DriverManager.getConnection("jdbc:sqlite:Financial.db");
        String createCompaniesTableSql =
                "CREATE TABLE IF NOT EXISTS FinancialBalance (" +
                        "TransactionID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                        "\"TransactionReceiver\"\tTEXT,"+
                        "\"TransactionValue\"\t INTEGER," +
                        "\"PaymentDate\"\tTEXT" +

                        ")";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createCompaniesTableSql);
        }catch(SQLException e){
            System.out.println("Conenction Error: " + e);
        }
    }

    public void addPayment(Payment payment) {
        String insertCompanySql =
                "INSERT INTO FinancialBalance " +
                        "( TransactionReceiver, TransactionValue, PaymentDate) " +
                        "VALUES " +
                        "('" + payment.getPaymentReceiver() + "', '" + payment.getPaymentValue() + "','" + payment.getPaymentDate() + "')";
        try (Statement stmt = conn.createStatement()) {
            int insertedRows = stmt.executeUpdate(insertCompanySql);
            if (insertedRows != 1) {
                throw new SQLException("Failed to insert company into database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
