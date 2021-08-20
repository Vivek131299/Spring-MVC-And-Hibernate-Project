package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;


///// SERVICE LAYER / @Service ANNOTATION/////
// This is the Interface for our Service Layer (CustomerService).
// The Service layer sits between the Controller and DAO.
// So our CustomerService layer will sit between the CustomerController and CustomerDAO.
//
// Purpose of Service Layer :
// It is an intermediate layer for custom business logic.
// It is also used to INTEGRATE DATA FROM MULTIPLE SOURCES(DAO/Repositories).
//
// Say For example, we have to pull the data for our Customer from different types of locations.
// So we have different DAOs for accessing data from different locations.
// Like: Customer DAO, Sales DAO, License DAO.
//
// So, our Service will INTEGRATE all this together so that we can give the controller a single view 
// of all that data that we have integrated and pulled together.
//
// Spring provides the @Service ANNOTATION. Its a specialized annotation for services.
// @Service Annotation ALSO INHERITS FROM @Component Annotation like @Controller and @Repository Annotations.
// 
// @Service Annotation IS APPLIED TO SERVICE IMPLLEMENTATIONS.
// So we will apply this annotation to CustomerServiceImpl.
//
// So because of COMPONENT SCANNING, Spring will automatically register the Service Implementation.
//
// Steps: 1. Define Service Interface. (which is this interface, CustomerService.java).
//        2. Define Service Implementation. (which is CustomerServiceImpl.java).
//        3. Inject the Customer DAO in our Service Implementation. (We use @Autowired Annotation for injecting).
//
// AND ALSO, previously we have @Transactional annotations in our DAOs (CustomerDAO), 
// BUT NOW, we will move that @Transactional Annotation from our DAOs (CustomerDAO) to actual 
// Implementation methods at our Service Layer.
// BECAUSE now our Service Layer will handle transactions.
//
// So now we will apply @Transactional Annotation to our getCustomers() method IN CustomerServiceImpl class
// INSTEAD OF applying in CustomerDAOImpl class.
// So we will remove it from getCustomer() method IN CustomerDAOImpl class.
//
// AFTER ALL THIS, we need to MODIFY our CONTROLLER (CustomerController.java) to INJECT SERVICE (CustomerService).


public interface CustomerService {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
