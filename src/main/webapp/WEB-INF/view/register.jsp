<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<h3>Registration Page</h3>
	<form action="register" method="post">
		<table>
			<tr>
				<td>Enter ID</td>
				<td><input type="number" name="id"></td>
			</tr>
			<tr>
				<td>Enter Name</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>Enter Phone number</td>
				<td><input type="number" name="phno"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Sign up"></td>
				<td><input type="reset" value="Clear fields"></td>
			</tr>
		</table>
	</form>
</body>
</html>