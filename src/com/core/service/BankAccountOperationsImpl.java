package com.core.service;

import static com.core.utils.DataHandlingUtils.*;

import java.text.ParseException;

import com.core.exceptions.AccountHandlingException;
import com.core.pojo.BankAccount;
import com.core.pojo.PaymentCard;
import com.core.utils.AccountValidationUtils;

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
	public void fundTransfer(long cardNumber, int pinNumber) throws AccountHandlingException {
		// TODO Auto-generated method stub
		
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
		Double updatedDestinationBalance = null;
		//get destination account details
		BankAccount destinationAccount = getAccountDetails(destinationAccountNum);
		
		//withdraw amt from source account
		double updatedSourceBalance = withdrawAmount(sourceAccount, amount);
		if(updatedSourceBalance > -1) {
			//deposite amt to destination account
			updatedDestinationBalance = depositeAmount(destinationAccount, amount);
		}
		if(updatedDestinationBalance == destinationAccount.getBalance() && updatedSourceBalance == sourceAccount.getBalance()) {
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
}
