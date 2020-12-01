package com.lti.ecommerce.utility;



public class InterThreadCommnDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProducerConsumer pc=new ProducerConsumer();
		Thread t1 = new Thread(pc,"Producer");
		Thread t2 = new Thread(pc,"Consumer-1");
		Thread t3 = new Thread(pc,"Consumer-2");
		Thread t4 = new Thread(pc,"Consumer-3");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
