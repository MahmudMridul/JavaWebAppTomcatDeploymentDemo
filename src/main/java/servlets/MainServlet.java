package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import logging.LogConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MainServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		LogConfig.getInstance().log(MainServlet.class, "Start of Get");
		response.setContentType("text/html");
		PrintWriter out = null;
		
		LogConfig.getInstance().log(MainServlet.class, System.getProperty("user.home"));
		LogConfig.getInstance().log(MainServlet.class, System.getProperty("catalina.home"));
		LogConfig.getInstance().log(MainServlet.class, System.getProperty("catalina.base"));
		LogConfig.getInstance().log(MainServlet.class, System.getProperty("java.io.tmpdir"));

		
		
		try
		{
			out = response.getWriter();
			LogConfig.getInstance().log(MainServlet.class, "Getting the number");
			int number = Integer.parseInt(request.getParameter("number"));
			
			out.println("<center>");
			
			LogConfig.getInstance().log(MainServlet.class, "Checking for even odd");
			
			try
			{
				if(number%2==0)
				{
					LogConfig.getInstance().log(MainServlet.class, number+" is even");
					out.println(number + " is even number");
				}
				else
				{
					LogConfig.getInstance().log(MainServlet.class, number+" is odd");
					out.println(number + " is odd number");
				}
			}
			catch(Exception e)
			{
				LogConfig.getInstance().log(MainServlet.class, e.getMessage());
			}
			
			LogConfig.getInstance().log(MainServlet.class, "End of check");
			
			out.println("</center>");
		}
		catch(Exception e) 
		{
			out.println("Error: "+ e.getMessage());
		}
		LogConfig.getInstance().log(MainServlet.class, "End of Get");
	}

}
