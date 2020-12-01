package com.lti.ecommerce.utility;

import java.util.List;
import java.util.concurrent.Callable;

import com.lti.ecommerce.models.Employee;
import com.lti.ecommerce.services.EmployeeDao;


public class EmployeeTask implements Callable<List<Employee>> {
    private int taskId;
    public EmployeeTask(int id)
    {
    	this.taskId=id;
    }
    
	@Override
	public List<Employee> call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Task returned by"+this.taskId);
		Thread.sleep(2000);
		return new EmployeeDao().getAll();
	}

	
}
