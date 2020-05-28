package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.CustomerDAO;
import com.web.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDAO customerdao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		return customerdao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer thecustomer) {
		 
		customerdao.saveCustomer(thecustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theid) {
		
		return customerdao.getcustomer(theid);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theid) {
		
		customerdao.deleteCustomer(theid);
	}

}
