package com.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.core.exceptions.AccountHandlingException;

public class AccountValidationUtils {
	
	private static final int MIN_BALANCE = 500;
	private static Date beginDate, endDate;
	private static SimpleDateFormat sdf;
	static {
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			beginDate = sdf.parse("01/01/1970");
			endDate = new Date(System.currentTimeMillis());
			sdf.setLenient(false);
		} catch(ParseException pe) {
			pe.printStackTrace();
		}
	}
	
	//validate balance
	public static void checkBalance(double balance) throws AccountHandlingException {
		if(balance < MIN_BALANCE) {
			throw new AccountHandlingException("Insufficient balance to proceed for operation!!");
		}
	}
	
	//validate withdrawal limit
	public static void checkWithdrawalLimit(double amount) throws AccountHandlingException {
		if(amount > 20000) {
			throw new AccountHandlingException("Withdrawal amount limit should not exceed Rs.20,000 for a day!!");
		}
	}
	
	//validate deposite limit
	public static void checkDepositeLimit(double amount) throws AccountHandlingException {
		if(amount > 100000) {
			throw new AccountHandlingException("Deposite limit should not exceed Rs.1,00,000 for a day!!");
		}
	}
	
	//validate account type 
	public static void checkAccountType(String type) throws AccountHandlingException{
		switch(type.toLowerCase()) {
		case "saving":
		case "current":
		case "fd":
			return;
		default:
			throw new AccountHandlingException("Invalid account type!!");
		}
	}
	
	//validate account creation date
	public static Date checkAccountCreationDate(Date date) throws AccountHandlingException, ParseException{
		//Date date = sdf.parse(strDate);
		if(date.before(beginDate) || date.after(endDate)) {
			throw new AccountHandlingException("Invalid account creation date!!");
		}
		return date;
	}
}
