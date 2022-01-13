package com.bankui.beans;

import org.springframework.stereotype.Component;

@Component
public class TransferInfo {
 
	public String getToAccountNumber() {
		return toAccountNumber;
	}

	public void setToAccountNumber(String toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	private String toAccountNumber;
	 
	private double amount;

}
