package com.bank.interest.service.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bank.interest.dto.InterestRequest;
import com.bank.interest.service.InterestType;

/**
 * Compound Interest Calculator Test
 */
public class CompoundInterestCalculatorTest {
	
	private CompoundInterestCalculator compoundInterestCalculator;
	private InterestRequest interestRequest;

	@Before
	public void setUp() throws Exception {
		compoundInterestCalculator = new CompoundInterestCalculator();
		interestRequest = new InterestRequest();		
		interestRequest.setPrincipal(1000.0d);
		interestRequest.setInterestRate(10d);
		interestRequest.setPeriods(20d);
		interestRequest.setInterestType(InterestType.COMPOUND.name());
		interestRequest.setBaseCurrency("INR");		
	}

	/**
	 * Test calculate compound interest.
	 */
	@Test
	public void testCalculateCompoundInterest() {		
		BigDecimal calculateInterest = compoundInterestCalculator.calculateInterest(interestRequest);	
		Assert.assertTrue(calculateInterest.toString().equals("6727.50"));
	}

}
