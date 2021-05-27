package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseAPI;
import model.Event;

public class EnrollmentService {
	public static List<Event> getEventsOfUser(int id){
		List<Event> events = new ArrayList<Event>();
		try {
			Connection connect = DatabaseAPI.connectToDatabase();
			PreparedStatement selectQuery = connect.prepareStatement("SELECT * from event where user_id = ?");
			selectQuery.setInt(1,id);
			ResultSet result = selectQuery.executeQuery();
			while(result.next()) {
				events.add(
				new Event(result.getInt("event_id"),result.getString("name"),result.getString("category"),
						result.getString("address"),result.getDate("start_date").toLocalDate(),
						result.getDate("end_date").toLocalDate(),result.getTime("start_time").toLocalTime(),
						result.getTime("end_time").toLocalTime(),""
			    ));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return events;
	}
}
