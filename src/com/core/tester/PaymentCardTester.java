package com.core.tester;

import java.io.Console;
import java.util.Scanner;
import com.core.pojo.BankAccount;
import com.core.pojo.PaymentCard;
import com.core.service.BankAccountOperationsImpl;
import com.core.service.PaymentCardOperationsImpl;

public class PaymentCardTester {

	public static BankAccount performPaymentCardOperations(Scanner scanner) {
		
		try {
			System.out.println("Hello user, ");
			System.out.println("Please enter your credentials (payment card and pin number): ");
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
	
	public static void sampleLogin(String... strings) {
		Console console = System.console();
		if(console == null) {
			System.out.println("No console available");
			return;
		}
		String cardno = console.readLine("Enter card number: ");
		char[] pwd = console.readPassword("Enter pin number: ", "*");
		
		System.out.println("Card number: " + cardno + ", Pin" + pwd.toString());
	}
	
}
