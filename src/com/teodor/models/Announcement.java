package com.teodor.models;

import com.teodor.csvhelper.CsvFileSerializable;

import javax.security.auth.login.AccountNotFoundException;

public class Announcement implements CsvFileSerializable {
    private int AnnouncementId;
    private String AnnouncementText;

    public Announcement(){}
    public Announcement(int AnnouncementId,String AnnouncementText)
    {
        this.AnnouncementId = AnnouncementId;
        this.AnnouncementText = AnnouncementText;
    }

    public int getAnnouncementId()
    {
        return this.AnnouncementId;
    }

    public void setAnnouncementId(int AnnouncementId)
    {
        this.AnnouncementId = AnnouncementId;
    }

    public String getAnnouncementText()
    {
        return this.AnnouncementText;
    }

    public void setAnnouncementText(String AnnouncementText)
    {
        this.AnnouncementText = AnnouncementText;
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{"AnnouncementId","AnnouncementText"};
    }

    @Override
    public String[] convertToStringList() {
        return new String[]{ Integer.toString(AnnouncementId) , AnnouncementText };
    }

    @Override
    public void convertFromStringsList(String[] input) {
        AnnouncementId = Integer.parseInt(input[0]);
        AnnouncementText = input[1];
    }

    //Not impl
    @Override
    public String[] processStringList() {
        return new String[0];
    }
}
