$(document).ready(function(e) {

	
		$(".dropdown-menu a").on('click', function(e) {
			 
			  alert($(this).text());
			  $.ajax({
			        type: "GET",
			        contentType: "application/json",
			        url: "/categories",			       
			        dataType: 'json',
			        cache: false,
			        timeout: 600000,
			        success: function (data) {

			        	 $.each(data, function(i, item) {
			         		
			        		console.log(item);
			        	    });
			        	

			        },
			        error: function (e) {

			            
			            alert(e.responseText) ;
			           
			        }
			    });
			  
			});
	

});