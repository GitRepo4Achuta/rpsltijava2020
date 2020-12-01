package com.hsbc.shoppersden.dao;


import com.hsbc.shoppersden.models.ShopperDenCustomer;
import com.hsbcshoppersden.exceptions.DBConnCreationException;

public interface CustomerDao {

	//CRUD
	boolean addCustomer(ShopperDenCustomer customer) throws DBConnCreationException;
	boolean validateLogin(ShopperDenCustomer customer)throws DBConnCreationException;
	
}
