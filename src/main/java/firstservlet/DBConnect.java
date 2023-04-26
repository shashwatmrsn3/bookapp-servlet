package firstservlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {

	public static Connection getConnection() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
