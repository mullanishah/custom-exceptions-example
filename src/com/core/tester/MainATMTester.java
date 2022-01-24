package com.core.tester;

import java.util.Scanner;

import com.core.pojo.BankAccount;
import com.core.utils.StringUtils;

public class MainATMTester {
	
	private static Scanner scanner = null;
	static {
		scanner = StringUtils.getScanner();
	}
	
	public static void main(String[] args) {
		
		try {
			BankAccount validatedBankAccount = PaymentCardTester.performPaymentCardOperations(scanner);
			BankOperationsTester.performBankOperations(scanner,validatedBankAccount);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Scanner getScanner() {
		return scanner;
	}

	public static void setScanner(Scanner scanner) {
		MainATMTester.scanner = scanner;
	}

}
