package com.core.pojo;

import java.util.Date;
import com.core.utils.StringUtils;

public class BankAccount {
	
	private long accountNumber;
	private String accountType;
	private String accountHolderName;
	private Date accountCreationDate;
	private double balance;
	private boolean accountActiveStatus;
	private PaymentCard validatedCardDetails;
	
	public BankAccount(long accountNumber, String accountType, String accountHolderName, Date accountCreationDate, double balance, 
				boolean accountActiveStatus) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.accountHolderName = accountHolderName;
		this.accountCreationDate = accountCreationDate;
		this.balance = balance;
		this.accountActiveStatus = accountActiveStatus;
	}
	
	public BankAccount(long accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}

	public long getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getAccountHolderName() {
		return accountHolderName;
	}
	
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	
	public Date getAccountCreationDate() {
		return accountCreationDate;
	}
	
	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public boolean isAccountActive() {
		return accountActiveStatus;
	}
	
	public void setAccountActive(boolean accountActive) {
		this.accountActiveStatus = accountActive;
	}
	
	public PaymentCard getValidatedCardDetails() {
		return validatedCardDetails;
	}

	public void setValidatedCardDetails(PaymentCard validatedCardDetails) {
		this.validatedCardDetails = validatedCardDetails;
	}

	@Override
	public String toString() {
		return "BankAccount [Account No: " + accountNumber + ", Account Type; " + accountType + ", Holder Name: " + accountHolderName 
				+ ", Creation Date: " + StringUtils.getSdf().format(accountCreationDate) + ", Balance: Rs." + balance + ", Account Status: " + accountActiveStatus + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNumber ^ (accountNumber >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj || !(obj instanceof BankAccount))
			return false;
		return accountNumber == ((BankAccount)obj).accountNumber;
	}
	
	
}
