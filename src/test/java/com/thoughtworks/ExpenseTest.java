package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ExpenseTest {
    //TODO: Naming of variable has to change
    private User firstUserName;
    private User secondUserName;
    private User thirdUserName;
    private User fourthUserName;
    private List<User> firstGroupList;
    private List<User> secondGroupList;
    private List<User> thirdGroupList;
    private List<User> fourthGroupList;

    @BeforeEach
    void setup () {
        firstUserName = new User ("A", 0);
        secondUserName = new User ("B", 0);
        thirdUserName = new User ("C", 0);
        fourthUserName = new User ("D", 0);


        secondGroupList = new ArrayList<> ();
        secondGroupList.add (thirdUserName);

        thirdGroupList = new ArrayList<> ();
        thirdGroupList.add (firstUserName);
        thirdGroupList.add (secondUserName);

        fourthGroupList = new ArrayList<> ();
        fourthGroupList.add (firstUserName);
        fourthGroupList.add (secondUserName);
    }

    @Test
    @DisplayName ("B gets 0 after calculation of snacks ,taxi , hotel and bus expenses")
    void afterCalculationOfExpensesBGets0FromOthers () {
        List<Expense> allExpensedsList = new ArrayList<> ();
        firstGroupList = new ArrayList<> ();
        firstGroupList.add (secondUserName);
        firstGroupList.add (thirdUserName);
        firstGroupList.add (fourthUserName);
        Expense firstExpense = new Expense (firstUserName, 100, firstGroupList);

        Expense secondExpense = new Expense (secondUserName, 10, secondGroupList);
        firstGroupList = new ArrayList<> ();
        firstGroupList.add (firstUserName);
        firstGroupList.add (secondUserName);
        firstGroupList.add (thirdUserName);
        Expense thirdExpense = new Expense (fourthUserName, 20, firstGroupList);

        allExpensedsList.add (firstExpense);
        allExpensedsList.add (secondExpense);
        allExpensedsList.add (thirdExpense);
        Group group = new Group (allExpensedsList);

        group.settlingUpInitiation (allExpensedsList, firstGroupList);

        Assertions.assertEquals (0, secondUserName.requiredPersonAmount ());
    }

    @Test
    @DisplayName ("C gives 25  to others after calculation of even split for snacks")
    void afterCalculationOfSnacksExpenseCGives25toOthers () {
        firstGroupList = new ArrayList<> ();
        firstGroupList.add (secondUserName);
        firstGroupList.add (thirdUserName);
        firstGroupList.add (fourthUserName);
        Expense firstExpense = new Expense (firstUserName, 100, firstGroupList);

        firstExpense.evenSplit ();

        Assertions.assertEquals (-25, thirdUserName.requiredPersonAmount ());
    }

    @Test
    @DisplayName ("B should not get 75 after settling up the Amount of snacks with even Splits")
    void settleUpAmountAfterCalculationOfExpensesBShouldNotGets75FromOthersWithEvenSplits () {
        firstGroupList = new ArrayList<> ();
        firstGroupList.add (firstUserName);
        firstGroupList.add (thirdUserName);
        firstGroupList.add (fourthUserName);
        Expense firstExpense = new Expense (secondUserName, 120, firstGroupList);
        firstExpense.evenSplit ();

        Assertions.assertNotEquals (75, secondUserName.requiredPersonAmount ());
    }


    @Test
    @DisplayName ("B gets 75 after settling up the Amount of snacks with even Splits")
    void settleUpAmountAfterCalculationOfExpensesBGets75FromOthersWithEvenSplits () {
        firstGroupList = new ArrayList<> ();
        firstGroupList.add (firstUserName);
        firstGroupList.add (thirdUserName);
        firstGroupList.add (fourthUserName);
        Expense firstExpense = new Expense (secondUserName, 100, firstGroupList);
        firstExpense.evenSplit ();

        Assertions.assertEquals (75, secondUserName.requiredPersonAmount ());
    }


}
