package com.teodor.csvhelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;

public class CsvService<T extends CsvFileSerializable> {

    private static BufferedWriter CsvWriter;
    private static BufferedReader CsvReader;
    private static CsvService instance;

    public CsvService(T object, BufferedWriter writer) throws IOException {

        CsvWriter = writer;

        if (object == null) {
            return;
        }
            String[] columns = object.getColumnNames();
            String header = String.join(",", columns) + '\n';
            writer.write(header);
            writer.flush();
    }

    public  void writeObject(T object) throws IOException {
        String[] strings = object.convertToStringList();
        String line = String.join(",", strings) + '\n';
        CsvWriter.write(line);
    }

    public CsvService(T object, BufferedReader reader) throws IOException {
        this.CsvReader = reader;
        if (object != null) {
            String header = reader.readLine();
            String[] columns = header.split(",");
            boolean headersMatch = Arrays.equals(columns, object.getColumnNames());
            if (!headersMatch) {
                throw new RuntimeException("Error in csv h");
            }
        }
    }

    public boolean hasMoreObjects() throws IOException {
        return CsvReader.ready();
    }

    public void readObject(T object) throws IOException {
        String line = CsvReader.readLine();
        String[] values = line.split(",");
        object.convertFromStringsList(values);
    }


}
