package com.assignment.transactionmanagment;

import java.text.ParseException;

import com.assignment.transactionmanagment.transaction.TransactionProcessor;

/**
 * App
 * Contains the main method to run the Transaction Processor.
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException
    {
        String accountNumber = "ACC334455";
        String from = "20/10/2018 12:00:00";
        String to = "20/10/2018 19:00:00";
        TransactionProcessor processor = new  TransactionProcessor(accountNumber,from,to);
        processor.processTransactions();
    }
}
