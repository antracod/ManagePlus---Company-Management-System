package com.teodor.csvhelper;

public interface CsvFileSerializable {
    String[] getColumnNames();
    String[] setStringList();
    void updateStringsList(String[] input);
    String[] processStringList();
}
