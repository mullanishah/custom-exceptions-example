package com.core.service;

import java.text.ParseException;
import java.util.HashMap;
import com.core.exceptions.AccountHandlingException;
import com.core.pojo.BankAccount;

public interface BankAccountOperations {

	BankAccount deposite(BankAccount validatedBankAccount, double amount) throws AccountHandlingException, ParseException;
	BankAccount withdraw(BankAccount validatedBankAccount, double amount) throws AccountHandlingException, ParseException;
	HashMap<String, Double> fundTransfer(BankAccount sourceAccount, BankAccount destinationAccount, double amount) 
			throws AccountHandlingException, ParseException, Exception;
	
	//pin change
	//mini statement
	
}
