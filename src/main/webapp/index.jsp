<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="firstservlet.*" %>
<%@ page import="java.util.*" %>

<h1>Book management</h1>

<a href = "addbook.jsp">Add Book</a>

<h3>List of books</h3>
<table border = "1">
	<tr>
		<th>ISBN</th>
		<th>Book Name</th>
		<th>Author</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<%
	System.out.println("hello world");
		BookDAO dao = new BookDAO();
		List<Book> bookList = dao.getBooks();
		for(Book book : bookList){
			%>
			<tr>
		<td><%= book.getIsbn() %></td>
		<td><%= book.getName() %></td>
		<td><%= book.getAuthor() %></td>
		<td><button>Edit</button></td>
		<td><button>Delete</button></td>
	</tr>
	<% 
		}
	%>
	
</table>
</body>
</html>