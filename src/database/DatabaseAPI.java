package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.User;

public class DatabaseAPI {
	
	public static Connection connectToDatabase() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection(DatabaseConfiguration.url,DatabaseConfiguration.user,DatabaseConfiguration.password);
		return connect;
	}
	
	public static void destroyConnection(Connection connect) throws SQLException {
		connect.close();
	}

}
