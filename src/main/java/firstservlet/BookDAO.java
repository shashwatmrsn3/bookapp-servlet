package firstservlet;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.*;

public class BookDAO {

	public boolean addBook(Book book) {
		try {
			Connection connection = DBConnect.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into book(isbn,name,author) values(?,?,?)");
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getName());
			preparedStatement.setString(3, book.getAuthor());
			preparedStatement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public List<Book> getBooks(){
		List<Book> bookList = new ArrayList<Book>();
		try {
			Connection connection = DBConnect.getConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from book");
			while(rs.next()) {
				Book book = new Book(rs.getString(2),rs.getString(3),rs.getString(4));
				bookList.add(book);
			}
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bookList;
	}
}
