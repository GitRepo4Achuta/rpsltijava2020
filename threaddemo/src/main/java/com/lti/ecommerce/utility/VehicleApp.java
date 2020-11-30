package com.lti.ecommerce.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.lti.ecommerce.threads.Vehicle;
import com.lti.ecommerce.threads.VehicleThread;

public class VehicleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<VehicleThread> vehicleThreads=new ArrayList<VehicleThread>();
		Vehicle vehicle=new Vehicle();
		for(int i=0;i<10;i++)
		{		
			vehicleThreads.add(new VehicleThread(vehicle,"TN-32-"+new Random().nextInt(10000)));
		}
		
		
	}

}
