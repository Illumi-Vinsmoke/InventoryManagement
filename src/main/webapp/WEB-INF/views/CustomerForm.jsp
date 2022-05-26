<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login with boot</title>
</head>
<body>

<%if(session.getAttribute("userName")==null)
	response.sendRedirect("/login");
	%>
	<h1>Welcome <%= session.getAttribute("userName")%></h1>
	
	<form method="post" action="/saveCustomer">
		<fieldset>
			<legend>Authentication form</legend>
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Contact no</td>
					<td><input type="text" name="conactNo"></td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td><input type="Submit" value="Save"></td>
					<td><input type="button" value="Cancel" onclick="history.back()"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>