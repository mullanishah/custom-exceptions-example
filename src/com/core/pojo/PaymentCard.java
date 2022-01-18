package com.core.pojo;

public class PaymentCard {
	
	private String cardNumber;
	private int pinNumber;
	private String holderName;
	private String mobileNumber;
	
	public PaymentCard(String cardNumber, int pinNumber,String holderName, String mobileNumber) {
		super();
		this.cardNumber = cardNumber;
		this.pinNumber = pinNumber;
		this.holderName = holderName;
		this.mobileNumber = mobileNumber;
	}
	
	public PaymentCard(String cardNumber, int pinNumber) {
		super();
		this.cardNumber = cardNumber;
		this.pinNumber = pinNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardNumber == null) ? 0 : cardNumber.hashCode());
		result = prime * result + pinNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null || !(obj instanceof PaymentCard))
			return false;
		return cardNumber.equals(((PaymentCard)obj).cardNumber) &&
				pinNumber == ((PaymentCard)obj).pinNumber;
	}

	@Override
	public String toString() {
		return "PaymentCard [Card No: " + cardNumber + ", Pin No:" + pinNumber + ", Holder Name: " + holderName + ", Mob.No: " + mobileNumber + "]";
	}
	
}
