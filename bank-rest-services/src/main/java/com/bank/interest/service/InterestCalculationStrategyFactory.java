package com.bank.interest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * A factory for creating InterestCalculationStrategy objects.
 */
@Component
public class InterestCalculationStrategyFactory {
	
	/** The simple  interest calculator.  */
	@Autowired
	private InterestCalculationStrategy simpleInterestCalculator;
    
	/** The compound interest Calculator. */
	@Autowired
	private InterestCalculationStrategy compoundInterestCalculator;
	
    public InterestCalculationStrategy getSimpleInterestCalculator() {
		return simpleInterestCalculator;
	}

	public void setSimpleInterestCalculator(InterestCalculationStrategy simpleInterestCalculator) {
		this.simpleInterestCalculator = simpleInterestCalculator;
	}

	public InterestCalculationStrategy getCompoundInterestCalculator() {
		return compoundInterestCalculator;
	}

	public void setCompoundInterestCalculator(InterestCalculationStrategy compoundInterestCalculator) {
		this.compoundInterestCalculator = compoundInterestCalculator;
	}

    
    /**
     * Gets the interest calculation strategy.
     * @param interestType simple / compound
     * @return the interest calculation strategy
     */
    public Optional<InterestCalculationStrategy> getInterestCalculationStrategy(InterestType interestType) {
  
      Assert.notNull(interestType, "Parameter interestType cannot be null.");
      switch (interestType) {
          case SIMPLE: return Optional.of(getSimpleInterestCalculator());
          case COMPOUND: return Optional.of(getCompoundInterestCalculator());
          default:return Optional.empty();
      }
    }
}
