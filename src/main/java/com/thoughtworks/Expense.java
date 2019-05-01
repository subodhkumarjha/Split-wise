package com.thoughtworks;

import java.util.List;

class Expense {
    Friend sponsorName;
    List<Friend> personList;
    final int totalAmountPaid;

    Expense(Friend fourthFriendName, int i, List<Friend> firstFriendList) {
        totalAmountPaid = 0;
    }

    void evenSplit(Expense eachExpense, Friend sponsorName, List<Friend> personList) {
    }
}
