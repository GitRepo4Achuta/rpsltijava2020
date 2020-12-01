package com.hsbc.shoppersden.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.InputMismatchException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.shoppersden.dao.CustomerDao;
import com.hsbc.shoppersden.dao.CustomerImpl;
import com.hsbc.shoppersden.models.ShopperDenCustomer;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub	                 
		Enumeration<String> enumeration=request.getParameterNames();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String parameterName=null;
		String value=null;
		ShopperDenCustomer customer=new ShopperDenCustomer();
		List<String> customerData=new ArrayList<String>();
		PrintWriter out=response.getWriter();
	    response.setContentType("text/html");
		try
		{
		while(enumeration.hasMoreElements())
		{			
			parameterName=enumeration.nextElement().toString();
		    value=request.getParameter(parameterName);
		    customerData.add(value);
		}		
		customer.setFirstName(customerData.get(0).toString());
        customer.setLastName(customerData.get(1).toString());
        out.println(customerData.get(2).toString());
        customer.setDob(LocalDate.parse(customerData.get(2).toString(), 
        		formatter));
        customer.setCountryName(customerData.get(3).toString());        
        //out.println("Registered Successfully...");
        //create conn with dao
        CustomerDao customerDao=new CustomerImpl();
        if(customerDao.addCustomer(customer))
               out.println("Registered Successfully...");
        else
        	request.getRequestDispatcher("index.html").forward(request, response);
		
		}
		catch(NullPointerException|InputMismatchException exception)
		{
			out.println(exception.getMessage());
			//out.println(exception.getMessage());
			//response.sendError(response.SC_EXPECTATION_FAILED,"Data Error");
		}
		catch(Exception exception)
		{
			out.println(exception.getMessage());
			//response.sendError(response.SC_EXPECTATION_FAILED,"Data Error");
		}
	}

}
