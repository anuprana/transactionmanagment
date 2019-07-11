package com.assignment.transactionmanagment;

import java.text.ParseException;

import com.assignment.transactionmanagment.transaction.TransactionProcessor;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test Class.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    
    /** TestCaseName : testDefaultTestCase()
     * Description  : Run the test on the sample data provided in the document.
     * */
    public void testDefaultTestCase()
    {
    	String accountNumber = "ACC334455";
        String from = "20/10/2018 12:00:00";
        String to = "20/10/2018 19:00:00";
        Float relativeBalance = -25.0f;
        Integer transProcessed = 1;
    	try {
			TransactionProcessor processor = new  TransactionProcessor(accountNumber, from, to);
			processor.processTransactions();
			assertEquals(relativeBalance, processor.getRelativeBalance());
			assertEquals(transProcessed, processor.getTransProcessed());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /** TestCaseName : testPaymentTransactions()
     * Description  : Run the test  on the Payment Transactions.
     * */
    public void testPaymentTransactions() {
    	String accountNumber = "ACC786294";
        String from = "22/10/2018 08:00:00";
        String to = "22/10/2018 17:00:00";
        Float relativeBalance = -42.0f;
        Integer transProcessed = 2;
    	try {
			TransactionProcessor processor = new  TransactionProcessor(accountNumber, from, to);
			processor.processTransactions();
			assertEquals( relativeBalance, processor.getRelativeBalance());
			assertEquals(transProcessed, processor.getTransProcessed());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /** TestCaseName : testPaymentTransactions()
     * Description  : Run the test on the Payment and Reversal Transactions.
     * */
    public void testReversalTransactions() {
    	String accountNumber = "ACC643295";
        String from = "23/10/2018 10:00:00";
        String to = "23/10/2018 17:00:00";
        Float relativeBalance = 0.0f;
        Integer transProcessed = 0;
    	try {
			TransactionProcessor processor = new  TransactionProcessor(accountNumber, from, to);
			processor.processTransactions();
			assertEquals( relativeBalance, processor.getRelativeBalance());
			assertEquals(transProcessed, processor.getTransProcessed());
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
