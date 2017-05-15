/**
 * 
 */
package com.bank.interest.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Component;

import com.bank.interest.dto.InterestRequest;
import com.bank.interest.service.InterestCalculationStrategy;

/**
 * @author Sachin Dube
 *
 */
@Component
public class CompoundInterestCalculator implements InterestCalculationStrategy {

	public CompoundInterestCalculator() {		
	}	
	
	public BigDecimal calculateInterest(InterestRequest request) {		
		BigDecimal returnIntrest = new BigDecimal(request.getPrincipal() * Math.pow((1 + request.getInterestRate()/100),request.getPeriods()));
		return returnIntrest.setScale(2, RoundingMode.HALF_UP);
	}	

}
