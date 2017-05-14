package com.bank.interest.dto;

public class InterestReturnsResponse {

	private Double returnBaseCurrency;

	private Double returnUSD;

	public InterestReturnsResponse(Double returnBaseCurrency, Double returnUSD) {
		this.returnBaseCurrency = returnBaseCurrency;
		this.returnUSD = returnUSD;
	}

	public Double getReturnBaseCurrency() {
		return returnBaseCurrency;
	}

	public void setReturnBaseCurrency(Double returnBaseCurrency) {
		this.returnBaseCurrency = returnBaseCurrency;
	}

	public Double getReturnUSD() {
		return returnUSD;
	}

	public void setReturnUSD(Double returnUSD) {
		this.returnUSD = returnUSD;
	}
}
