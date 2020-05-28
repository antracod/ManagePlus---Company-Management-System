package com.teodor.tests;

import com.teodor.csvhelper.CsvService;
import com.teodor.models.Announcement;
import com.teodor.models.Employee;
import com.teodor.models.ProjectTask;
import com.teodor.models.Rule;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvTests {

    public CsvTests(){}

    public static void startCsvTesting() throws IOException
    {
        try{

            BufferedWriter AnnouncementWriter = new BufferedWriter(new FileWriter("Announcements.csv"));
            CsvService<Announcement> AnnouncementCsv = new CsvService ( new Announcement(), AnnouncementWriter);
            Announcement testAnnouncement = new Announcement(1,"Cine folosesti allowmainthreadqueries o sa fie dat afara");
            AnnouncementCsv.writeObject(testAnnouncement);
            AnnouncementWriter.flush();

            BufferedWriter RuleWriter = new BufferedWriter(new FileWriter("Rules.csv"));
            CsvService<Rule> RuleCsv = new CsvService ( new Rule(), RuleWriter);
            Rule testRule = new Rule(1,"Nu folositi allowmainthreadqueries");
            RuleCsv.writeObject(testRule);
            RuleWriter.flush();

            BufferedWriter ProjectTaskWriter = new BufferedWriter(new FileWriter("ProjectTasks.csv"));
            CsvService<ProjectTask> ProjectTaskCsv = new CsvService ( new ProjectTask(), ProjectTaskWriter);
            ProjectTask testProjectTask = new ProjectTask(1,"Learn OOP");
            ProjectTaskCsv.writeObject(testProjectTask);
            ProjectTaskWriter.flush();

            BufferedWriter EmployeeWriter = new BufferedWriter(new FileWriter("Employees.csv"));
            CsvService<Employee> EmployeeCsv = new CsvService ( new Employee(), EmployeeWriter);
            Employee testEmployee = new Employee("Radu","Teodor-George");
            EmployeeCsv.writeObject(testEmployee);
            EmployeeWriter.flush();

        }catch(IOException e)
        {

        }

    }




}
