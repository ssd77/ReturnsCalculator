package com.bank.interest.service;

import org.springframework.stereotype.Service;

import com.bank.interest.dto.InterestRequest;

@Service
public class InterestCalculatorService {
	
    public Float calculateSimpleInterest(InterestRequest request){
    	Float principal = request.getPrincipal();
    	Float rate = request.getInterestRate();
    	Float time = request.getTime();
    	return (principal*rate*time)/100;
    }
    
    public Float calculateCompoundInterest(InterestRequest request){
    	Float principal = request.getPrincipal();
    	Float rate = request.getInterestRate();
    	Float time = request.getTime();
    	return new Float(principal * Math.pow((1 + rate/100),time));
    }
}
