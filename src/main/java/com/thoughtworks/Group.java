package com.thoughtworks;

import java.util.List;

public class Group {

    public void settlingUpInitiation(List<Expense> expensesList, List<Friend> allFriendList) {
        for (Expense eachExpense : expensesList) {
                eachExpense.evenSplit(eachExpense, eachExpense.sponsorName, eachExpense.personList);
        }
        settleUpAmountOfEachUser(allFriendList);
    }

    private void settleUpAmountOfEachUser(List<Friend> allFriendList) {
    }
}
