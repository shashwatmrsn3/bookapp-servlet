package firstservlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {

	public boolean addUser(User user) {
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into user(email,password) values(?,?)");
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
		
			preparedStatement.execute();
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

	public boolean checkUser(User user) {
		boolean checkUser = false;
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("select count(*) from user where email = ? and password = ?");
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
		
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if(count>0) {
				checkUser =  true;
			}
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return checkUser;
	}
}
