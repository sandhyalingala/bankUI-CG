package com.bankui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.bankui.beans.Customer;

@Controller
public class AccountOpenRegisterController {
	@Autowired
	private Customer customer;
	
	@RequestMapping("/")
	public String showAccountOpenScreen(Model model) {
		model.addAttribute("customer",customer);
		return "account_open";
	}
	
	@RequestMapping("/create-account")//internal function
	public String showLoginScreen(@ModelAttribute Customer customer) {
		//call the API and pass this customer( 5 details ) object
		String url="http://localhost:8989/customer";//post APIt 
		RestTemplate restTemplate = new RestTemplate();
		Customer c=  restTemplate.postForObject(url, customer, Customer.class);//url,Object request,responseType(class from beans package)
		System.out.println(c);
		return "login";
	}
}
