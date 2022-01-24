package com.core.tester;

import java.util.Scanner;
import com.core.pojo.BankAccount;
import com.core.pojo.PaymentCard;
import com.core.service.BankAccountOperationsImpl;
import com.core.service.PaymentCardOperationsImpl;

public class PaymentCardTester {

	public static BankAccount performPaymentCardOperations(Scanner scanner) {
		
		try {
			System.out.println("Hello user, ");
			System.out.println("Please enter your payment card number and pin number: ");
			PaymentCard card = new PaymentCard(scanner.next(), scanner.nextInt());
			boolean loginStatus = PaymentCardOperationsImpl.login(card);
			if(true == loginStatus) {
				BankAccount validatedBankAccount = BankAccountOperationsImpl.getAccountDetails(card);
				validatedBankAccount.setValidatedCardDetails(card);
				return validatedBankAccount;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
