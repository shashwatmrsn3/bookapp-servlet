<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Add Book</h1>

<form action="book" method = "POST">
	<input type = "text" placeholder = "ISBN" name = "ISBN"/>
	<input type = "text" placeholder = "name" name = "name"/>
	<input type = "text" placeholder = "author" name = "author"/>
	<input type = "submit"/>
</form>
</body>
</html>