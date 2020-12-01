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
import javax.servlet.http.HttpSession;

import com.hsbc.shoppersden.dao.CustomerDao;
import com.hsbc.shoppersden.dao.CustomerImpl;
import com.hsbc.shoppersden.models.ShopperDenCustomer;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub				
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		ShopperDenCustomer customer=new ShopperDenCustomer();
		CustomerDao customerDao=new CustomerImpl();
		PrintWriter out=response.getWriter();		
		HttpSession session=null;			
	    response.setContentType("text/html");
		try
		{					
		customer.setFirstName(request.getParameter("firstName"));
        customer.setDob(LocalDate.parse(request.getParameter("dob").toString(), 
        		formatter));
        
        if(customerDao.validateLogin(customer))
        {
            session=request.getSession(true);
        	session.setAttribute("movieSession", customer);
        	request.getRequestDispatcher("layout.jsp").forward(request, response);
        }
        else
        {
        	out.println("<p style='float:right;color:red'>Login Credentials are not valid</p>");
        	request.getRequestDispatcher("login.jsp").include(request, response);
        }
		}
		catch(NullPointerException|InputMismatchException exception)
		{
			out.println(exception.getMessage());
		}
		catch(Exception exception)
		{
			out.println(exception.getMessage());
		}
		
	}

}
