package com.thoughtworks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class UserTest {
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
    @DisplayName ("Checking the maximum debt amount sponsorName")
    void checkingTheMaximumDebtAmountCalculationUser () {
        firstUserName = new User ("A", 25);
        secondUserName = new User ("B", 30);
        thirdUserName = new User ("C", -20);
        fourthUserName = new User ("D", -35);

        secondUserList = new ArrayList<> ();
        secondUserList.add (firstUserName);
        secondUserList.add (secondUserName);
        secondUserList.add (fourthUserName);
        secondUserList.add (thirdUserName);

        Assertions.assertEquals (fourthUserName.requiredPersonAmount (), firstUserName.maximumDebtAmountOfUser (secondUserList).requiredPersonAmount ());
    }

    @Test
    @DisplayName ("Checking the sponsorName who receives maximum amount")
    void checkingTheUserWhoReceivesMaximumAmount () {
        firstUserName = new User ("A", 30);
        secondUserName = new User ("B", 30);
        thirdUserName = new User ("C", -20);
        fourthUserName = new User ("D", -35);

        secondUserList = new ArrayList<> ();
        secondUserList.add (firstUserName);
        secondUserList.add (secondUserName);
        secondUserList.add (fourthUserName);
        secondUserList.add (thirdUserName);

        Assertions.assertEquals (secondUserName.requiredPersonAmount (), secondUserName.maximumAmountOfThePerson (secondUserList).requiredPersonAmount ());

        Assertions.assertEquals (30, firstUserName.requiredPersonAmount ());
    }

    @Test
    @DisplayName ("Return the user who gives maximum amount")
    void checkingUserWhoGivesMaximumAmount () {
        firstUserName = new User ("A", 30);
        secondUserName = new User ("B", 30);
        thirdUserName = new User ("C", -20);
        fourthUserName = new User ("D", -35);
        secondUserList = new ArrayList<> ();
        secondUserList.add (firstUserName);
        secondUserList.add (secondUserName);
        secondUserList.add (fourthUserName);
        secondUserList.add (thirdUserName);

        Assertions.assertEquals (-35, firstUserName.maximumDebtAmountOfUser (secondUserList).requiredPersonAmount ());
    }

    @Test
    @DisplayName ("Should not Return the user who gives maximum amount")
    void shouldNotReturnUserWhoGivesMaximumAmount () {
        firstUserName = new User ("A", 30);
        secondUserName = new User ("B", 30);
        thirdUserName = new User ("C", -20);
        fourthUserName = new User ("D", -35);
        secondUserList = new ArrayList<> ();
        secondUserList.add (firstUserName);
        secondUserList.add (secondUserName);
        secondUserList.add (fourthUserName);
        secondUserList.add (thirdUserName);

        Assertions.assertNotEquals (-30, firstUserName.maximumDebtAmountOfUser (secondUserList).requiredPersonAmount ());
    }

    @Test
    @DisplayName ("Return the user who receives maximum amount")
    void checkingUserWhoReceivesMaximumAmount () {
        firstUserName = new User ("A", 30);
        secondUserName = new User ("B", 30);
        thirdUserName = new User ("C", -20);
        fourthUserName = new User ("D", -35);
        secondUserList = new ArrayList<> ();
        secondUserList.add (firstUserName);
        secondUserList.add (secondUserName);
        secondUserList.add (fourthUserName);
        secondUserList.add (thirdUserName);

        Assertions.assertEquals (30, firstUserName.maximumAmountOfThePerson (secondUserList).requiredPersonAmount ());
    }

    @Test
    @DisplayName ("Should not Return the user who receives maximum amount")
    void shouldNotReturnUserWhoReceivesMaximumAmount () {
        firstUserName = new User ("A", 30);
        secondUserName = new User ("B", 30);
        thirdUserName = new User ("C", -20);
        fourthUserName = new User ("D", -35);
        secondUserList = new ArrayList<> ();
        secondUserList.add (firstUserName);
        secondUserList.add (secondUserName);
        secondUserList.add (fourthUserName);
        secondUserList.add (thirdUserName);

        Assertions.assertNotEquals (-20, firstUserName.maximumAmountOfThePerson (secondUserList).requiredPersonAmount ());
    }
}
