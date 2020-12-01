package com.lti.ecommerce.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.lti.ecommerce.models.Employee;


public class EmployeeDao {

public List<Employee> getAll()
{
	Random rand = new Random();
	List<Employee> employeelist=new ArrayList<Employee>();
    Employee emp =new Employee();
    emp.setEmployeeId(rand.nextInt(100000));
    emp.setName("Sharmila");
    emp.setDOJ(new Date(98,8,7));
    employeelist.add(emp);
    emp =new Employee();
    emp.setEmployeeId(rand.nextInt(100000));
    emp.setName("Nikita");
    emp.setDOJ(new Date(78,8,7));
    employeelist.add(emp);
	return employeelist;
	
}
}
