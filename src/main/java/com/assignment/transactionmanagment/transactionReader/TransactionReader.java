package com.assignment.transactionmanagment.transactionReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.assignment.transactionmanagment.config.ConfigProperties;
import com.assignment.transactionmanagment.constants.TransactionConstants;
import com.assignment.transactionmanagment.transaction.TransactionRecord;
import com.assignment.transactionmanagment.util.TransactionUtil;


/**
 * TransactionReader
 * 
 * Reads the transaction from the csv file and converts into List<TransactionRecord>
 */
public class TransactionReader {
	
	public TransactionReader() {
		
	}

	/** Method Name : readTransactionData()
	 * Description : Reads the Transactions from the CSV file and returns the list of object.
	 * Return : List<TransactionRecord>
	 */
	public List<TransactionRecord> readTransactionData() {
		List<TransactionRecord> transactions = null;
		try {
			transactions = new  ArrayList<TransactionRecord>();
			BufferedReader transactionReader = initializeTransactionFile();
			transactions = transactionReader.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			transactionReader.close();
			return transactions;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FileSystemNotFoundException fe) {
			fe.printStackTrace();
		}
		return null;
	}

	/** Method Name : initializeTransactionFile()
	 * Description : Initializes the File Object from the config.
	 * Return : BufferedReader
	 */
	private BufferedReader initializeTransactionFile() throws IOException {
		File transactionFile = new File(ConfigProperties.getTransFilePath());
	    InputStream transactionInputStream = new FileInputStream(transactionFile);
	    BufferedReader transactionReader = new BufferedReader(new InputStreamReader(transactionInputStream));
	    return transactionReader;
	    
	}
	
	/** Method Name : mapToItem()
	 * Description : Read the data from the line and convert to TransactionRecord
	 * Return : TransactionRecord
	 */
	private  Function<String, TransactionRecord> mapToItem = (line) -> {
	  
	  List<String> transactionData = Arrays.asList(line.split(TransactionConstants.COMMA));
	  TransactionRecord transaction = new TransactionRecord();
	  transaction.setTransactionId(transactionData.get(TransactionConstants.TRANSID_INDEX).trim());
	  transaction.setFromAccountId(transactionData.get(TransactionConstants.FROM_ACCOUNT_INDEX).trim());
	  transaction.setToAccountId(transactionData.get(TransactionConstants.TO_ACCOUNT_INDEX).trim());
	  transaction.setCreatedAt(TransactionUtil.convertDate(transactionData.get(TransactionConstants.CREATED_AT_INDEX).trim()));
	  transaction.setTransactionType(transactionData.get(TransactionConstants.TRANSACTION_TYPE_INDEX).trim());
	  transaction.setAmount(Float.parseFloat(transactionData.get(TransactionConstants.AMOUNT_INDEX).trim()));
	  if(transactionData.size() == (TransactionConstants.RELATED_TRANSACTION_INDEX + 1) ) {
		  transaction.setRelatedTransaction(transactionData.get(TransactionConstants.RELATED_TRANSACTION_INDEX).trim());
	  }
	  return transaction;
	};

}



