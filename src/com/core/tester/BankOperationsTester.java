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
						+ "\n1.Account Information \n2.Cash Withdrawal \n3.Deposit"
						+ "\n4.Fund Transfer \n5.Exit");
				System.out.println("Enter transaction: ");
				choice = scanner.nextInt();
				switch(choice) {
				case 1:
					BankAccountOperationsImpl.enrichBankDetails(validatedBankAccount);
					break;
				case 2:
					getValidatedTitle(validatedBankAccount);
					System.out.println("Enter amount to withdraw: ");
					double withdrawalAmount = scanner.nextDouble();
					double updatedBalance = BankAccountOperationsImpl.withdrawAmount(validatedBankAccount, withdrawalAmount);
					System.out.println("Withdrawal successful!! Updated balance: Rs." + updatedBalance);
					break;
				case 3:
					getValidatedTitle(validatedBankAccount);
					System.out.println("Enter amount to deposit: ");
					double depositedAmount = scanner.nextDouble();
					updatedBalance = BankAccountOperationsImpl.depositAmount(validatedBankAccount, depositedAmount);
					System.out.println("Deposit successful!! Updated balance: Rs." + updatedBalance);
					break;
				case 4:
					getValidatedTitle(validatedBankAccount);
					System.out.println("Enter destination account number and amount to transfer: ");
					long destAccountNo = scanner.nextLong();	
					double amount = scanner.nextDouble();
					BankAccount srcAccount = BankAccountOperationsImpl.fundTransferAmount(validatedBankAccount, destAccountNo, amount);
					System.out.println("Fund transfer successful!! Updated account: " + srcAccount);
					break;
				case 5:
					System.out.println("======Exiting=======");
					validatedBankAccount = null;
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice!!");
					break;
				}
			}while(choice != 5);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void getValidatedTitle(BankAccount validatedBankAccount) {
		System.out.println("Hi " + validatedBankAccount.getAccountHolderName() + "(" + validatedBankAccount.getAccountNumber() + ")");
	}
	
}
//1.pin change     \t2.Fast Cash
//3.Fund Transfer  \t4.Withdrawal
//5.Mob.Connect    \t6.Balance Enquiry
//7.Other services \t8.Mini Statement
