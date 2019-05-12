package com.thoughtworks;

import java.util.ArrayList;
import java.util.List;

class SplitWise {
    public static void main (String args[]) {
        User firstUserName;
        User secondUserName;
        User thirdUserName;
        User fourthUserName;
        List<User> firstUserList;
        List<User> secondUserList;
        List<User> thirdUserList;
        List<User> fourthUserList;
        List<User> allUserList;


        firstUserName = new User ("A", 0);
        secondUserName = new User ("B", 0);
        thirdUserName = new User ("C", 0);
        fourthUserName = new User ("D", 0);
        firstUserList = new ArrayList<> ();
        //firstUserList.add (firstUserName);
        firstUserList.add (secondUserName);
        firstUserList.add (thirdUserName);
        firstUserList.add (fourthUserName);


        allUserList = new ArrayList<> ();
        allUserList.add (firstUserName);
        allUserList.add (secondUserName);
        allUserList.add (thirdUserName);
        allUserList.add (fourthUserName);

        secondUserList = new ArrayList<> ();
        //secondUserList.add (thirdUserName);
        secondUserList.add (fourthUserName);

        thirdUserList = new ArrayList<> ();
        thirdUserList.add (firstUserName);
        thirdUserList.add (secondUserName);

        fourthUserList = new ArrayList<> ();
        //fourthUserList.add (firstUserName);
        fourthUserList.add (secondUserName);

        List<Expense> expensesList = new ArrayList<> ();

        Expense firstExpense = new Expense (firstUserName, 100, firstUserList);
        Expense secondExpense = new Expense (secondUserName, 300, secondUserList);
        Expense thirdExpense = new Expense (fourthUserName, 300, fourthUserList);
        Expense fourthExpense = new Expense (firstUserName, 100, fourthUserList);

        expensesList.add (firstExpense);
        expensesList.add (secondExpense);
        expensesList.add (thirdExpense);
        expensesList.add (fourthExpense);

        Group group = new Group (expensesList);

        Transactions transactions = group.settlingUpInitiation (expensesList, allUserList);
        System.out.println(ReaderFactory.getReader("CSV").read(transactions));
        System.out.println(ReaderFactory.getReader("DB").read(transactions));
        System.out.println(ReaderFactory.getReader("XML").read(transactions));

        // transactions.displayTransactions ();
    }
}
