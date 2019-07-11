package com.assignment.transactionmanagment.transaction;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.assignment.transactionmanagment.constants.TransactionConstants;
import com.assignment.transactionmanagment.transactionReader.TransactionReader;
import com.assignment.transactionmanagment.util.TransactionUtil;

/**
 * TransactionProcessor
 * 
 * Filters and Processes the transaction.
 * 
 */
public class TransactionProcessor {

	private List<TransactionRecord> transactions = null;
	private String accountNumber = null;
	private Date _from = null;
	private Date _to = null;
	private Float relativeBalance =  null;
	private Integer transProcessed = null;
	
	public TransactionProcessor(String accountNumber, String _from, String _to) throws ParseException  {
		TransactionReader transReader = new TransactionReader();
		transactions = transReader.readTransactionData();
		this.accountNumber = accountNumber;
		this._from = TransactionUtil.convertDate(_from);
		this._to = TransactionUtil.convertDate(_to);
		this.relativeBalance = new Float(0.0f);
		this.transProcessed = new Integer(0);
	}
	
	/** Method Name : processTransactions()
	 * Description : Filters and Processes Transaction on the data.
	 */
	public void processTransactions() throws ParseException {

		List<TransactionRecord> filteredTransactions = filterTransaction();
		calculateRelativeBalance(filteredTransactions);
		System.out.println("Relative balance for the period is: " +relativeBalance);
		System.out.println("Number of transactions included is: "+transProcessed);
	}
	
	/** Method Name : calculateRelativeBalance()
	 * Description : Calculates Relative Balance and No. of Transaction Processed.
	 */
	private void calculateRelativeBalance(List<TransactionRecord> transactions) {

		for (TransactionRecord transactionRecord : transactions) {
			if(transactionRecord.getTransactionType().equals(TransactionConstants.PAYMENT)) {
				relativeBalance -= transactionRecord.getAmount();
				transProcessed++;
 
			}else if(transactionRecord.getTransactionType().equals(TransactionConstants.REVERSAL)) {
				relativeBalance += transactionRecord.getAmount();
				transProcessed--;
			}
		}
	}
	
	/** Method Name : filterTransaction()
	 * Description : Business logic to filter the transaction.
	 */
	private List<TransactionRecord> filterTransaction() {

		List<TransactionRecord> filteredTransactions = transactions.stream()
				.filter(transaction -> {
					if ( accountNumber.equals(transaction.getFromAccountId().trim()) &&
							   transaction.getTransactionType().trim().equals(TransactionConstants.REVERSAL)
							) {
						return true;
					}
                    if ( accountNumber.equals(transaction.getFromAccountId().trim()) &&
							  ( transaction.getCreatedAt().after(_from) && transaction.getCreatedAt().before(_to) )
							) {
                        return true;
                    } 
                    return false;
                })
				.collect(Collectors.toList());
		return filteredTransactions;
	}

	public Float getRelativeBalance() {
		return relativeBalance;
	}

	public void setRelativeBalance(Float relativeBalance) {
		this.relativeBalance = relativeBalance;
	}

	public Integer getTransProcessed() {
		return transProcessed;
	}

	public void setTransProcessed(Integer transProcessed) {
		this.transProcessed = transProcessed;
	}
	
	
}
