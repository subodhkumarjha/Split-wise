package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class FriendTest {
    private Friend firstUserName;
    private Friend secondUserName;
    private Friend thirdUserName;
    private Friend fourthUserName;
    private List<Friend> firstUserList;
    private List<Friend> secondUserList;

    @BeforeEach
    void setup() {
        firstUserName = new Friend("A", 0);
        secondUserName = new Friend("B", 0);
        thirdUserName = new Friend("C", 0);
        fourthUserName = new Friend("D", 0);
        firstUserList = new ArrayList<>();
        firstUserList.add(firstUserName);
        firstUserList.add(secondUserName);
        firstUserList.add(fourthUserName);

        secondUserList = new ArrayList<>();
        secondUserList.add(firstUserName);
        secondUserList.add(secondUserName);
        secondUserList.add(fourthUserName);
        secondUserList.add(thirdUserName);
    }

    @Test
    @DisplayName("Checking the maximum debt amount sponsorName")
    void checkingTheMaximumDebtAmountCalculationUser() {
        firstUserName = new Friend("A", 25);
        secondUserName = new Friend("B", 30);
        thirdUserName = new Friend("C", -20);
        fourthUserName = new Friend("D", -35);

        secondUserList = new ArrayList<>();
        secondUserList.add(firstUserName);
        secondUserList.add(secondUserName);
        secondUserList.add(fourthUserName);
        secondUserList.add(thirdUserName);

        Assertions.assertEquals(fourthUserName.requiredPersonAmount(), firstUserName.maximumDebtAmountOfUser(secondUserList).requiredPersonAmount());
    }
}
