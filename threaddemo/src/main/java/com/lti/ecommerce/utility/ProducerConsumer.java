package com.lti.ecommerce.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumer implements Runnable{

	private List<String> messages;
	
	public ProducerConsumer()
	{
		messages=new ArrayList<String>();
	}
	public synchronized void write() throws InterruptedException
	{
		
	 while(true)
	 {
		if(messages.size()==0)
		{
			System.out.println("Creating bulk of 10 memes!!!");	
			
			for(int i=0;i<10;i++)
			  messages.add("meme-"+i);
		  Thread.sleep(2000);
		  notifyAll();
		}
		else
			wait();
	 }
	}
	
	public synchronized  void read() throws InterruptedException
	{
		while(true)
		{
			
		if(messages.size()==0)
			wait();
		else
		{
			
			
		 for(String msg : messages)	
		 {
			 System.out.println(Thread.currentThread().getName()+"Reading\t"+msg);
			Thread.sleep(1000);
		 }
		 
		 
			messages.clear();
			notify();
		}
		}
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	try
	{
		if(Thread.currentThread().getName().equals("Producer"))
			write();
		else
			read();
		
	}
	catch(InterruptedException ex)
	{
		
	}
		
	}

	
	

}
