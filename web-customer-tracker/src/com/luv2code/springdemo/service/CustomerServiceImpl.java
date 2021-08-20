package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

//// Customer Service Implementation ////
// This class is an implementation of CustomerService Interface.
// (See CustomerService.java Interface for more explanation).

@Service // (See CustomerService.java Interface for explanation).
public class CustomerServiceImpl implements CustomerService {

	// Injecting CustomerDAO. (See CustomerService.java Interface for explanation).
	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional // Define transactions at Service Layer instead of defining 
	               // in DAO. (Removing @Transactional from CustomerDAOImpl). (See CustomerService.java Interface for explanation).
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers(); // Delegating calls to DAO.
		// So when we call getCustomers() method on Service, we will delegate it, 
		// so it will handed  it off to the DAO, and then we will simply return 
		// whatever the DAO had returned.
	}


	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		// delegating the calls from the Service over to our DAO
		customerDAO.saveCustomer(theCustomer);
		// So here, we have to add this .saveCustomer() method to our CustomerDAO Interface,
		// AND ALSO Implement that method in our CustomerDAOImpl class. (See saveCustomer() in CustomerDAOImpl class).
	}

}
