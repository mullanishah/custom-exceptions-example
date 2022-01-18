package com.core.tester;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.core.exceptions.AccountHandlingException;
import com.core.pojo.BankAccount;
import com.core.pojo.PaymentCard;

public class BankOperationsTester {

	public static void performBankOperations(BankAccount validatedBankAccount, Scanner scanner, List<PaymentCard> paymentCardList, Map<PaymentCard, BankAccount> bankAccountMap) throws Exception {
		int choice = 0;
		if(validatedBankAccount == null)
			throw new AccountHandlingException("Something went wrong! Bank account not associated with given card details.");
		
		try {
			do {
				System.out.println("****MENU***** "
						+ "\n1.Account Information \n2.Withdraw \n3.Deposite "
						+ "\n4.Fund Transfer \n5.Exit");
				System.out.println("Enter your choice: ");
				choice = scanner.nextInt();
				switch(choice) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				default:
					System.out.println("Invalid choice!");
					break;
				}
			}while(choice != 5);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
