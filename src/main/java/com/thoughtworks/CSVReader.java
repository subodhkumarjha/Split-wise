package com.thoughtworks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CSVReader implements Reader {
    @Override
    public String read (Transactions transactions) {
        try (PrintWriter writer = new PrintWriter(new File ("test.csv"))) {

            StringBuilder sb = new StringBuilder();
            sb.append("Payer");
            sb.append(',');
            sb.append("Amount");
            sb.append(',');
            sb.append("Payee");
            sb.append('\n');

            for (Transaction transaction : transactions.transactionList) {
                sb.append (transaction.payer.getName ());
                sb.append (',');
                sb.append (transaction.amount);
                sb.append (',');
                sb.append (transaction.consumer.getName ());
                sb.append ('\n');
            }

            writer.write(sb.toString());

            System.out.println("done!");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return "";
    }
}
