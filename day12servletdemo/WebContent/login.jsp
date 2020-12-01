<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./styles/login.css"/>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<section id="login">
 <form id="loginForm" method="post" action="LoginController">
 <fieldset>
 <legend>Login Form</legend>
           <input type="text" name="firstName" required placeholder="First Name"  />
           <input type="date" name="dob" required placeholder="DOB" />           
           <button>Login</button>
 </fieldset>          
 </form>
 </section>
 <%--after submission--%>
 <%-- <%
  if((request.getParameter("firstName")!=null)&&(request.getParameter("dob")!=null))
  {
	  //out.println(request.getParameter("firstName"));
	  //out.println(request.getParameter("dob"));
  } 
 
 
 %> --%>
 
 
 
 <jsp:include page="footer.jsp"></jsp:include>
 
</body>
</html>