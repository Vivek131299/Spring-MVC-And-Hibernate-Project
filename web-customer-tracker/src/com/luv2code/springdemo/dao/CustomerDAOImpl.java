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
		
		// create a query, AND sort this by the last name. (By using '... order by lastName' in the HQL query).
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		// this query will return list of customers.
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results.		
		return customers;
	}


	@Override
	public void saveCustomer(Customer theCustomer) {

		// Get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer FINALLY.
		/*currentSession.save(theCustomer);*/
		
		// Commenting above save() method because,
		// While UPDATING the customer, we will make use of saveOrUpdate() method of Hibernate instead of
		// above save() method.
		// saveOrUpdate() method CHECKS that whether the passed customer is already available in the table
		// by its primary key (id). If not, then it ADDS that data into database.
		// AND if the data/entry is present for that primary key(id), then it will UPDATE that previous data
		// with the new one.
		// So no need to call different methods for saving and updating the data. We can call saveOrUpdate()
		// method that will handle both.
		
		// save/update the customer
		currentSession.saveOrUpdate(theCustomer);
		
	}


	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using  the primary key(theId)
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}


	@Override
	public void deleteCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Delete object with primary key
		/*Customer theCustomer = currentSession.get(Customer.class, theId);
		currentSession.delete(theCustomer);*/
		// We can also delete by using HQL Query instead of above like:
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId); // Setting value for above used parameter 'customerId'.
		
		theQuery.executeUpdate();
		
	}

}
