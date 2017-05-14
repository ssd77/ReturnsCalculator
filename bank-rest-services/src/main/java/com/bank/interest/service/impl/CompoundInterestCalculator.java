/**
 * 
 */
package com.bank.interest.service.impl;

import java.math.BigDecimal;

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
		return new BigDecimal(request.getPrincipal() * Math.pow((1 + request.getInterestRate()/100),request.getPeriods()));
	}
	
	/*public Float calculateSimpleInterest(InterestRequest request){
    	Float principal = request.getPrincipal();
    	Float rate = request.getRate();
    	Float time = request.getTime();
    	return (principal*rate*time)/100;
    }
    
    public Float calculateCompoundInterest(InterestRequest request){
    	Float principal = request.getPrincipal();
    	Float rate = request.getRate();
    	Float time = request.getTime();
    	return new Float(principal * Math.pow((1 + rate/100),time));
    }*/

}
