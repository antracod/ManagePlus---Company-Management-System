package com.teodor.tests;

import com.teodor.models.Payment;
import com.teodor.models.Rule;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ClassService {
    private List<Rule> ruleList = new ArrayList<Rule>();
    private Payment tmpPayment = new Payment();

    public ClassService(){

    };

    public void addRules(Rule tmp)
    {
        this.ruleList.add(tmp);
    }

    public List<Rule> getRules()
    {
        return this.ruleList;
    }

    public List<Rule> getSortedRules()
    {
        List<Rule> toSortRuleList = this.ruleList;
        java.util.Collections.sort(toSortRuleList);
        return toSortRuleList;
    }

    public List<Rule> getReversedSortedRules()
    {
        List<Rule> toSortRuleList = this.ruleList;
        java.util.Collections.sort(toSortRuleList);
        Collections.reverse(toSortRuleList);
        return toSortRuleList;
    }

    public void addTmpPayment(Payment tmp) { System.out.println("Tmp payment added"); this.tmpPayment = tmp; }

    public void addTmpPaymentValue(int value) {  System.out.println("Tmp payment Value Changed"); this.tmpPayment.setPaymentValue(value); }

    public void addTmpPaymentDate(String value) {this.tmpPayment.setPaymentDate(value);}

    public void addTmpPaymentReceiver(String value) { this.tmpPayment.setPaymentReceiver(value);}

    public int getTmppaymentValue() { return this.tmpPayment.getPaymentValue(); }

    public String getTmpPaymentReceiver() { return this.tmpPayment.getPaymentReceiver(); }

    public String getTmpPaymentDate() { return this.tmpPayment.getPaymentDate(); }









}
