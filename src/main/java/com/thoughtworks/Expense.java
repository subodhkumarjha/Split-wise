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

    void evenSplit () {
        Double fractionShare = (double) 1 / (this.personList.size () + 1);
        this.sponsorName.updateAmount (this.totalAmountPaid * (1.0 - fractionShare));
        for (User groupMember : this.personList) {
            groupMember.updateAmount (-fractionShare * this.totalAmountPaid);
        }
    }
}
