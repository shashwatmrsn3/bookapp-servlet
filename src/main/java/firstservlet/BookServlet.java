package firstservlet;

import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/book")
public class BookServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		String isbn = request.getParameter("ISBN");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		Book book = new Book(isbn, name, author);
		BookDAO dao = new BookDAO();
		dao.addBook(book);
	//	request.getRequestDispatcher("index.jsp").forward(request, response);
		response.sendRedirect("index.jsp");
		
	}
}
