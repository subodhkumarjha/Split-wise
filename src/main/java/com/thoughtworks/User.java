package com.thoughtworks;

import java.util.List;

class User {
    private String name;
    double amount;

    User (String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    String getName () {
        return name;
    }

    Double requiredPersonAmount () {
        return amount;
    }

    User maximumDebtAmountOfUser (List<User> personList) {
        User maxUserDebt = personList.get (0);
        for (User eachGroupMember : personList) {
            maxUserDebt = maximumDebtAmountCalculationForTwoUser (eachGroupMember, maxUserDebt);
        }
        return maxUserDebt;
    }

    User maximumAmountOfThePerson (List<User> personList) {
        User maxUserDebt = personList.get (0);
        for (User eachGroupMember : personList) {
            maxUserDebt = returnMaximumPersonAmount (eachGroupMember, maxUserDebt);
        }
        return maxUserDebt;
    }

    private User maximumDebtAmountCalculationForTwoUser (User user, User maxUserDebt) {
        if (user.amount < maxUserDebt.amount) {
            maxUserDebt = user;
        }
        return maxUserDebt;
    }

    private User returnMaximumPersonAmount (User user, User maxUserDebt) {
        if (user.amount > maxUserDebt.amount) {
            maxUserDebt = user;
        }
        return maxUserDebt;
    }

    void updateAmount (double amountPaid) {
        this.amount += amountPaid;
    }
}
