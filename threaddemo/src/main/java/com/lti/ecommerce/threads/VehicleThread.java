package com.lti.ecommerce.threads;

public class VehicleThread implements Runnable {

	private Vehicle vehicleObj;
	private String vname;
	
	public VehicleThread(Vehicle vehicle,String name ) {
		super();
		this.vehicleObj=vehicle;
		this.vname=name;
		new Thread(this,name).start();
	}

	@Override
	public  void run() {
		// TODO Auto-generated method stub
		//System.out.println(Thread.currentThread().getName());
		synchronized(this.vehicleObj)
		{
		  vehicleObj.getMessage(vname);
		}
		
	}
	
	
	

}
