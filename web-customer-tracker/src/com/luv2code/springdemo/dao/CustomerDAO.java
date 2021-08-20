package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

///// DATA ACCESS OBJECT (DAO) /////
// DAO is used to get the data from the database.
// So basically when the Controller gets the request of any page, and if it requires 
// some data from our database, then DAO gets that data from the database and give it to 
// the Controller so that controller can display that data in the returned web page/view.
// 
// So here in this project, we are using HIBERNATE AS DAO.
//
// So this is our DAO Interface with method getCustomers().
// We will Implement this Interface in CustomerDAOImpl class to actually use this method.
// (See CustomerDAOImpl class for more explanation).

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
