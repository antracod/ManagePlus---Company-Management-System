package com.teodor.models;

public class ProjectTask {

    private int ProjectTaskId;
    private String ProjectTaskText;

    ProjectTask(){}
    ProjectTask(int ProjectTaskId,String ProjectTaskText)
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

}
