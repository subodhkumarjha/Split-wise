package com.thoughtworks;

class Transaction {
    User payer;
    User consumer;
    double amount;

    Transaction (User maximumDebtAmountUser, User maximumTakeableAmountUser, Double minimumValue) {
        this.payer = maximumDebtAmountUser;
        this.consumer = maximumTakeableAmountUser;
        this.amount = minimumValue;
    }
}
