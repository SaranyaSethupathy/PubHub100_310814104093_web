<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body bgcolor="CC6699">
	<h1>
		<b>LOGIN UR ACCOUNT ,<%
			out.println(session.getAttribute("registered user"));
		%></b>
	</h1>

	<form action="LoginServlet" method="post">
		<font face="Times New Roman" size="+3" color="BLACK"> <br>
		<br> EMAIL_ID<input type="email" name="email"> <br>
			PASSWORD<input type="password" name="password"> <br>
			<button type="submit">LOGIN</button>
		</font>
	</form>


</body>
</html>