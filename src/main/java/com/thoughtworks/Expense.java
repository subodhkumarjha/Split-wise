package com.thoughtworks;

import java.util.List;

class Expense {
    User sponsorName;
    List<User> personList;
    final int totalAmountPaid;

    Expense (User sponsorName, int amountPaid, List<User> personList) {
        this.sponsorName = sponsorName;
        this.totalAmountPaid = amountPaid;
        this.personList = personList;
    }

    void evenSplit (Expense eachExpense, User sponsorName, List<User> personList) {
        sponsorName.updateAmount (eachExpense.totalAmountPaid);
        Double fractionShare = (double) 1 / personList.size ();
        for (User groupMember : personList) {
            groupMember.updateAmount (-fractionShare * this.totalAmountPaid);
        }
    }
}
