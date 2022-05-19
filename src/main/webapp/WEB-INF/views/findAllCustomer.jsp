<%@page import="com.inventoryManagement.model.CustomerModel"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<form>
		<fieldset>
		<legend>All USERS LIST</legend>
		<Table border="2" class="table table-striped">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Address</th>
				<th>Contact Number</th>
				<th>Email</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<%
			List<CustomerModel> customerRecord = (List<CustomerModel>) request.getAttribute("records");			
			for (CustomerModel customer : customerRecord) {
			%>
			<tr>
				<td><%=customer.getId()%></td>
				<td><%=customer.getName()%></td>
				<td><%=customer.getAddress()%></td>
				<td><%=customer.getConactNo()%></td>
				<td><%=customer.getEmail()%></td>
				<td>
				
				   <a href='/customerUpdateForm/<%=customer.getId()%>'>
				   <Input type="button" value="Update"  class="btn btn-outline-info">
				   </a>
				 </td>
				<td>
				    <a href="/deleteCustomer/<%=customer.getId()%>" >
				    <Input type="button" value="Delete" class="btn btn-outline-danger">				      
				    </a>
				 </td>
					
				<%
				}
				%>
			</tr>
			  <tr>
				 <td colspan="2">
					   <a href="/saveCustomerForm"><input type="button" value="Add new record"  class="btn btn-primary btn-lg"></a>
				 </td>
					
					 
				 <td>
					    <input type="button" value="Go back!" onclick="history.back()" class="btn btn-secondary btn-lg">
				 </td>
				</tr>
		</Table>
		
		</fieldset>
	</form>
</body>
</html>