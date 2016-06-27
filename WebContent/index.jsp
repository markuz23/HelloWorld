<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello World</title>
</head>
<body>
	<h1>Héctor Alejandro Ajás Terriquez</h1><br>
	<br>
   	<h2>Prueba de integración Java dynamic web project + MongoDB</h2><br>   	
   	<br>
   	<br>
   	
   	<%-- Formulario --%>	
		<form action="AddDataServlet" method="post">
			Data to insert: <input type="text" name="data"><br> 
			<br> 
			<input type="submit" value="Insert Doc">
		</form>
	<br>
</body>
</html>