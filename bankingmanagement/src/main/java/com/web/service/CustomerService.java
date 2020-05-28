package com.web.service;

import java.util.List;
import com.web.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer thecustomer);

	public Customer getCustomer(int theid);

	public void deleteCustomer(int theid);

}
