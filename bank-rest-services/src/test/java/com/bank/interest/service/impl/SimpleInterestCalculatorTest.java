package com.bank.interest.service.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bank.interest.dto.InterestRequest;
import com.bank.interest.service.InterestType;

/**
 * Simple Interest Calculator
 */
public class SimpleInterestCalculatorTest {
	
	private SimpleInterestCalculator simpleInterestCalculator;
	private InterestRequest interestRequest;

	@Before
	public void setUp() throws Exception {
		simpleInterestCalculator = new SimpleInterestCalculator();
		interestRequest = new InterestRequest();		
		interestRequest.setPrincipal(1000.0d);
		interestRequest.setInterestRate(10d);
		interestRequest.setPeriods(20d);
		interestRequest.setBaseCurrency("Pounds");		
	}

	/**
	 * Test calculate simple interest.
	 */
	@Test
	public void testCalculateSimpleInterest() {
		interestRequest.setInterestType(InterestType.SIMPLE.name());
		BigDecimal calculateInterest = simpleInterestCalculator.calculateInterest(interestRequest);
		Assert.assertEquals(calculateInterest, new BigDecimal(2000).setScale(2));
	}	
}
