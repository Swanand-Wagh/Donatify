package service;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import database.DatabaseAPI;
import model.Event;

public class EventService {
	public static Event getEventById(int id) {
		Event event = new Event();
		try {
			Connection connect = DatabaseAPI.connectToDatabase();
			PreparedStatement selectQuery = connect.prepareStatement("SELECT * from event where event_id = ?");
			selectQuery.setInt(1,id);
			ResultSet result = selectQuery.executeQuery();
			while(result.next()) {
				event.setName(result.getString("name"));
				event.setCategory(result.getString("category"));
				event.setAddress(result.getString("address"));
				event.setStartDate(result.getDate("start_date").toLocalDate());
				event.setEndDate(result.getDate("end_date").toLocalDate());
				event.setStartTime(result.getTime("start_time").toLocalTime());
				event.setEndTime(result.getTime("end_time").toLocalTime());
				event.setNGO(getNgoName(result.getInt("user_id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return event;
	}
	
	public static boolean deleteEventById(int id) {
		try {
			Connection connect = DatabaseAPI.connectToDatabase();
			PreparedStatement selectQuery = connect.prepareStatement("delete from event where event_id = ?");
			selectQuery.setInt(1,id);
			int result = selectQuery.executeUpdate();
			if(result > 0) return true;
			else return false;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	
	public static List<Event> getEventsOfUser(int id){
		List<Event> events = new ArrayList<Event>();
		try {
			Connection connect = DatabaseAPI.connectToDatabase();
			PreparedStatement selectQuery = connect.prepareStatement("SELECT * from event where user_id = ? and end_date > CURDATE()");
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
	
	public static List<Event> getAllEvents(){
		List<Event> events = new ArrayList<Event>();
		try {
			Connection connect = DatabaseAPI.connectToDatabase();
			PreparedStatement selectQuery = connect.prepareStatement("SELECT * from event where end_date > CURDATE() ORDER BY start_date desc;");
			ResultSet result = selectQuery.executeQuery();
			while(result.next()) {
				events.add(
				new Event(result.getInt("event_id"),result.getString("name"),result.getString("category"),
						result.getString("address"),result.getDate("start_date").toLocalDate(),
						result.getDate("end_date").toLocalDate(),result.getTime("start_time").toLocalTime(),
						result.getTime("end_time").toLocalTime(),
						getNgoName(result.getInt("user_id"))
			    ));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return events;
	}
	
	
	public static String getNgoName(int id) {
		String NGO = null;
		try {
			Connection connect = DatabaseAPI.connectToDatabase();
			PreparedStatement selectQuery = connect.prepareStatement("SELECT name from user where user_id = ? ;");
			selectQuery.setInt(1, id);
			ResultSet result = selectQuery.executeQuery();
			while(result.next()) {
				NGO = result.getString(1);
			}
			return NGO;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

}
