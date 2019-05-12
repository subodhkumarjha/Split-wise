package com.thoughtworks;

import java.util.List;

class Group {
    List<Expense> expensesList;
//    Transactions transactions;

    Group (List<Expense> expensesList) {
        this.expensesList = expensesList;
    }

    Transactions settlingUpInitiation (List<Expense> expensesList, List<User> allUserList) {
        for (Expense eachExpense : expensesList) {
            eachExpense.evenSplit ();
        }
      return  settleUpAmountOfEachUser (allUserList);
    }

    private Transactions settleUpAmountOfEachUser (List<User> allUserList) {
        Transactions transactions = new Transactions ();
        for (User user : allUserList) {
            User maximumDebtAmountUser = user.maximumDebtAmountOfUser (allUserList);
            User maximumTakeableAmountUser = user.maximumAmountOfThePerson (allUserList);
            if (isExpenseSettled (maximumDebtAmountUser.requiredPersonAmount (), maximumTakeableAmountUser.requiredPersonAmount ())) {
                return transactions;
            }
            Double minimumValue = findMinimumValue (-maximumDebtAmountUser.requiredPersonAmount (), maximumTakeableAmountUser.requiredPersonAmount ());
            Transaction transaction = new Transaction (maximumDebtAmountUser, maximumTakeableAmountUser, minimumValue);
            transactions.addTransaction (transaction);
            settlingUpAmountOfTwoUser (maximumDebtAmountUser, maximumTakeableAmountUser, minimumValue);
        }
        return transactions;
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
