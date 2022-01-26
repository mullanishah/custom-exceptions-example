package com.core.tester;

import com.core.exceptions.AccountHandlingException;
import com.core.exceptions.PaymentCardHandlingException;

public class SampleExceptionTester {

	public static void main(String[] args) {
		try {
			test();
			tests();
		} catch (AccountHandlingException e) {
			e.printStackTrace();
		} catch (PaymentCardHandlingException e) {
			e.printStackTrace();
		}

	}
	
	static void test() throws PaymentCardHandlingException {
		throw new PaymentCardHandlingException("Sample payment exception");
	}

	static void tests() throws AccountHandlingException {
		throw new AccountHandlingException("Sample account handling exception");
	}
}
