package com.teodor.models;

import com.teodor.csvhelper.CsvFileSerializable;

public class Rule implements CsvFileSerializable,Comparable<Rule> {
    private int RuleId;
    private String RuleText;

    public Rule(){}
    public Rule(int RuleId,String RuleText)
    {
        this.RuleId = RuleId;
        this.RuleText = RuleText;
    }

    public int getRuleId()
    {
        return this.RuleId;
    }

    public void setRuleId(int RuleId)
    {
        this.RuleId = RuleId;
    }

    public String getRuleText()
    {
        return this.RuleText;
    }

    public void setRuleText(String RuleText)
    {
        this.RuleText = RuleText;
    }

    @Override
    public String[] getColumnNames() {
        return new String[]{"AnnouncementId","AnnouncementText"};
    }

    @Override
    public String[] convertToStringList() {
        return new String[]{ Integer.toString(RuleId) , RuleText };
    }

    @Override
    public void convertFromStringsList(String[] input) {
        RuleId = Integer.parseInt(input[0]);
        RuleText = input[1];
    }

    //Not impl
    @Override
    public String[] processStringList() {
        return new String[0];
    }

    @Override
    public int compareTo(Rule o) {
        return this.RuleText.compareTo(o.getRuleText());
    }
}
