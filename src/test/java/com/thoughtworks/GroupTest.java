package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GroupTest {
    //TODO: Naming of variable has to change

    private User firstUserName;
    private User secondUserName;
    private User thirdUserName;
    private User fourthUserName;
    private List<User> firstUserList;
    private List<User> secondUserList;

    @BeforeEach
    void setup () {
        firstUserName = new User ("A", 0);
        secondUserName = new User ("B", 0);
        thirdUserName = new User ("C", 0);
        fourthUserName = new User ("D", 0);
        firstUserList = new ArrayList<> ();
        firstUserList.add (firstUserName);
        firstUserList.add (secondUserName);
        firstUserList.add (fourthUserName);

        secondUserList = new ArrayList<> ();
        secondUserList.add (firstUserName);
        secondUserList.add (secondUserName);
        secondUserList.add (fourthUserName);
        secondUserList.add (thirdUserName);
    }

    @Test
    @DisplayName ("Checking the Settling amount for two sponsorName by some default amount")
    void checkingAmountOfTwoUserBySomeDefaultAmount () {
        List<Expense> expensedsList = new ArrayList<> ();
        Expense firstExpense = new Expense (firstUserName, 100, secondUserList);
        Expense secondExpense = new Expense (secondUserName, 0, secondUserList);
        Expense thirdExpense = new Expense (fourthUserName, 0, firstUserList);
        expensedsList.add (firstExpense);
        expensedsList.add (secondExpense);
        expensedsList.add (thirdExpense);
        firstUserName = new User ("A", 0);
        secondUserName = new User ("B", 0);
        thirdUserName = new User ("C", 0);
        fourthUserName = new User ("D", 0);
        secondUserList = new ArrayList<> ();
        secondUserList.add (firstUserName);
        secondUserList.add (secondUserName);
        secondUserList.add (fourthUserName);
        secondUserList.add (thirdUserName);
        Group group = new Group (expensedsList);

        group.settlingUpInitiation (expensedsList, secondUserList);

        Assertions.assertEquals (0, firstUserName.requiredPersonAmount ());
    }
}
