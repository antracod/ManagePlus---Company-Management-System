package com.teodor.models;

import com.teodor.csvhelper.CsvFileSerializable;

public class ProjectTask implements CsvFileSerializable {

    private int ProjectTaskId;
    private String ProjectTaskText;

    public ProjectTask(){}
    public ProjectTask(int ProjectTaskId,String ProjectTaskText)
    {
        this.ProjectTaskId = ProjectTaskId;
        this.ProjectTaskText = ProjectTaskText;
    }

    public int getProjectTaskId()
    {
        return this.ProjectTaskId;
    }

    public void setProjectTaskId(int ProjectTaskId)
    {
        this.ProjectTaskId = ProjectTaskId;
    }

    public String getProjectTaskText()
    {
        return this.ProjectTaskText;
    }

    public void setProjectTaskText(String ProjectTaskText)
    {
        this.ProjectTaskText = ProjectTaskText;
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{"AnnouncementId","AnnouncementText"};
    }

    @Override
    public String[] convertToStringList() {
        return new String[]{ Integer.toString(ProjectTaskId) , ProjectTaskText };
    }

    @Override
    public void convertFromStringsList(String[] input) {
        ProjectTaskId = Integer.parseInt(input[0]);
        ProjectTaskText = input[1];
    }

    //Not impl
    @Override
    public String[] processStringList() {
        return new String[0];
    }

}
