package com.thoughtworks;

public class DataBaseReader implements Reader {
    @Override
    public String read(Transactions transactions) {
        for (Transaction transaction : transactions.transactionList) {
            System.out.println ("Payer : " + transaction.payer.getName () + " " + transaction.amount + " Consumer : "
                    + transaction.payee.getName ());
        }
        return "Reading database";
    }
}
