
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<h1>Welcome <%= request.getAttribute("userName")%></h1>
	

	<div class="topnav">
		<a class="active" href="">Home</a>		 
		 <a href="/findAllCustomer">Customer</a>
		 <a href="/findAllStock">Stock</a>
		 <a href="">Ledger</a>
		 <a href="/Billing">Billing</a>
		 <a href="">Report</a>
   		 <a href="/login">Logout</a>
	</div>

</body>
</html>