package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

class Transactions {
    List<Transaction> transactionList;

    Transactions () {
        this.transactionList = new ArrayList<> ();
    }

    void addTransaction (Transaction transaction) {
        transactionList.add (transaction);
    }

    void displayTransactions () {
        for (Transaction transaction : transactionList) {
            System.out.println ("Payer : " + transaction.payer.getName () + " " + transaction.amount + " Consumer : "
                    + transaction.payee.getName ());
        }
    }

}
