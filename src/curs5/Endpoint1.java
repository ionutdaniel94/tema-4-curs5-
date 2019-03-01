package curs5;

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
@WebServlet("/Endpoint1")
public class Endpoint1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Endpoint1() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numeDinRequest=request.getParameter("nume");
		response.getWriter().append(raspunsServlet(numeDinRequest));
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public String raspunsServlet(String nume) {
		String raspuns ="";
		raspuns+="Felicitari, "+nume+", ai realizat primul servlet!";
		return raspuns;
	}
}
