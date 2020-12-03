$(document).ready(function(e) {

		$('#categoriestableview').hide();
		$('#categoriesformview').hide();
		$(".dropdown-menu a:nth-child(1)").on('click', function(e) {
			$('#categoriestableview').hide();
			$('#categoriesformview').show()
			//alert($(this).text());
		});
	

		$(".dropdown-menu a:nth-child(3)").on('click', function(e) {
			 
			$('#categoriestableview').show();
			$('#categoriesformview').hide();
			 // alert($(this).text());
			  $.ajax({
			        type: "GET",
			        contentType: "application/json",
			        url: "/categories",			       
			        dataType: 'json',
			        cache: false,
			        timeout: 600000,
			        success: function (data) {

			        	$("#categories tr").remove();
			        	var $tr = $('<tr>');			        	
			        	 $.each(data, function(i, item) {
			        			
			        		console.log(item);
			        		 $tr = $('<tr>');
			        		 $tr.append(
				         	            $('<td>').text(item.categoryId)
				         	        ); //	
			        		 $tr.append(
				         	            $('<td>').text(item.name)
				         	        ); //        		 
			        		         		 
			        		 
			        		 $('#categories').append($tr);
			        		 
			        		   $.each(item.products,function(i,product)
			        			{
			        			   console.log(product);
					        		 $tr = $('<tr>');
					        		 $tr.append(
						         	            $('<td>').text(product.productId)
						         	        ); //	
					        		 $tr.append(
						         	            $('<td>').text(product.productName)
						         	        ); //       
					        		 $tr.append(
						         	            $('<td>').text(product.dop)
						         	        ); //    
					        		 $tr.append(
						         	            $('<td>').text(product.cost)
						         	        ); //    
					        		         		 
					        		 $('#categories').append($tr);
			        			}	   
			        		   )
			        		 
			        		  
				             		 
			        		 
			        	    });		        	 
			        	
			        	
			        },
			        error: function (e) {

			            
			            alert(e.responseText) ;
			           
			        }
			    });
			  
			});
	

});