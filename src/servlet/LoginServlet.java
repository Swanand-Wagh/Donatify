package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import service.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DatabaseAPI;
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String type;
	private String name;
	private static RequestDispatcher requestDispatcher;
	private HttpSession session;
	private static Connection connect;
	private static PrintWriter out;

    public LoginServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		username = request.getParameter("username");
		password = request.getParameter("password");
		name = request.getParameter("name");
		session = request.getSession();
		User user = new User(username,password,"",name,"");
		out = response.getWriter();
		
		try {
			connect = DatabaseAPI.connectToDatabase();
			type = verifyUser(user); // call to function we made
			if(type != null) {
				session.setAttribute("user_id",getUserId(user)); // call to function we made
				String name = UserService.getNameById((int)session.getAttribute("user_id"));
				session.setAttribute("name",name);
				session.setAttribute("currUser", username);
				session.setAttribute("type", type);
				if(type.equals("ngo")) {
					requestDispatcher = request.getRequestDispatcher("ngo.jsp");
					requestDispatcher.forward(request, response);
				}else if(type.equals("user")){
					session.setAttribute("type", "user");
					requestDispatcher = request.getRequestDispatcher("home.jsp");
					requestDispatcher.forward(request, response);
				}
			}
			requestDispatcher = request.getRequestDispatcher("login.jsp");
			out.print("<div\r\n"
					+ "  style=\"background-color:#ff6961; font-weight:700;color:white;box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);width: fit-content;height: 2rem;padding: 1.5rem;display: flex;justify-content: center;align-items: center;position:absolute;left: 40%;top:5rem;\">\r\n"
					+ "  Invalid Email Address or Password \r\n"
					+ "</div>");
			requestDispatcher.include(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static String verifyUser(User user){
		String SELECT_QUERY = "SELECT username,password,type from user ;";
		try {
			Statement selectQuery = connect.createStatement();
			ResultSet users = selectQuery.executeQuery(SELECT_QUERY);
			while(users.next()) {
				if(user.getUsername().equals(users.getString(1)) &&
						user.getPassword().equals(users.getString(2))) {
					return users.getString(3);
				}
			}
			return null;	
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private static int getUserId(User user) {
		String SELECT_QUERY = "SELECT username,password,user_id from user ;";
		try {
			Statement selectQuery = connect.createStatement();
			ResultSet users = selectQuery.executeQuery(SELECT_QUERY);
			while(users.next()) {
				if(user.getUsername().equals(users.getString(1)) &&
						user.getPassword().equals(users.getString(2))) {
					return users.getInt(3);
				}
			}
			return 0;	
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
