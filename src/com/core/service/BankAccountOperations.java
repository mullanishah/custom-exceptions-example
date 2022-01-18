package com.core.service;

import com.core.pojo.BankAccount;
import com.core.pojo.PaymentCard;

public interface BankAccountOperations {

	void deposite(long cardNumber, int pinNumber);
	void withdraw(long cardNumber, int pinNumber);
	void fundTransfer(long cardNumber, int pinNumber);
	
	//pin change
	//mini statement
	
}
