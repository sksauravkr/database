package com.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.dao.CustomerDAO;
import com.web.dao.CustomerImpl;
import com.web.entity.Customer;
import com.web.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String listCustomers(@Valid Model model,BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("error!");
			return "welcome";
		}
		
		List<Customer> customers = customerService.getCustomers();
		
		model.addAttribute("customer",customers);
		
		return "listCustomers";
	}
	
	@RequestMapping("/showFormForAdd")
	public String addCustomer(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer",customer);
		
		return "customerForm";
	}
	
	@RequestMapping("/addcustomer")
	public String addCustomer(@ModelAttribute("customer") Customer thecustomer) {
		
		customerService.saveCustomer(thecustomer);
		return "redirect:/list";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theid,Model model) {
		
		Customer customer = customerService.getCustomer(theid);
		
		model.addAttribute("customer",customer);
		
		return "customerForm";
	}
	
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theid) {
		
		customerService.deleteCustomer(theid);
		return "redirect:/list";
	}
	

}
