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

import com.bankui.beans.Account;
import com.bankui.beans.Transaction;
import com.bankui.beans.TransferInfo;
import com.bankui.beans.UserInfo;

@Controller
public class TransferController {
	
	@Autowired
	private UserInfo user;
	 
	@RequestMapping("/process-transfer")
	public String showTransferScreen(@ModelAttribute TransferInfo transfer,Model model,HttpSession session) {
		//generate encoded auth_code using username and password in session
		HttpHeaders headers = new HttpHeaders();
		
		String username=(String)session.getAttribute("username");//type cast o to s
		String password=(String)session.getAttribute("password");
		headers.setBasicAuth(username,password );
		//attach header and transfer object to request
		HttpEntity<Object> request= new HttpEntity<>(transfer,headers);
		
		String url="http://localhost:8989/transfer";//post API
		//connect to API
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			ResponseEntity<Transaction> entity=restTemplate.exchange(url,HttpMethod.POST, request, Transaction.class);
			Transaction transaction=entity.getBody();//response as object
			model.addAttribute("transaction", transaction);
			model.addAttribute("msg", "");
			return "dashboard/transfer_confirm";
			
		}
		catch(Exception e) {
			e.printStackTrace();//to print errors
			model.addAttribute("transfer", transfer);
			model.addAttribute("msg", "Transaction failed ,please try after sometime or contact support");
			return "dashboard/transfer";
		}
		
		
		
		
	}
	
	@RequestMapping("/show-balance")
	public String showBalance(Model model,HttpSession session) {
		//generate encoded auth_code using username and password in session
		HttpHeaders headers = new HttpHeaders();
		
		String username=(String)session.getAttribute("username");//type cast o to s
		String password=(String)session.getAttribute("password");
		headers.setBasicAuth(username,password );
		//attach header and transfer object to request
		HttpEntity<Object> request= new HttpEntity<>(headers);
		
		String url="http://localhost:8989/balance";//post API
		//connect to API
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			ResponseEntity<Account> entity=restTemplate.exchange(url,HttpMethod.GET, request, Account.class);
			Account account=entity.getBody();//response as object
			model.addAttribute("account", account);
			model.addAttribute("msg", "");
			return "dashboard/balance";
			
		}
		catch(Exception e) {
			e.printStackTrace();//to print errors
			
			model.addAttribute("msg", "process failed ,please try after sometime or contact support");
			return "dashboard/balance";
		}

	}
}
			
		
