package com.thoughtworks;

import java.util.List;

class Group {
    List<Expense> expensesList;
    Transactions transactions;

    Group (List<Expense> expensesList) {
        this.expensesList = expensesList;
        this.transactions = new Transactions ();
    }

    void settlingUpInitiation (List<Expense> expensesList, List<User> allUserList) {
        for (Expense eachExpense : expensesList) {
            eachExpense.evenSplit (eachExpense, eachExpense.sponsorName, eachExpense.personList);
        }
        settleUpAmountOfEachUser (allUserList);
    }

    private void settleUpAmountOfEachUser (List<User> allUserList) {
        for (User user : allUserList) {
            User maximumDebtAmountUser = user.maximumDebtAmountOfUser (allUserList);
            User maximumTakeableAmountUser = user.maximumAmountOfThePerson (allUserList);
            if (isExpenseSettled (maximumDebtAmountUser.requiredPersonAmount (), maximumTakeableAmountUser.requiredPersonAmount ())) {
                return;
            }
            Double minimumValue = findMinimumValue (-maximumDebtAmountUser.requiredPersonAmount (), maximumTakeableAmountUser.requiredPersonAmount ());
            Transaction transaction = new Transaction (maximumDebtAmountUser, maximumTakeableAmountUser, minimumValue);
            transactions.addTransaction (transaction);
            settlingUpAmountOfTwoUser (maximumDebtAmountUser, maximumTakeableAmountUser, minimumValue);
        }
    }

    private void settlingUpAmountOfTwoUser (User maximumDebtAmountUser, User maximumTakeableAmountUser, Double maximumValue) {
        maximumDebtAmountUser.updateAmount (maximumValue);
        maximumTakeableAmountUser.updateAmount (-maximumValue);

        //maximumDebtAmountUser.amount += maximumValue;
        //maximumTakeableAmountUser.amount -= maximumValue;
    }

    private Double findMinimumValue (Double firstAmount, Double secondAmount) {
        if (firstAmount > secondAmount) {
            return secondAmount;
        }
        return firstAmount;
    }

    private boolean isExpenseSettled (Double maximumDebtAmount, Double maximumTakeableAmount) {
        return maximumDebtAmount == 0 && maximumTakeableAmount == 0;
    }
}
