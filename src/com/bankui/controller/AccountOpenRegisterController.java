package com.bankui.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.bankui.beans.Customer;
import com.bankui.beans.UserInfo;

@Controller
public class AccountOpenRegisterController {
	@Autowired
	private Customer customer;
	
	@Autowired
	private UserInfo user;
	
	@RequestMapping("/")
	public String showAccountOpenScreen(Model model) {
		model.addAttribute("customer",customer);
		return "account_open";
	}
	
	@RequestMapping("/create-account")//internal function
	public String showLoginScreen(@ModelAttribute Customer customer,Model model) {
		//call the API and pass this customer( 5 details ) object
		String url="http://localhost:8989/customer";//post APIt 
		RestTemplate restTemplate = new RestTemplate();
		Customer c=  restTemplate.postForObject(url, customer, Customer.class);//url,Object request,responseType(class from beans package)
		//System.out.println(c);
		model.addAttribute("user", user);
		model.addAttribute("msg", "");
		return "login";
	}
	
	/*whatever user name and password word given by user is plain text format
	 * we are not passing it to back end that values but converted to encoded_auth code
	 * (internally spring converts using Base64 coding technique)
	 * and attach it to header and sent for security purpose
	 */
	@RequestMapping("/process-login")
	public String processLogin(@ModelAttribute UserInfo user,Model model,HttpSession session) {
		
		//generate encoded auth_code using user name and password and attach it to header
		HttpHeaders headers =  new HttpHeaders();
		headers.setBasicAuth(user.getUsername(), user.getPassword());
		
		//attach this headers to request Object
		HttpEntity<Object> request= new HttpEntity<>(headers);
		
		//call API
		RestTemplate restTemplate = new RestTemplate();
		String url="http://localhost:8989/user";
		
		try {
			ResponseEntity<UserInfo> entity=restTemplate.exchange(url, HttpMethod.GET, request,UserInfo.class);
			UserInfo u =entity.getBody();//returns body of this entity
			session.setAttribute("username", u.getUsername()); //JSESSIONID
			session.setAttribute("password", user.getPassword());//plain text password stored
			model.addAttribute("user", u);//displaying userInfo on dash board
			return "dashboard";
		}
		catch(Exception e){
		   model.addAttribute("user", user);
		   model.addAttribute("msg", "Invalid Credentials");
		   return "login";
		}
		
		
	}
	
	@RequestMapping("/login")
	public String showLoginScr(Model model) {
		model.addAttribute("user", user);
		model.addAttribute("msg", "");
		return "login";
		
	}
	
	@RequestMapping("/logout")
	public String showLogout(Model model,HttpSession session) {
		model.addAttribute("user", user);
		model.addAttribute("msg", "You are logged out");
		session.invalidate();
		return "login";
		
	}
	
	
}
