package com.core.service;

import static com.core.utils.DataHandlingUtils.*;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import com.core.exceptions.AccountHandlingException;
import com.core.pojo.BankAccount;
import com.core.pojo.PaymentCard;
import com.core.utils.AccountValidationUtils;
import com.core.utils.StringUtils;

public class BankAccountOperationsImpl implements BankAccountOperations {

	@Override
	public BankAccount deposite(BankAccount bankAccount, double amount) throws AccountHandlingException, ParseException {
		
		AccountValidationUtils.checkAccountType(bankAccount.getAccountType());
		AccountValidationUtils.checkBalance(bankAccount.getBalance());
		AccountValidationUtils.checkAccountCreationDate(bankAccount.getAccountCreationDate());
		AccountValidationUtils.checkDepositeLimit(amount);
		bankAccount.setBalance(bankAccount.getBalance() + amount);
		return bankAccount;
	}

	@Override
	public BankAccount withdraw(BankAccount bankAccount, double amount) throws AccountHandlingException, ParseException {
		
		AccountValidationUtils.checkAccountType(bankAccount.getAccountType());
		AccountValidationUtils.checkBalance(bankAccount.getBalance());
		AccountValidationUtils.checkAccountCreationDate(bankAccount.getAccountCreationDate());
		AccountValidationUtils.checkWithdrawalLimit(amount);
		bankAccount.setBalance(bankAccount.getBalance() - amount);
		return bankAccount;
	}

	@Override
	public HashMap<String, Double> fundTransfer(BankAccount sourceAccount, BankAccount destinationAccount, double amount) 
				throws AccountHandlingException, ParseException, Exception {
		
		Double updatedDestinationBalance = null;
		//withdraw amt from source account
		double updatedSourceBalance = withdrawAmount(sourceAccount, amount);
		if(updatedSourceBalance > -1) {
			//deposit amt to destination account
			updatedDestinationBalance = depositeAmount(destinationAccount, amount);
		}
		return new HashMap<String, Double>(Map.of("updatedSourceBalance", updatedSourceBalance, "updatedDestinationBalance", updatedDestinationBalance));
	}

	public static BankAccount getAccountDetails(PaymentCard paymentCard) {
		
		BankAccount account = getBankAccountMap().get(paymentCard);
		return account;
	}
	
	public static Double withdrawAmount(BankAccount validatedBankAccount, double amount) throws Exception {
		
		BankAccount updatedAccount = new BankAccountOperationsImpl().withdraw(validatedBankAccount, amount);
		if(updatedAccount == null) {
			throw new AccountHandlingException("Something went wrong during withdrawal, please try again later.");
		} else {
			getBankAccountMap().replace(updatedAccount.getValidatedCardDetails(), updatedAccount); 
			return updatedAccount.getBalance();
		}
	}
	
	public static Double depositeAmount(BankAccount validatedBankAccount, double amount) throws Exception {
		
		BankAccount updatedAccount = new BankAccountOperationsImpl().deposite(validatedBankAccount, amount);
		if(updatedAccount == null) {
			throw new AccountHandlingException("Something went wrong during deposite, please try again later.");
		}else {
			getBankAccountMap().replace(updatedAccount.getValidatedCardDetails(), updatedAccount); 
			return updatedAccount.getBalance();
		}
	}
	
	public static BankAccount fundTransferAmount(BankAccount sourceAccount, Long destinationAccountNum, double amount) throws Exception {
		
		//get destination account details
		BankAccount destinationAccount = getAccountDetails(destinationAccountNum);
		
		HashMap<String, Double> resultMap = new BankAccountOperationsImpl().fundTransfer(sourceAccount, destinationAccount, amount);
		
		if(resultMap.get("updatedDestinationBalance") == destinationAccount.getBalance() && resultMap.get("updatedSourceBalance") == sourceAccount.getBalance()) {
			return sourceAccount;
		}
		return null;
	}
	
	private static BankAccount getAccountDetails(long accountNum) throws Exception {
		
		boolean status = getBankAccountMap().containsValue(new BankAccount(accountNum));
		if(status == true) {
			for(BankAccount b : getBankAccountMap().values()) {
				if(b.getAccountNumber() == accountNum)
					return b;
			}
		} else {
			throw new AccountHandlingException("Invalid destination account number!!");
		}
		return null;
	}
	
	public static void enrichBankDetails(BankAccount account) {
		long accountNum = account.getAccountNumber();
		String name = account.getAccountHolderName();
		String type = account.getAccountType().toUpperCase();
		String status = (account.isAccountActive()) ? "Active" : "Inactive";
		String creation = StringUtils.getSdf().format(account.getAccountCreationDate());
		double balance = account.getBalance();
		System.out.println("==============================================================================");
		System.out.println("|Account Number | Holder Name | Type  | Status | Creation Date | Balance      |");
		System.out.println("|===============|=============|=======|========|===============|==============|");
		System.out.printf("|%-15d|%-13s|%-7s|%-8s|%-15s|Rs.%-10.2f |%n", accountNum, name, type, status, creation, balance);
		System.out.println("|===============|=============|=======|========|===============|==============|");
	}
}
