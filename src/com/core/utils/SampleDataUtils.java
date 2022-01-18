package com.core.utils;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.core.pojo.BankAccount;
import com.core.pojo.PaymentCard;

public class SampleDataUtils {
	
	public static List<PaymentCard> getpopulatedPaymentCardDetails(List<PaymentCard> paymentCardList) {
		if(null == paymentCardList)	
			paymentCardList = new ArrayList<PaymentCard>();

		paymentCardList.add(new PaymentCard("980127654321", 7890, "John Walker", "732-622-4888"));
		paymentCardList.add(new PaymentCard("114387450980", 4962, "Mrs.Alice Halley", "480-570-1143"));
		paymentCardList.add(new PaymentCard("943285101762", 1123, "Dr.Davis Darwin", "(541) 373-3010"));
		paymentCardList.add(new PaymentCard("593284176019", 9092, "Ms Emma Ford", "501 789 4325"));
		paymentCardList.add(new PaymentCard("468056774132", 4519, "Richard Chamberlain", "800-122-1222"));
		paymentCardList.add(new PaymentCard("77777", 7777, "test", "123 456 7890"));
		return paymentCardList;
	}
	
	public static Map<PaymentCard, BankAccount> getPopulatedBankAccounts(Map<PaymentCard, BankAccount> bankAccountMap) {
		if(bankAccountMap == null)
			bankAccountMap = new HashMap<PaymentCard, BankAccount>(10);
		
		try {
			bankAccountMap.put(new PaymentCard("980127654321", 7890, "John Walker", "732-622-4888"), 
					new BankAccount(980127654, "saving", "John Walker", StringUtils.getSdf().parse("08/10/1982"), 52450, true));
			bankAccountMap.put(new PaymentCard("114387450980", 4962, "Mrs.Alice Halley", "480-570-1143"), 
					new BankAccount(114387450, "current", "Mrs.Alice Halley", StringUtils.getSdf().parse("27/02/1988"), 37652, true));
			bankAccountMap.put(new PaymentCard("943285101762", 1123, "Dr.Davis Darwin", "(541) 373-3010"), 
					new BankAccount(943285101, "fd", "Dr.Davis Darwin", StringUtils.getSdf().parse("27/02/1988"), 79001, true));
			bankAccountMap.put(new PaymentCard("593284176019", 9092, "Ms Emma Ford", "501 789 4325"), 
					new BankAccount(593284176, "current", "Ms Emma Ford", StringUtils.getSdf().parse("27/02/1988"), 80238, true));
			bankAccountMap.put(new PaymentCard("468056774132", 4519, "Richard Chamberlain", "800-122-1222"), 
					new BankAccount(468056774, "saving", "Richard Chamberlain", StringUtils.getSdf().parse("27/02/1988"), 64730, true));
			bankAccountMap.put(new PaymentCard("77777", 7777, "test", "123 456 7890"), 
					new BankAccount(123456789, "saving", "test", StringUtils.getSdf().parse("27/02/1988"), 50000, true));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return bankAccountMap;
	}
	
	private static BankAccount[] getBankAccounts() {
		try {
			return new BankAccount[] {
				new BankAccount(980127654, "saving", "John Walker", StringUtils.getSdf().parse("08/10/1982"), 52450, true),
				new BankAccount(114387450, "current", "Mrs.Alice Halley", StringUtils.getSdf().parse("27/02/1988"), 37652, true),
				new BankAccount(943285101, "fd", "Dr.Davis Darwin", StringUtils.getSdf().parse("27/02/1988"), 79001, true),
				new BankAccount(593284176, "current", "Ms Emma Ford", StringUtils.getSdf().parse("27/02/1988"), 80238, true),
				new BankAccount(468056774, "saving", "Richard Chamberlain", StringUtils.getSdf().parse("27/02/1988"), 64730, true),
				new BankAccount(123456789, "saving", "test", StringUtils.getSdf().parse("27/02/1988"), 50000, true)
			};
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
