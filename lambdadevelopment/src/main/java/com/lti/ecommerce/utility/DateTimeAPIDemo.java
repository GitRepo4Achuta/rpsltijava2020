package com.lti.ecommerce.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeAPIDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);
		
		//convert given date time into required zone date time
		LocalDateTime currentDateTime=LocalDateTime.now();
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("MMM-dd-yyyy HH:mm:ss:SS");
		System.out.println(currentDateTime.format(formatter));
		//current zone
		ZonedDateTime currentZone = ZonedDateTime.now();  
		 System.out.println("the current zone is "+ 
		                     currentZone.getZone());  
		 
		 ZoneId selectedZoneId=null; 
		for(String zoneId:ZoneId.getAvailableZoneIds())
		{
			selectedZoneId = ZoneId.of(zoneId); 

		 ZonedDateTime selectedZone = 
		         currentZone.withZoneSameInstant(selectedZoneId); 
		                 
		 System.out.println("Selected time zone is " +  
		                     selectedZone); 

		 DateTimeFormatter format =  
		     DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		   
		 String formatedDateTime = selectedZone.format(format);  

		 System.out.println("formatted selected time zone "+ 
		                     formatedDateTime); 
		}
		
		
		//Date Difference
		LocalDate currentDate=LocalDate.now();
		LocalDate dob=LocalDate.of(1970, 12, 2);
		System.out.println(Period.between(currentDate, dob));
		
		//plus
		LocalDate futureDate=LocalDate.now().plusDays(60);
		System.out.println(futureDate);
		Period period=Period.of(5, 5, 25);
		 futureDate=LocalDate.now().plus(period);
			System.out.println(futureDate);
			
	}

}
