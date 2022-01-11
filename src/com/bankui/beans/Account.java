package com.bankui.beans;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Account {
	
	private Long id;
	private String accountNumber;
	private Date dateOfOpening;
	private double balance;

}
