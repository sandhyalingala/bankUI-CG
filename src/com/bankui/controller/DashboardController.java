package com.bankui.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.bankui.beans.Customer;
import com.bankui.beans.TransferInfo;
import com.bankui.beans.UserInfo;

@Controller
public class DashboardController {
	@Autowired
	private UserInfo user;
	
	@Autowired
	private Customer customer;
	
	@Autowired
	private TransferInfo transfer;
	
String path="dashboard/"; 
	
	@RequestMapping("/dashboard")
	public String showDashboard(Model model) {
		return "dashboard";
	}
	
	@RequestMapping("/transfer")
	public String showTransferScreen(Model model) {//passing object on jsp
		model.addAttribute("transfer", transfer);
		model.addAttribute("msg", "");
		return path+"transfer";
		
		
	}
	@RequestMapping("/deposit")
	public String showDepositScreen(Model model) {
		model.addAttribute("transfer", transfer);
		model.addAttribute("msg", "");
		return path+"deposit";
	}
	
	@RequestMapping("/statement")
	public String showStatementScreen(Model model) {
		model.addAttribute("msg", "");
		return path+"statement";
	}
	
	@RequestMapping("/balance")
	public String showBalanceScreen() {
		
		return "dashboard/show-balance";
	}
	@RequestMapping("/settings")
	public String showSettingsScreen(Model model) {
		model.addAttribute("customer",customer);
		model.addAttribute("msg", "");
		return path+"account_settings";
	}
	
	@RequestMapping("/help")
	public String showHelpScreen(Model model) {
		return path+"help";
	}
	
}
