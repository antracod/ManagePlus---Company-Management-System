package com.teodor.tests;

import com.teodor.models.Payment;
import com.teodor.models.Rule;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ClassServiceTests {
    private List<Rule> ruleList;
    private Payment tmpPayment = new Payment();

    public ClassServiceTests(){};

    public void addRules(Rule tmp)
    {
        ruleList.add(tmp);
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

    public void addTmpPayment(Payment tmp) { this.tmpPayment = tmp; }

    public void addTmpPayment(int value) { this.tmpPayment.setPaymentValue(value); }







}
