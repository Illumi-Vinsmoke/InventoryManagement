<!DOCTYPE html>
<%@page import="com.inventoryManagement.model.CustomerModel"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login with boot</title>
</head>
<body>
	<form method="post" action="/updateCustomer">
		<fieldset>
			<legend>Update form</legend>
			<%CustomerModel customer=(CustomerModel)request.getAttribute("User"); %>
			<table>
			<tr>
					<td>Id</td>
					<td><input type="text" name="id" value="<%=customer.getId() %>"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="<%=customer.getName() %>"></td>
				</tr>
				<tr>
					<td>Contact no</td>
					<td><input type="text" name="conactNo" value="<%=customer.getConactNo() %>"></td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input type="text" name="email" value="<%=customer.getEmail() %>"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" value="<%=customer.getAddress() %>"></td>
				</tr>
				<tr>
					<td><input type="Submit" value="Update" ></td>
					<td><input type="button" value="Cancel" onclick="history.back()"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>