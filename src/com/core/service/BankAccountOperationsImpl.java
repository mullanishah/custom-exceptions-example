package com.core.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.core.pojo.BankAccount;
import com.core.pojo.PaymentCard;

public class BankAccountOperationsImpl implements BankAccountOperations {

	@Override
	public void deposite(long cardNumber, int pinNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void withdraw(long cardNumber, int pinNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fundTransfer(long cardNumber, int pinNumber) {
		// TODO Auto-generated method stub
		
	}

	public static BankAccount getAccountDetails(PaymentCard paymentCard, Map<PaymentCard, BankAccount> bankAccountMap) {
		BankAccount account = bankAccountMap.get(paymentCard);
		return account;
	}
	

}
