package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DatabaseAPI;
import model.Event;
import model.User;

public class UserService {
	public static String getNameById(int id) {
		String name = null;
		try {
			Connection connect = DatabaseAPI.connectToDatabase();
			PreparedStatement selectQuery = connect.prepareStatement("SELECT name from user where user_id = ? ;");
			selectQuery.setInt(1, id);
			ResultSet result = selectQuery.executeQuery();
			while(result.next()) {
				name = result.getString(1);
			}
			return name;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}
	
	public static User getUserById(int id) {
		User user = new User();
		try {
			Connection connect = DatabaseAPI.connectToDatabase();
			PreparedStatement selectQuery = connect.prepareStatement("SELECT * from user where user_id = ?");
			selectQuery.setInt(1,id);
			ResultSet result = selectQuery.executeQuery();
			while(result.next()) {
				user.setName(result.getString("name"));
				user.setUsername(result.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return user;
	}
}
