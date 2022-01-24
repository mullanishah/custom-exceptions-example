package com.core.service;

import java.text.ParseException;

import com.core.exceptions.AccountHandlingException;
import com.core.pojo.BankAccount;

public interface BankAccountOperations {

	BankAccount deposite(BankAccount validatedBankAccount, double amount) throws AccountHandlingException, ParseException;
	BankAccount withdraw(BankAccount validatedBankAccount, double amount) throws AccountHandlingException, ParseException;
	void fundTransfer(long cardNumber, int pinNumber) throws AccountHandlingException;
	
	//pin change
	//mini statement
	
}
