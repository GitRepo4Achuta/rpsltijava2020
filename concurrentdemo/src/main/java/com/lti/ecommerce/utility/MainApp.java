package com.lti.ecommerce.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.lti.ecommerce.models.Employee;


public class MainApp {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stub
   
		ExecutorService eservice=Executors.newFixedThreadPool(2);
		
		List<Future<List<Employee>>> futurelist = new ArrayList<Future<List<Employee>>>();
		
		EmployeeTask task =null;
		//Future<List<Employee>> future=null;
		for(int i=0;i<5;i++)
		{
			 task = new EmployeeTask(i);
		     futurelist.add(eservice.submit(task));		      
		}
 		System.out.println(futurelist.size());
 		boolean status=false;
		for(Future<List<Employee>> response : futurelist)
		{
			status=true;
			while(status)
			{
			if(response.isDone())
			{
				System.out.println("Employee List size"+response.get().size());
				try {
					for(Employee emp : response.get())
					{
					 System.out.println(emp.getEmployeeId());
					 System.out.println(emp.getName());
					 System.out.println(emp.getDOJ().getTime());
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					status=false;
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					status=false;
					e.printStackTrace();
				}
				status=false;
			}
			}
			
		}
		
		eservice.shutdown();
	}

}
