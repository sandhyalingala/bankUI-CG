package com.bankui.controller;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.bankui.beans.Account;
import com.bankui.beans.Transaction;
import com.bankui.beans.TransferInfo;

@Controller
public class DepositController {
	
	
	
	@RequestMapping("/process-deposit")
	public String showTransferScreen(@ModelAttribute TransferInfo transfer,Model model,HttpSession session) {
		//generate encoded auth_code using username and password in session
		HttpHeaders headers = new HttpHeaders();
		
		String username=(String)session.getAttribute("username");
		String password=(String)session.getAttribute("password");
		headers.setBasicAuth(username,password );
		//attach header and transfer object to request
		HttpEntity<Object> request= new HttpEntity<>(transfer,headers);
		
		String url="http://localhost:8989/deposit";
		//connect to API
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			ResponseEntity<Account> entity=restTemplate.exchange(url,HttpMethod.POST, request, Account.class);
			Account account=entity.getBody();//response as object
			model.addAttribute("account",account) ;
			model.addAttribute("msg", "deposit ");
			return "dashboard/deposit";
			
		}
		catch(Exception e) {
			e.printStackTrace();//to print errors
			
			model.addAttribute("msg", "Deposit failed ,please try after sometime or contact support");
			return "dashboard/deposit";
		}
		
		
		
		
	}


}
