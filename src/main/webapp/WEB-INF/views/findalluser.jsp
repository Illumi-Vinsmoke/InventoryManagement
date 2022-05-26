<%@page import="com.inventoryManagement.repository.UserRoleMappingRepository"%>
<%@page import="com.inventoryManagement.model.UserRoleMapping"%>
<%@page import="com.inventoryManagement.model.UserModel"%>
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

<%if(session.getAttribute("userName")==null)
	response.sendRedirect("/login");
	%>
	<h1>Welcome <%= request.getAttribute("userName")%></h1>
	
	<form>
		<fieldset>
		<legend>All USERS LIST</legend>
		<Table border="2" class="table table-dark table-striped">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>User Name</th>
				<th>Contact Number</th>
				<th>Email</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
			<%
			List<UserModel> userRecord = (List<UserModel>) request.getAttribute("userRecord");			
			for (UserModel user : userRecord) {
			%>
			<tr>
				<td><%=user.getId()%></td>
				<td><%=user.getName()%></td>
				<td><%=user.getUserName()%></td>
				<td><%=user.getConactNo()%></td>
				<td><%=user.getEmail()%></td>
				<td>
				
				   <a href='/updateform/<%=user.getId()%>'>
				   <Input type="button" value="Update" class="btn btn-info">
				   </a>
				 </td>
				<td>
				    <a href="/deleteUser/<%=user.getId()%>/<%=request.getAttribute("role")%>" >
				    <Input type="button" value="Delete" class="btn btn-danger">				      
				    </a>
				 </td>
					
				<%
				}
				%>
			</tr>
			  <tr>
				 <td colspan="2">
					   <a href="/register"><input type="button" value="Add new record" class="btn btn-success"></a>
				 </td>
					
					 
				 <td>
					    <input type="button" value="Go back!" onclick="history.back()" class="btn btn-secondary">
				 </td>
				</tr>
		</Table>
		
		</fieldset>
	</form>
</body>
</html>