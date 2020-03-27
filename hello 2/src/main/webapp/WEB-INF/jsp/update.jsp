<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Update Information of Student</h1>
	${msg }

	<form action="update" method="post">

		
	Id : <input type = "text" id = "id" name ="id" value = "${id}"/>
	Name : <input type = "text" id = "name" name ="name"/>
	Course : <input type = "text" id = "name" name ="name"/>
	<input type="submit">
	<input type ="reset">
		<input type="submit" name="submit" value="Update" />

	</form>

</body>
</html>