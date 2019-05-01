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
        for (Friend user : allFriendList) {
            Friend maximumDebtAmountUser = user.maximumDebtAmountOfUser(allFriendList);
            Friend maximumTakeableAmountUser = user.maximumAmountOfThePerson(allFriendList);
            if (isExpenseSettled(maximumDebtAmountUser.requiredPersonAmount(), maximumTakeableAmountUser.requiredPersonAmount())) {
                return;
            }
            Double minimumValue = findMinimumValue(-maximumDebtAmountUser.requiredPersonAmount(), maximumTakeableAmountUser.requiredPersonAmount());
            settlingUpAmountOfTwoUser(maximumDebtAmountUser, maximumTakeableAmountUser, minimumValue);
        }
    }

    private void settlingUpAmountOfTwoUser(Friend maximumDebtAmountUser, Friend maximumTakeableAmountUser, Double maximumValue) {
    }

    private Double findMinimumValue(int i, int requiredPersonAmount) {
        return  0.0;
    }

    private boolean isExpenseSettled(int requiredPersonAmount, int requiredPersonAmount1) {
        return true;
    }
}
