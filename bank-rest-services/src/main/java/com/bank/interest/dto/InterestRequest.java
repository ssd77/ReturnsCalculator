package com.bank.interest.dto;

public class InterestRequest {
	private Double principal;
	private Double interestRate;
	private Double periods;
	private String interestType;
	private String baseCurrency;

	public Double getPrincipal() {
		return principal;
	}

	public void setPrincipal(Double principal) {
		this.principal = principal;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double rate) {
		this.interestRate = rate;
	}

	public Double getPeriods() {
		return periods;
	}

	public void setPeriods(Double time) {
		this.periods = time;
	}

	public String getInterestType() {
		return interestType;
	}

	public void setInterestType(String interestType) {
		this.interestType = interestType;
	}

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	@Override
	public String toString() {
		return "InterestRequest [principal=" + principal + ", rate=" + interestRate + ", time=" + periods + ", interestType="
				+ interestType + ", baseCurrency=" + baseCurrency + "]";
	}

}
