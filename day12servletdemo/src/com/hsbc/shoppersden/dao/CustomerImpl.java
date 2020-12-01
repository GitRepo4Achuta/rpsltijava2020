package com.hsbc.shoppersden.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;
import com.hsbc.shoppersden.helpers.DBHelper;
import com.hsbc.shoppersden.models.ShopperDenCustomer;
import com.hsbcshoppersden.exceptions.DBConnCreationException;


public class CustomerImpl implements CustomerDao{

	//private Connection conn;
	private PreparedStatement pre;
	private ResultSet resultSet;
	private Statement stmt;
	private boolean status;
	private ResourceBundle resourceBundle;
	private static int customerId;
	
	public CustomerImpl()
	{
			
		resourceBundle=ResourceBundle.getBundle("com/hsbc/shoppersden/resources/db");
	}
	
	

	@Override
	public boolean addCustomer(ShopperDenCustomer customer) throws DBConnCreationException {
		// TODO Auto-generated method stub
		//Automatic resource management
		try(Connection conn=DBHelper.getConnection())
		{
		
		pre=conn.prepareStatement(resourceBundle.getString("addCustomer"));
		customerId=new Random().nextInt(10000)+1;	
			pre.setInt(1,customerId);
			pre.setString(2, customer.getFirstName());
			pre.setString(3, customer.getLastName());
			pre.setDate(4, Date.valueOf(customer.getDob()));	
			pre.setString(5, customer.getCountryName());
			pre.executeUpdate();
			conn.commit();
			status=true;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Error Code"+e.getErrorCode());
		System.out.println(e.getMessage());

		throw new DBConnCreationException("Connection Error Occurred");
	}
	
	
	return status;
	}



	@Override
	public boolean validateLogin(ShopperDenCustomer customer) throws DBConnCreationException {
		// TODO Auto-generated method stub
		boolean status=false;
		//automatic resource management
		try(Connection conn=DBHelper.getConnection())
		{		
			pre=conn.prepareStatement(resourceBundle.getString("loginQuery"));
			pre.setString(1, customer.getFirstName());
			pre.setDate(2,Date.valueOf(customer.getDob()));
			resultSet=pre.executeQuery();
			resultSet.next();
			if(resultSet.getInt(1)>0)
			{
				status=true;
			}	
		  
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new DBConnCreationException("Connection Error Occurred");
		}
		
		return status;
	}

	

}
