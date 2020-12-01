/**
 * 
 */

seats=new Array();
window.addEventListener('load',function()
		{
	      //alert("window loaded...");
	      document.querySelector(".confirmButton").addEventListener('click',
	    	     function()
	    	    {
	    	        alert(seats);
	    	        seatSelectionAjaxFunction(seats);
	    	        
	    	    });
	
	
	
	
		});

function seatSelected(btn)
{	
	  
	  seats.push(btn.firstChild.nodeValue);
	  btn.style.backgroundColor="red";
	  btn.disabled=true;	  
	  
}


function seatSelectionAjaxFunction(seats){
    let ajaxRequest;
    try{
        ajaxRequest = new XMLHttpRequest();
    } catch (e){
        try{
            ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP3.0"); }
        catch (e){alert("Your browser broke!");
        return false;
        }
    }

    ajaxRequest.onreadystatechange = function(){
        if(ajaxRequest.readyState == 4 && ajaxRequest.status == 200){         
           
              alert(ajaxRequest.responseText);

        }
    }

    ajaxRequest.open("POST",
        "http://localhost:7070/day12servletdemo/TicketBookingController",
        true);
    ajaxRequest.setRequestHeader("Content-Type","application/x-www-form-urlencoded;"); 		
    ajaxRequest.send("seatsSelected="+seats);
}