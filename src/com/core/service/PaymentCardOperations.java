package com.core.service;

import java.util.List;
import com.core.pojo.PaymentCard;

public interface PaymentCardOperations {
	
	boolean validateUser(PaymentCard paymentCard, List<PaymentCard> paymentCardList);
	boolean updatePinNumber(int newPin, PaymentCard paymentCard, List<PaymentCard> paymentCardList) throws Exception;
}
