package com.web.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.web.entity.Customer;

@Repository
public class CustomerImpl implements CustomerDAO {

	//injection we are doing here 
	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session currentsession = sessionfactory.getCurrentSession();
		
		Query<Customer> query = currentsession.createQuery("from Customer",Customer.class);
		
		List<Customer> customers = query.getResultList();
		System.out.println(customers.toString());
		return customers;
	}

	@Override
	public Object saveCustomer(Customer thecustomer) {
		
		Session currentsession = sessionfactory.getCurrentSession();
		
		//saveorupdate() will check for primary key, if it is present then to update if not then to save
		currentsession.saveOrUpdate(thecustomer);
		return null;
	}

	@Override
	public Customer getcustomer(int theid) {
		
		Session currentsession = sessionfactory.getCurrentSession();
		
		Customer customer = currentsession.get(Customer.class,theid);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int theid) {
		
		Session currentsession = sessionfactory.getCurrentSession();
		
		//currentsession.delete(theid);
		
		Query theQuery = currentsession.createQuery("delete from Customer where id=:customerid");
		theQuery.setParameter("customerid",theid);
		theQuery.executeUpdate();
	}

}
