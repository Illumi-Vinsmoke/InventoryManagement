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
	<h1>Welcome <%= request.getAttribute("userName")%></h1>
	
	<form method="post" action="/saveStock">
		<fieldset>
			<legend>New Stock form</legend>
			<table>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"></td>
				</tr>
			<tr>
					<td>Material</td>
					<td><input type="text" name="material"></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><input type="text" name="category"></td>
				</tr>
				<tr>
					<td>SubCategory</td>
					<td><input type="text" name="subCategory"></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price"></td>
				</tr>
			<tr>
					<td>Discount</td>
					<td><input type="text" name="discount"></td>
				</tr>
				<tr>
					<td>Size</td>
					<td><input type="text" name="size"></td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td><input type="text" name="quantity"></td>
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