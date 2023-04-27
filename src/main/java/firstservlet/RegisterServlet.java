package firstservlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
				
				String email = request.getParameter("email");
				String password = request.getParameter("password");
				
				User user = new User(email, password);
				UserDAO dao = new UserDAO();
				dao.addUser(user);
				response.sendRedirect("login.jsp");
				
			}
}
