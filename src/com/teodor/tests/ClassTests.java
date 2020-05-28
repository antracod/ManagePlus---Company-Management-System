package com.teodor.tests;

import com.teodor.models.Payment;
import com.teodor.models.Rule;

import java.util.List;

public class ClassTests {

    public ClassTests(){
        ClassService myService = new ClassService();

        Rule rule1 = new Rule(1,"Fara cod redundant");
        Rule rule2 = new Rule(2,"Fara cod autodocumentat");
        myService.addRules(rule1);
        myService.addRules(rule2);
        List<Rule> testRuleList = myService.getRules();
        List<Rule> testSortedRuleList = myService.getSortedRules();
        List<Rule> testReversedRuleList = myService.getReversedSortedRules();

        Payment tmpPayment = new Payment(4, "Andrei" , 1000 , "20.12.2020");



    }
}
