package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

///// IMPLEMENTING DAO INTERFACE /////
// (See CustomerDAO Interface for DAO explanation).
// Here we will implement our CustomerDAO Interface in this class.


///// @REPOSITORY ANNOTATION /////
// Spring has this special @Repository Annotation for DAOs.
// @Repository Annotation we apply at the top of our DAO Implementation.
//
// While Spring does Component Scanning, we know that it scans by using @Component Annotation for our java Beans,
// and we have also seen @Controller Annotation in Spring MVC to handle auto component scanning.
//
// So here, @Controller and @Repository are the subclasses of @Component Annotation.
// So, it means that if we give @Repository Annotation over our DAO Implementation class, 
// then our class will also e available FOR AUTO-COMPONENT SCANNING.
//
// So whenever in some controller/class, if we want to use this DAO_implementation/class to get some data from database,
// we will INJECT THE DEPENDENCY for this DAO Implementation class(CustomerDAOImpl) using
// the @Autowired Annotation. (See CustomerController class).
//
// For this Annotation, Spring will also provide translation of any JDBC related exceptions.
// So, any checked exceptions that will be thrown, Spring will translate that those to 
// unchecked exceptions.

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	///// INJECTING THE HIBERNATE SESSION FACTORY /////
	
    // @Autowired Annotation is used to injecting dependency.
	// Here we are injecting the dependency for hibernate Session Factory into DAO.
	// So 'sessionFactory' is actually the BEAN ID in our configuration file.(See spring-mvc-crud-demo-servlet.xml file).
	@Autowired
	private SessionFactory sessionFactory;
	
	
	///// @TRANSACTIONAL ANNOTATION /////
	// In Hibernate before, we have seen that we have to start/begin and commit/end transaction manually.
	// So, @Transactional Annotation do this for us. We just have to define it on the method in which
	// we want to use transaction. It will handle the beginning as well as committing the transaction.
	// So now, no need to manually begin and commit the transaction.
	
	@Override
	/*@Transactional*/	// REMOVING @Transactional later on due to adding new SERVICE LAYER. (See CustomerService.java Interface for explanation).
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		// this query will return list of customers.
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results.		
		return customers;
	}

}
