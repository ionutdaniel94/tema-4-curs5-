package curs5;
import java.io.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//get1
/**
 * Servlet implementation class Endpoint1
 */
@WebServlet("/Endpoint3")
public class Endpoint3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Endpoint3() {
        super();
       
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	        response.setContentType("text/html;charset=UTF-8");
    	        PrintWriter out = response.getWriter();
    	        try {
    	            out.println("<html>");
    	            out.println("<head>");
    	            out.println("<title>Demo of Data Persistence</title>");
    	            out.println("</head>");
    	            out.println("<body>");

    	    
    	        	String driver = "com.mysql.cj.jdbc.Driver";
    	        	String url ="jdbc:mysql://localhost:3306/curs_4";
    	    		String username ="root";
    	    		String password = "";
    	    		try {
    	    		// Load database driver if it's not already loaded.
    	    			Class.forName(driver);
    	              // Establish network connection to database.
    	              Connection connection = DriverManager.getConnection(url, username, password);
    	              // Create a statement for executing queries.
    	              Statement statement = connection.createStatement();
    	              String query =
    	                "SELECT * FROM contact WHERE nume='Dan'";
    	              // Send query to database and store results.
    	              ResultSet resultSet = statement.executeQuery(query);

    	              while(resultSet.next()) {

    	            	  String nume = resultSet.getString("nume");
    	                out.println("Your name is " + nume);


    	              }
    	             
    	            } catch(Exception sqle) {
    	            	sqle.printStackTrace();
    	              System.err.println("Error with connection: " + sqle);
    	              // Again, for debug purpose
    	              out.println("<tr>  Error with connection: " + sqle);
    	              out.println("</tr>");
    	            }

    	            out.println("</table>");
    	            out.println("</body>");
    	            out.println("</html>");
    	        } finally { 
    	            out.close();
    	        }
    	    } 
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	 public String getServletInfo() {
	        return "Short description";
	}
}
