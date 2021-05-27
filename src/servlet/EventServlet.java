package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseAPI;
import model.Event;

@WebServlet("/EventServlet")
public class EventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Event event;
	private String name,address,category;
	private LocalDate startDate,endDate;
	private LocalTime startTime,endTime;
	private HttpSession session;
	private RequestDispatcher requestDispatcher;
	private PrintWriter out;
       
    public EventServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		name = request.getParameter("name");
		category = request.getParameter("category");
		address = request.getParameter("address");
		startDate = LocalDate.parse(request.getParameter("startDate"));
		endDate = LocalDate.parse(request.getParameter("endDate"));
		startTime = LocalTime.parse(request.getParameter("startTime"));
		endTime = LocalTime.parse(request.getParameter("endTime"));
		event = new Event(name,category,address,startDate,endDate,startTime,endTime);
		session = request.getSession();
		out = response.getWriter();
		int id = (Integer)session.getAttribute("user_id");
		if(addEvent(event,id)) {
			requestDispatcher = request.getRequestDispatcher("ngo.jsp");
			out.print("<div\r\n"
					+ "  style=\"background-color:#ff6961; font-weight:700;color:white;box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);width: fit-content;height: 2rem;padding: 1.5rem;display: flex;justify-content: center;align-items: center;position:absolute;left: 43%;top:4rem;\">\r\n"
					+ "  Event Added Successfully \r\n"
					+ "</div>");
			requestDispatcher.include(request, response);
		}else {
			requestDispatcher = request.getRequestDispatcher("ngo.jsp");
			out.print("<div\r\n"
					+ "  style=\"background-color:#ff6961; font-weight:700;color:white;box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);width: fit-content;height: 2rem;padding: 1.5rem;display: flex;justify-content: center;align-items: center;position:absolute;left: 43%;top:2.5rem;\">\r\n"
					+ "  Couldn't Add the Event \r\n"
					+ "</div>");
			requestDispatcher.include(request, response);
		}
	}
	
	private static boolean addEvent(Event event,int id) {
		try {
			Connection connect = DatabaseAPI.connectToDatabase();
			String INSERT_QUERY = "insert into event(name,address,category,start_date,end_date,start_time,end_time,user_id) values(?,?,?,?,?,?,?,?)";
			PreparedStatement insertQuery = connect.prepareStatement(INSERT_QUERY);
			insertQuery.setString(1, event.getName());
			insertQuery.setString(2, event.getAddress());
			insertQuery.setString(3, event.getCategory());
			insertQuery.setDate(4, Date.valueOf(event.getStartDate()));
			insertQuery.setDate(5, Date.valueOf(event.getEndDate()));
			insertQuery.setTime(6, Time.valueOf(event.getStartTime()));
			insertQuery.setTime(7, Time.valueOf(event.getEndTime()));
			insertQuery.setInt(8,id);
			int result = insertQuery.executeUpdate();
			if(result > 0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
