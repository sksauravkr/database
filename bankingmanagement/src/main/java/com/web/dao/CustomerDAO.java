package com.web.dao;

import java.util.List;

import com.web.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public Object saveCustomer(Customer thecustomer);

	public Customer getcustomer(int theid);

	public void deleteCustomer(int theid);

}
