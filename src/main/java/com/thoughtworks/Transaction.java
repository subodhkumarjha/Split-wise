package com.thoughtworks;

class Transaction {
    User payer;
    User payee;
    double amount;

    Transaction (User maximumDebtAmountUser, User maximumTakeableAmountUser, Double minimumValue) {
        this.payer = maximumDebtAmountUser;
        this.payee = maximumTakeableAmountUser;
        this.amount = minimumValue;
    }
}
