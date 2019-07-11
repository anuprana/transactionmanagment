package com.assignment.transactionmanagment.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.assignment.transactionmanagment.constants.TransactionConstants;

/**
 * TransactionUtil.java
 * 
 * Contains the common util method.
 */
public class TransactionUtil {

	/**
	 * Method Name : convertDate
	 * Description : Converts the date to the format dd/MM/yyyy HH:mm:ss from the String value.
	 * Parameter : transDate - Input date in String format
	 * Return  : Date in format dd/MM/yyyy HH:mm:ss
	 */
	public static Date convertDate (String transDate)  {
		Date transactionDate;
		try {
			DateFormat formatter=new SimpleDateFormat(TransactionConstants.DATE_FORMAT);
			transactionDate=formatter.parse(transDate);
			return transactionDate;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
