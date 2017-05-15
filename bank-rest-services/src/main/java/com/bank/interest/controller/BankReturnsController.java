package com.bank.interest.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.interest.dto.InterestRequest;
import com.bank.interest.dto.InterestReturnsResponse;
import com.bank.interest.service.InterestCalculationStrategy;
import com.bank.interest.service.InterestCalculationStrategyFactory;
import com.bank.interest.service.InterestType;

@RestController
public class BankReturnsController {  

    @Autowired
	private  InterestCalculationStrategyFactory interestCalculationStrategyFactory;
        
    @RequestMapping(value="/calculateReturn",method=RequestMethod.POST) 
    public InterestReturnsResponse calcSimpleIntReturns(@RequestBody InterestRequest request){
    	
    	InterestReturnsResponse response = null;
   
    	Optional<InterestCalculationStrategy> interestCalculationStrategy = interestCalculationStrategyFactory.getInterestCalculationStrategy(InterestType.valueOf(request.getInterestType()));
		if(interestCalculationStrategy.isPresent()){
			BigDecimal interest = interestCalculationStrategy.get().calculateInterest(request);
			
			response = new InterestReturnsResponse(interest.doubleValue(),
					new BigDecimal(interest.doubleValue()/0.78d).setScale(2, RoundingMode.HALF_UP).doubleValue()); 
			//TODO: get the FX rate from database or a service defaulting it to 0.78 i.e USD to GBP rate
		}
    	
		return response;   	
    }
}