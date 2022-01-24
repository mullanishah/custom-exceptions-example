package com.core.tester;

import java.util.Scanner;

import com.core.exceptions.AccountHandlingException;
import com.core.pojo.BankAccount;
import com.core.service.BankAccountOperationsImpl;

public class BankOperationsTester {

	public static void performBankOperations(Scanner scanner, BankAccount validatedBankAccount) throws Exception {
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
					System.out.println(validatedBankAccount);
					break;
				case 2:
					System.out.println("Account Num: " + validatedBankAccount.getAccountNumber());
					System.out.println("Enter amount to be withdrawl: ");
					double withdrawalAmount = scanner.nextDouble();
					double updatedBalance = BankAccountOperationsImpl.withdrawAmount(validatedBankAccount, withdrawalAmount);
					System.out.println("Withdrawal successful!! Updated balance: " + updatedBalance);
					break;
				case 3:
					System.out.println("Account Num: " + validatedBankAccount.getAccountNumber());
					System.out.println("Enter amount to be deposite: ");
					double depositedAmount = scanner.nextDouble();
					updatedBalance = BankAccountOperationsImpl.depositeAmount(validatedBankAccount, depositedAmount);
					System.out.println("Deposite successful!! Updated balance: " + updatedBalance);
					break;
				case 4:
					System.out.println("Account Num: " + validatedBankAccount.getAccountNumber());
					System.out.println("Enter destination bank account num and amount: ");
					long destAccountNo = scanner.nextLong();	
					double amount = scanner.nextDouble();
					BankAccount srcAccount = BankAccountOperationsImpl.fundTransferAmount(validatedBankAccount, destAccountNo, amount);
					System.out.println("Fund transfer successful!! Updated account: " + srcAccount);
					break;
				case 5:
					validatedBankAccount = null;
					System.exit(0);
					System.out.println("=====Exiting======");
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
