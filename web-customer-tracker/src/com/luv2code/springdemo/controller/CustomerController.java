package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	
	/*@RequestMapping("/list")*/
	///// @GETMAPPING AND @POSTMAPPING /////
	// When we send data over Spring MVC Controller, we have an html form. We send a REQUEST, controller
	// processes it and send us back a RESPONSE.
	// So, GET and POST are some commonly used HTTP Methods.
	//
	// GET is used to Request data from given source and
	// POST is used to SUBMIT data to given source.
	//
	////// @GetMapping /////
	//
	// So to send data with GET method, we set up our form and then we specify method=GET in html form tag.
	// So after submitting the form, it gets appended to the end of the URL as name & value pairs.
	// like- theUrl?field1=value1&field2=value2...
	//
	// To handle submission of form we know that we use @RequestMapping and give the actual path in it.
	//
	// So @RequestMapping handles ALL OF THE HTTP METHODS (like GET, POST, etc.).
	//
	// But if we want our Mapping to ONLY HANDLE GET Requests, then we can write it as:
	//
	/*@RequestMapping(path="/list", method=RequestMethod.GET)*/
	//
	// So this will ONLY HANDLE GET Requests. ANY OTHER HTTP Request method will GET REJECTED.
	//
	// BUT instead of writing such a long statement for Mapping, 
	// we can ALSO WRITE IT USING @GetMapping Annotation as:
	//
	@GetMapping("/list")
	// So it will ONLY HANDLE GET Requests.
	public String listCustomers(Model theModel) {
		
		// get the customer from the DAO
		List<Customer> theCustomers =  customerDAO.getCustomers();
		
		// add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		// Above, as we know, 'customers' is the name of attribute and 'theCustomer' is the actual value(which is a List).
		
		return "list-customers";
	}
	
	///// @PostMapping /////
	// So to send data with POST Method, we specify method=POST in html form tag.
	// So in this case, the form data is passed in the body of the HTTP request message while sending a request to controller.
	// And similar to above GET method, we can specify POST method using Annotation like:
	//
	/*@RequestMapping(path="/list", method=RequestMethod.GET)*/
	//
	// So this will ONLY HANDLE POST Requests. ANY OTHER HTTP Request method will GET REJECTED.
	// BUT instead of writing such a long statement for Mapping, 
	// we can ALSO WRITE IT USING @PostMapping Annotation as:
	//
	/*@PostMapping("/list")*/
	//
	// So it will ONLY HANDLE POST Requests.
	
	
	////////// Which one to use? @GetMapping OR @PostMapping //////////
	// Both has its own Advantages and Disadvantages.
	//
	// GET : Good for Debugging because we can see everything on URL.
	//		 Bookmark or email URL
	//		 Limitations on data length.
	//
	// POST : Can't bookmark or email
	//		  No Limitations on data length
	//		  Can also send binary data.
	//

}
