package com.core.tester;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.core.pojo.BankAccount;
import com.core.pojo.PaymentCard;
import com.core.service.BankAccountOperationsImpl;
import com.core.service.PaymentCardOperationsImpl;

public class PaymentCardTester {

	public static BankAccount performPaymentCardOperations(Scanner scanner, List<PaymentCard> paymentCardList, Map<PaymentCard, BankAccount> bankAccountMap) {
		try {
			System.out.println("Hello user, ");
			System.out.println("Please enter your payment card number and pin number: ");
			PaymentCard card = new PaymentCard(scanner.next(), scanner.nextInt());
			boolean loginStatus = PaymentCardOperationsImpl.login(card, paymentCardList);
			if(true == loginStatus) {
				BankAccount validatedBankAccount = BankAccountOperationsImpl.getAccountDetails(card, bankAccountMap);
				return validatedBankAccount;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
