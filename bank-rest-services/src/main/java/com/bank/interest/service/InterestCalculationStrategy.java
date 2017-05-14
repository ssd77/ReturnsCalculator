package com.bank.interest.service;

import java.math.BigDecimal;

import com.bank.interest.dto.InterestRequest;

/**
 * @author Sachin.dube
 * 
 *  This Strategy is responsible of dynamically calculating
 *  interest as per the requested interest type (simple/compound).
 */
public interface InterestCalculationStrategy {
	
	public BigDecimal calculateInterest(InterestRequest request);

}
