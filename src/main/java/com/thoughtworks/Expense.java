package com.thoughtworks;

import java.util.List;

public class Expense {
    Friend sponsorName;
    List<Friend> personList;
    final int totalAmountPaid;

    public Expense(Friend fourthFriendName, int i, List<Friend> firstFriendList) {
        totalAmountPaid = 0;
    }

    public void evenSplit(Expense eachExpense, Friend sponsorName, List<Friend> personList) {
    }
}
