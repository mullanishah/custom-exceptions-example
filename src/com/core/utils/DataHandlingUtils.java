
package com.core.utils;

import java.util.List;
import java.util.Map;
import com.core.pojo.BankAccount;
import com.core.pojo.PaymentCard;

public class DataHandlingUtils {

	private static List<PaymentCard> paymentCardList = null;
	private static Map<PaymentCard, BankAccount> bankAccountMap = null;
	//private static BankAccount validatedBankAccount = null;
	
	static {
		paymentCardList = SampleDataUtils.getpopulatedPaymentCardDetails(paymentCardList);
		bankAccountMap = SampleDataUtils.getPopulatedBankAccounts(bankAccountMap);
	}
	
	public static List<PaymentCard> getPaymentCardList() {
		return paymentCardList;
	}

	public static void setPaymentCardList(List<PaymentCard> paymentCardList) {
		DataHandlingUtils.paymentCardList = paymentCardList;
	}

	public static Map<PaymentCard, BankAccount> getBankAccountMap() {
		return bankAccountMap;
	}

	public static void setBankAccountMap(Map<PaymentCard, BankAccount> bankAccountMap) {
		DataHandlingUtils.bankAccountMap = bankAccountMap;
	}
}
