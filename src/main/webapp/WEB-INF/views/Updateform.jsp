<!DOCTYPE html>
<%@page import="com.inventoryManagement.model.UserModel"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login with boot</title>
</head>
<body>
<%if(session.getAttribute("userName")==null)
	response.sendRedirect("/login");
	%>
	<h1>Welcome <%= request.getAttribute("userName")%></h1>
<%UserModel user=(UserModel)request.getAttribute("User");
%>
	<form method="post" action="/update">
	<input type = "hidden" name="id" value="<%=user.getId() %>" >
		<fieldset>
			<legend>Authentication form</legend>
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="<%=user.getName() %>"></td>
				</tr>
				<tr>
					<td>Contact no</td>
					<td><input type="text" name="conactNo" value="<%=user.getConactNo() %>"></td>
				</tr>
				<tr>
					<td>E-mail</td>
					<td><input type="text" name="email" value="<%=user.getEmail() %>"></td>
				</tr>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" value="<%=user.getUserName() %>"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><select name="rolesName" value="role" >
					<option value="SuperAdmin">SuperAdmin</option>
					<option value="Admin">Admin</option>
					<option value="User">User<option>
					</select></td>
					<td><input type="text" name="roleId"></td>
				</tr>
				<tr>
					<td><input type="Submit" value="Sign-up"></td>
					<td><input type="button" value="Cancel" onclick="history.back()"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>