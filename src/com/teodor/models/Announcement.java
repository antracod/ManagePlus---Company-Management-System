package com.teodor.models;

import javax.security.auth.login.AccountNotFoundException;

public class Announcement {
    private int AnnouncementId;
    private String AnnouncementText;

    Announcement(){}
    Announcement(int AnnouncementId,String AnnouncementText)
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



}
