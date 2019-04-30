package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GroupTest {
    private Friend firstFriendName;
    private Friend secondFriendName;
    private Friend thirdFriendName;
    private Friend fourthFriendName;
    private List<Friend> firstFriendList;
    private List<Friend> secondFriendList;

    @BeforeEach
    void setup() {
        firstFriendName = new Friend("A", 0);
        secondFriendName = new Friend("B", 0);
        thirdFriendName = new Friend("C", 0);
        fourthFriendName = new Friend("D", 0);
        firstFriendList = new ArrayList<>();
        firstFriendList.add(firstFriendName);
        firstFriendList.add(secondFriendName);
        firstFriendList.add(fourthFriendName);

        secondFriendList = new ArrayList<>();
        secondFriendList.add(firstFriendName);
        secondFriendList.add(secondFriendName);
        secondFriendList.add(fourthFriendName);
        secondFriendList.add(thirdFriendName);
    }

    @Test
    @DisplayName("Checking the Settling amount for two sponsorName by some default amount")
    void checkingAmountOfTwoUserBySomeDefaultAmount() {
        List<Expense> expensedsList = new ArrayList<>();
        Expense firstExpense = new Expense(firstFriendName, 100, firstFriendList);
        Expense secondExpense = new Expense(secondFriendName, 0, secondFriendList);
        Expense thirdExpense = new Expense(fourthFriendName, 0, firstFriendList);
        expensedsList.add(firstExpense);
        expensedsList.add(secondExpense);
        expensedsList.add(thirdExpense);
        firstFriendName = new Friend("A", 25);
        secondFriendName = new Friend("B", -10);
        thirdFriendName = new Friend("C", 0);
        fourthFriendName = new Friend("D", 0);
        secondFriendList = new ArrayList<>();
        secondFriendList.add(firstFriendName);
        secondFriendList.add(secondFriendName);
        secondFriendList.add(fourthFriendName);
        secondFriendList.add(thirdFriendName);
        Group group = new Group();

        group.settlingUpInitiation(expensedsList,secondFriendList);

        Assertions.assertEquals(0, firstFriendName.requiredPersonAmount());
    }
}
