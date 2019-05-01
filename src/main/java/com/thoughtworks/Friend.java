package com.thoughtworks;

import java.util.List;

class Friend {
    private String name;
    double amount;

    Friend(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    int requiredPersonAmount() {
        return 0;
    }

    Friend maximumDebtAmountOfUser(List<Friend> secondUserList) {
        return null;
    }

    Friend maximumAmountOfThePerson(List<Friend> allFriendList) {
        return null;
    }
}
