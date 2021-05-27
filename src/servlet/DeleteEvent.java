package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.EventService;


@WebServlet("/DeleteEvent")
public class DeleteEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static RequestDispatcher rd;
	private static PrintWriter out;
	
    public DeleteEvent() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.valueOf(request.getParameter("id"));
		rd = request.getRequestDispatcher("ngo.jsp");
		out = response.getWriter();
		
		if(EventService.deleteEventById(id)) {
			out.print("<div\r\n"
					+ "  style=\"background-color:#ff6961; font-weight:700;color:white;box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);width: fit-content;height: 2rem;padding: 1.5rem;display: flex;justify-content: center;align-items: center;position:absolute;left: 43%;top:5rem;\">\r\n"
					+ "  Event Deleted Succefully \r\n"
					+ "</div>");
		}
		rd.include(request, response);
	}

}
