package curs5;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//get2
/**
 * Servlet implementation class Endpoint1
 */
@WebServlet("/Endpoint2")
public class Endpoint2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Endpoint2() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametrii=request.getQueryString();
		
		ArrayList<String> params=new ArrayList<String>();
		for(int i=0;i<parametrii.split("&").length;i++) {
			String setParametru=parametrii.split("&")[i];
			params.add(setParametru.split("=")[i]);
			System.out.println("Parametrul numarul "+i+" este:"+setParametru.split("=")[i]);
			
		
		response.getWriter().append(raspunsServlet(parametrii.split("&")[i]));

		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public String raspunsServlet(String strings) {
		String raspuns ="";
		raspuns+="Felicitari, "+strings.split("=")[1]+", ai realizat primul servlet! ";
		return raspuns;
	}
}
