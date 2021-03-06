<!DOCTYPE html>
<%@page import="org.springframework.web.servlet.view.RedirectView"%>
<html>
<head>
<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.topnav {
	overflow: hidden;
	background-color: #333;
}

.topnav a {
	float: left;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

.topnav a:hover {
	background-color: #ddd;
	color: black;
}

.topnav a.active {
	background-color: #04AA6D;
	color: white;
}
</style>

</head>
<body>
<%if(session.getAttribute("userName")==null)
	response.sendRedirect("/login");
	%>
	<h1>Welcome <%= session.getAttribute("userName")%></h1>
	<div class="topnav">
		<a class="active" href="">Home</a>
		 <a href="/findAllUser/<%=3%>">View Users</a>
		<a href="/findAllCustomer">View Customers</a>
		<a href="/findAllStock">Stock</a> 
		<a href="">Ledger</a>
		<a href="/Billing">Billing</a>
		<a href="">Report</a>
		<a href="/logout">Logout</a>
	</div>

</body>
</html>