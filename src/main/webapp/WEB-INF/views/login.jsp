

<!DOCTYPE html>
<html  xmlns:jsp="http://java.sun.com/JSP/Page" >
<head>
<meta charset="ISO-8859-1">
<title>Login with boot</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>

	<form method="post" action="/login" >
		<fieldset >
			<legend  style="float:center">Authentication form</legend>
			<table align="center">
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td><input type="Submit" value="Login" class="btn btn-success"></td>
					<td><input type="submit" value="Sign-Up" formaction="register" class="btn btn-danger"></td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>