package com.core.service;

import java.util.List;
import com.core.exceptions.PaymentCardHandlingException;
import com.core.pojo.PaymentCard;
import static com.core.utils.DataHandlingUtils.*;

public class PaymentCardOperationsImpl implements PaymentCardOperations {

	@Override
	public boolean validateUser(PaymentCard paymentCard, List<PaymentCard> paymentCardList) {
		if(paymentCardList.contains(paymentCard))
			return true;
		return false;
	}

	@Override
	public boolean updatePinNumber(int newPin, PaymentCard paymentCard, List<PaymentCard> paymentCardList) throws Exception {
		boolean loginStatus = login(paymentCard);
		if(loginStatus) {
			PaymentCard card = paymentCardList.get(paymentCardList.indexOf(paymentCard));
			card.setPinNumber(newPin);
			return true;
		}
		return false;
	}
	
	//from main method
	public static boolean login(PaymentCard paymentCard) throws PaymentCardHandlingException {
		boolean loginStatus = false;
		if(paymentCard != null)
			loginStatus = new PaymentCardOperationsImpl().validateUser(paymentCard, getPaymentCardList());
		if(loginStatus == true) 
			return true;
		else
			throw new PaymentCardHandlingException("Invalid login credentials!");
	}

}
