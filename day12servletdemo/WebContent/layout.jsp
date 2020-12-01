<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   import="com.hsbc.shoppersden.models.*"  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./styles/layout.css"/>
<script type="text/javascript" src="./scripts/layout.js"></script>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<%!int capacity=200;
  String name=null; 
  ShopperDenCustomer customer=null;
%>
<%
if(!session.isNew())
{
 out.println("<h1>PVR PLAZA Welcomes You!!!!</h1>"); 
 customer=(ShopperDenCustomer)session.getAttribute("movieSession");
 
 %>
 <h4>Welcome <%=customer.getFirstName() %>!</h4>
<section id="main">
<figure id="screen">
<img src="./resources/images/screen.jpg"/>
</figure>


<%
for(int i=100;i<capacity;i++)
{
		
 	
	if(i%10==0)
	{
 %>
    <section class="layout-row">
    </section>
    <br>
   
    <% 
	}	
	if(i%5==0)
	{
	%>
	<button id="passage"></button>	
	<%
	 }
	%>
<%--expression tag --%>
<button class="button" onclick="seatSelected(this)"><%=i%></button>
<%		
}
%>



</section>

<section id="confirm">
<button class="confirmButton">Confirm</button>
</section>
<% 
}
else
{
	%>
	<jsp:forward page="login.jsp"></jsp:forward>
	<%
}
%>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>