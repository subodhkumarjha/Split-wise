package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TransactionsTest {
    private User firstUserName;
    private User secondUserName;
    private User thirdUserName;
    private User fourthUserName;

    @BeforeEach
    void setup () {
        firstUserName = new User ("A", 0);
        secondUserName = new User ("B", 0);
        thirdUserName = new User ("C", 0);
        fourthUserName = new User ("D", 0);
    }

    @Test
    @DisplayName ("Checking the size of the transaction")
    void checkTheSizeofTransactionList () {
        Transaction firstTransaction = new Transaction (firstUserName, secondUserName, 100.0);
        Transaction secondTransaction = new Transaction (firstUserName, secondUserName, 100.0);
        Transaction thirdTransaction = new Transaction (firstUserName, secondUserName, 100.0);
        Transaction fourthTransaction = new Transaction (firstUserName, secondUserName, 100.0);
        Transactions transactions = new Transactions ();
        transactions.addTransaction (firstTransaction);
        transactions.addTransaction (secondTransaction);
        transactions.addTransaction (thirdTransaction);
        transactions.addTransaction (fourthTransaction);

        Assertions.assertEquals (4, transactions.transactionList.size ());
    }
}
