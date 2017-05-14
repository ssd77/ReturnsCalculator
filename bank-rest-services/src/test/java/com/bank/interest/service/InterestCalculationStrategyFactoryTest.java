package com.bank.interest.service;

import java.util.Optional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.bank.interest.service.impl.CompoundInterestCalculator;
import com.bank.interest.service.impl.SimpleInterestCalculator;

/**
 * The Class InterestCalculationStrategyFactoryTest.
 */
public class InterestCalculationStrategyFactoryTest {

	/** The simple annual interest calculator. */
	@Mock
	private  SimpleInterestCalculator simpleInterestCalculator; 
    /** The simple compound interest Calculator. */
	@Mock
    private  CompoundInterestCalculator compoundInterestCalculator; 
    
		
    /** The factory. */
    @InjectMocks
	private InterestCalculationStrategyFactory factory = new InterestCalculationStrategyFactory();    
	
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		factory.setSimpleInterestCalculator(simpleInterestCalculator);
		factory.setCompoundInterestCalculator(compoundInterestCalculator);		
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test assert get interest calculation strategy.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAssertGetInterestCalculationStrategy() {
		factory.getInterestCalculationStrategy(null);
	}
	
	/**
	 * Test get interest calculation strategy for simple annual interest calculator.
	 */
	@Test
	public void testGetInterestCalculationStrategyForSimpleAnnualInterestCalculator() {
		Optional<InterestCalculationStrategy> interestCalculationStrategy = factory.getInterestCalculationStrategy(InterestType.SIMPLE);
		Assert.assertTrue(interestCalculationStrategy.isPresent());
		Assert.assertTrue(interestCalculationStrategy.get().getClass().getName().contains("SimpleInterestCalculator"));
		
	}
	
	/**
	 * Test get interest calculation strategy for simple compound interest calculator.
	 */
	@Test
	public void testGetInterestCalculationStrategyForSimpleCompoundInterestCalculator() {
		Optional<InterestCalculationStrategy> interestCalculationStrategy = factory.getInterestCalculationStrategy(InterestType.COMPOUND);
		Assert.assertTrue(interestCalculationStrategy.isPresent());
		Assert.assertTrue(interestCalculationStrategy.get().getClass().getName().contains("CompoundInterestCalculator"));
		
	}

}
