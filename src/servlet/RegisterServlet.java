package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DatabaseAPI;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String confirmPassword;
    private String userType;
    private String name;
    private String license;
    private static RequestDispatcher requestDispatcher;
    private static Connection connect;
    private static PrintWriter out;
    
    public RegisterServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out = response.getWriter();
		username = request.getParameter("username");
		password = request.getParameter("password");
		confirmPassword = request.getParameter("cpassword");
		userType = request.getParameter("user-type");
		name = request.getParameter("name");
		license = request.getParameter("license");
		
		if(password.equals(confirmPassword)){
			User user = new User(username,password,userType,name,license);
			try {
				connect = DatabaseAPI.connectToDatabase();
				if(!doesUserExist(user)) {
					if(addUser(user)) {
						requestDispatcher = request.getRequestDispatcher("login.jsp");
						requestDispatcher.forward(request, response);
					}else {
						requestDispatcher = request.getRequestDispatcher("signup.jsp");
						out.print("<div class='error'>Sign up Unsuccessful !</div>");
						requestDispatcher.include(request, response);
					}
				}else {
					requestDispatcher = request.getRequestDispatcher("signup.jsp");
					out.print("<div\r\n"
							+ "  style=\"background-color:#ff6961; font-weight:700;color:white;box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);width: fit-content;height: 2rem;padding: 1.5rem;display: flex;justify-content: center;align-items: center;position:absolute;left: 43%;top:2.5rem;\">\r\n"
							+ "  User Already Exists \r\n"
							+ "</div>");
					requestDispatcher.include(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					DatabaseAPI.destroyConnection(connect);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}else {
			requestDispatcher = request.getRequestDispatcher("signup.jsp");
			out.print("<div\r\n"
					+ "  style=\"background-color:#ff6961; font-weight:700;color:white;box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);width: fit-content;height: 2rem;padding: 1.5rem;display: flex;justify-content: center;align-items: center;position:absolute;left: 43%;top:2.5rem;\">\r\n"
					+ "  Passwords don't match\r\n"
					+ "</div>");
			requestDispatcher.include(request, response);
		}
	}
	
	private static boolean addUser(User user) {
		String INSERT_QUERY = null;
		if(user.getUserType().equals("ngo")) { // method of User.java
			INSERT_QUERY = "INSERT into user (username,password,type,name,license) values(?,?,?,?,?);";
		}else {
			INSERT_QUERY = "INSERT into user (username,password,type,name) values(?,?,?,?);";
		}
		 
		try {
			PreparedStatement insertQuery = connect.prepareStatement(INSERT_QUERY);
			insertQuery.setString(1,user.getUsername());
			insertQuery.setString(2,user.getPassword());
			insertQuery.setString(3,user.getUserType());
			insertQuery.setString(4,user.getName());
			if(user.getUserType().equals("ngo")) {
				insertQuery.setString(5,user.getLicense());
			}
			int result = insertQuery.executeUpdate();
			if(result > 0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static boolean doesUserExist(User user) {
		String SELECT_QUERY = "SELECT username from user;";
		try {
			Statement selectQuery = connect.createStatement();
			ResultSet users = selectQuery.executeQuery(SELECT_QUERY);
			while(users.next()) {
				if(user.getUsername().equals(users.getString(1))) {
					return true;
				}
			}
			return false;	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
