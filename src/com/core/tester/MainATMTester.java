package com.core.tester;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.core.exceptions.AccountHandlingException;
import com.core.pojo.BankAccount;
import com.core.pojo.PaymentCard;
import com.core.service.BankAccountOperationsImpl;
import com.core.service.PaymentCardOperationsImpl;
import com.core.utils.SampleDataUtils;
import com.core.utils.StringUtils;

public class MainATMTester {
	
	private static List<PaymentCard> paymentCardList = null;
	private static Map<PaymentCard, BankAccount> bankAccountMap = null;
	private static Scanner scanner = null;
	//private static BankAccount validatedBankAccount = null;
	
	static {
		paymentCardList = SampleDataUtils.getpopulatedPaymentCardDetails(paymentCardList);
		bankAccountMap = SampleDataUtils.getPopulatedBankAccounts(bankAccountMap);
		scanner = StringUtils.getScanner();
	}

	public static void main(String[] args) {
		
		try {
			BankAccount validatedBankAccount = PaymentCardTester.performPaymentCardOperations(scanner, paymentCardList, bankAccountMap);
			BankOperationsTester.performBankOperations(validatedBankAccount, scanner, paymentCardList, bankAccountMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
