package com.bankui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountOpenRegisterController {
	
	@RequestMapping("/")
	public String getAccountOpenScreen() {
		System.out.println("works");
		return "account_open";
		
	}

}
