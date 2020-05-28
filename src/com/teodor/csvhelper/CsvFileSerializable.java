package com.teodor.csvhelper;

public interface CsvFileSerializable {
     String[] getColumnNames();
     String[] convertToStringList();
     void convertFromStringsList(String[] input);
     String[] processStringList();
}
