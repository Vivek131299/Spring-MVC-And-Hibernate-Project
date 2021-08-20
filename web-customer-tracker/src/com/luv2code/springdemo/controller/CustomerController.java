package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// INJECTING THE CUSTOMER DAO
	@Autowired // We are making use @Autwired Annotation for dependency injection for this field.
			   // So, Spring will SCAN FOR A COMPONENT that Implements CustomerDAO Interface (which is 
	           // 'CustomerDAOImpl' class in this case) with the help of @Repository Annotation that we 
	           // have given in our CustomerDAOImpl class.
	private CustomerDAO customerDAO;

	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get the customer from the DAO
		List<Customer> theCustomers =  customerDAO.getCustomers();
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		// Above, as we know, 'customers' is the name of attribute and 'theCustomer' is the actual value(which is a List).
		
		return "list-customers";
	}
}
