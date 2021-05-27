package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DatabaseAPI;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String address,email,type;
	private int event_id,user_id;
	private LocalTime startTime,endTime;
	private RequestDispatcher rd;
	private PrintWriter out;
	
    public EnrollServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		type = request.getParameter("type");
		event_id = Integer.valueOf(request.getParameter("event_id"));
		user_id = (int) request.getSession().getAttribute("user_id");
		email = request.getParameter("email");
		out = response.getWriter();
		if(confirmEmail(user_id,email)) {
			try {
				Connection connect = DatabaseAPI.connectToDatabase();
				PreparedStatement insertQuery = connect.prepareStatement("INSERT into enrollment (event_id,user_id,type,user_address,start_time,end_time) values (?,?,?,?,?,?)");
				insertQuery.setInt(1, event_id);
				insertQuery.setInt(2, user_id);
				insertQuery.setString(3,"In Person");
				insertQuery.setString(4, null);
				insertQuery.setTime(5, null);
				insertQuery.setTime(6,null);
				
				if(type.equals("home")) {
					address = request.getParameter("address");
					startTime = LocalTime.parse(request.getParameter("startTime"));
					endTime = LocalTime.parse(request.getParameter("endTime"));
					insertQuery.setString(3,"Home Delivery");
					insertQuery.setString(4, address);
					insertQuery.setTime(5, Time.valueOf(startTime));
					insertQuery.setTime(6, Time.valueOf(endTime));
				}	
				
				int result = insertQuery.executeUpdate();
				if(result > 0) {
					rd = request.getRequestDispatcher("home.jsp");
					out.print("<div\r\n"
							+ "  style=\"background-color:#ff6961; font-weight:700;color:white;box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);width: fit-content;height: 2rem;padding: 1.5rem;display: flex;justify-content: center;align-items: center;position:absolute;left: 43%;top:5rem;\">\r\n"
							+ "  Event Confirmed Successfully \r\n"
							+ "</div>");
					rd.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}	
		}else {
			rd = request.getRequestDispatcher("home.jsp");
			out.print("<div\r\n"
					+ "  style=\"background-color:#ff6961; font-weight:700;color:white;box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);width: fit-content;height: 2rem;padding: 1.5rem;display: flex;justify-content: center;align-items: center;position:absolute;left: 43%;top:5rem;\">\r\n"
					+ "  Couldn't Confirm the Event, invalid Email \r\n"
					+ "</div>");
			rd.include(request, response);
		}
	}
	
	
	private static boolean confirmEmail(int user_id,String email) {
		String resultEmail= null;
		try {
			Connection connect = DatabaseAPI.connectToDatabase();
			PreparedStatement pst = connect.prepareStatement("SELECT username from user where user_id=?");
			pst.setInt(1, user_id);
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				 resultEmail = result.getString(1); 
			}
			if(resultEmail.equals(email)) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
