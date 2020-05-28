package com.teodor.tests;

import com.teodor.csvhelper.CsvService;
import com.teodor.models.Announcement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvTests {

    public CsvTests(){}

    public static void startCsvTesting() throws IOException
    {
        try{
            Announcement testAnnouncement = new Announcement(1,"Anundsdst");
            BufferedWriter AnnouncementWriter = new BufferedWriter(new FileWriter("Announcements.csv"));
            CsvService<Announcement> instanceOne = new CsvService ( new Announcement(), AnnouncementWriter);
            CsvService<Announcement> companyCsv = instanceOne;
            companyCsv.writeObject(testAnnouncement);
            AnnouncementWriter.flush();




        }catch(IOException e)
        {

        }

    }




}
