package com.bank.interest.controller;

import java.math.BigDecimal;
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

    
/*    @Autowired
    InterestCalculatorService interestCalculatorService;*/

    @Autowired
	private  InterestCalculationStrategyFactory interestCalculationStrategyFactory;
    
    
    @RequestMapping(value="/calculateReturn",method=RequestMethod.POST) 
    public InterestReturnsResponse calcSimpleIntReturns(@RequestBody InterestRequest request){
    	
    	InterestReturnsResponse response = null;
    /*	System.out.println(request.toString());
    	if("SIMPLE".equals(request.getInterestType())){
    		Float simpleInterest = interestCalculatorService.calculateSimpleInterest(request);
    		response = new InterestReturnsResponse(simpleInterest, simpleInterest/65); // get the FX rate from JPA or a map
    	}
    	
    	else if("COMPOUND".equals(request.getInterestType())){
    		Float simpleInterest = interestCalculatorService.calculateCompoundInterest(request);
    		response = new InterestReturnsResponse(simpleInterest, simpleInterest/65); // get the FX rate from JPA or a map
    	}*/
    	
    	Optional<InterestCalculationStrategy> interestCalculationStrategy = interestCalculationStrategyFactory.getInterestCalculationStrategy(InterestType.valueOf(request.getInterestType()));
		if(interestCalculationStrategy.isPresent()){
			BigDecimal interest = interestCalculationStrategy.get().calculateInterest(request); 
			response = new InterestReturnsResponse(interest.doubleValue(), interest.doubleValue()/1.29d); // get the FX rate from database or a service
		}
    	
		return response;   	
    }
}