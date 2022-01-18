package com.core.service;

import java.util.List;
import com.core.exceptions.PaymentCardHandlingException;
import com.core.pojo.PaymentCard;

public class PaymentCardOperationsImpl implements PaymentCardOperations {

	@Override
	public boolean validateUser(PaymentCard paymentCard, List<PaymentCard> paymentCardList) {
		if(paymentCardList.contains(paymentCard))
			return true;
		return false;
	}

	@Override
	public boolean updatePinNumber(int newPin, PaymentCard paymentCard, List<PaymentCard> paymentCardList) throws Exception {
		boolean loginStatus = login(paymentCard, paymentCardList);
		if(loginStatus) {
			PaymentCard card = paymentCardList.get(paymentCardList.indexOf(paymentCard));
			card.setPinNumber(newPin);
			return true;
		}
		return false;
	}
	
	//from main method
	public static boolean login(PaymentCard paymentCard, List<PaymentCard> paymentCardList) throws PaymentCardHandlingException {
		boolean loginStatus = false;
		if(paymentCard != null && paymentCardList != null)
			loginStatus = new PaymentCardOperationsImpl().validateUser(paymentCard, paymentCardList);
		if(loginStatus == true) 
			return true;
		else
			throw new PaymentCardHandlingException("Invalid login credentials!");
	}

}
