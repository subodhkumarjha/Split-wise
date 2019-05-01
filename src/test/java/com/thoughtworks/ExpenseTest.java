package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ExpenseTest {
    private Friend firstUserName;
    private Friend secondUserName;
    private Friend thirdUserName;
    private Friend fourthUserName;
    private List<Friend> firstGroupList;
    private List<Friend> secondGroupList;
    private List<Friend> thirdGroupList;
    private List<Friend> fourthGroupList;

    @BeforeEach
    void setup() {
        firstUserName = new Friend("A", 0);
        secondUserName = new Friend("B", 0);
        thirdUserName = new Friend("C", 0);
        fourthUserName = new Friend("D", 0);
        firstGroupList = new ArrayList<>();
        firstGroupList.add(firstUserName);
        firstGroupList.add(secondUserName);
        firstGroupList.add(thirdUserName);
        firstGroupList.add(fourthUserName);

        secondGroupList = new ArrayList<>();
        secondGroupList.add(thirdUserName);
        secondGroupList.add(fourthUserName);

        thirdGroupList = new ArrayList<>();
        thirdGroupList.add(firstUserName);
        thirdGroupList.add(secondUserName);

        fourthGroupList = new ArrayList<>();
        fourthGroupList.add(firstUserName);
        fourthGroupList.add(secondUserName);
    }


    @Test
    @DisplayName("C gives 25  to others after calculation of even split for snacks")
    void afterCalculationOfSnacksExpenseCGives25toOthers() {
        Expense firstExpense = new Expense(firstUserName, 100, firstGroupList);

        firstExpense.evenSplit(firstExpense, firstUserName, firstGroupList);

        Assertions.assertEquals(-25, thirdUserName.requiredPersonAmount());
    }

    @Test
    @DisplayName("B should not get 75 after settling up the Amount of snacks with even Splits")
    void settleUpAmountAfterCalculationOfExpensesBShouldNotGets75FromOthersWithEvenSplits() {
        Expense firstExpense = new Expense(secondUserName, 120, firstGroupList);
        firstExpense.evenSplit(firstExpense, secondUserName, firstGroupList);

        Assertions.assertNotEquals(75, secondUserName.requiredPersonAmount());
    }


    @Test
    @DisplayName("B gets 75 after settling up the Amount of snacks with even Splits")
    void settleUpAmountAfterCalculationOfExpensesBGets75FromOthersWithEvenSplits() {
        Expense firstExpense = new Expense(secondUserName, 100, firstGroupList);
        firstExpense.evenSplit(firstExpense, secondUserName, firstGroupList);

        Assertions.assertEquals(75, secondUserName.requiredPersonAmount());
    }


}
