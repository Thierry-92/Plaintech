package login;

import java.io.IOException;
import javax.swing.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
import java.io.PrintWriter;
/**
 * Servlet implementation class Hosting
 */
@WebServlet("/Status")
public class Status extends HttpServlet {
	private static final long serialVersionUID = 1L;
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		//Connect database
		Database dbcon = new Database();
		Connection conn = dbcon.returnConnection();
		
		//Variables and shorter and JOption always on front
		HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute("username");
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true); 
		PrintWriter out = response.getWriter();
		//Check if logged in.
		if(session == null || session.getAttribute("username") == null) {
			JOptionPane.showMessageDialog(dialog, "Please login first.");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
	        rs.forward(request, response);
		} else {
			try {
			//Get info from DB.
			Statement st = conn.createStatement();
			st.executeQuery("SELECT status, ram, storage, cpu FROM vms WHERE user_email = '"+ user +"';");
			ResultSet rs = (ResultSet) st.getResultSet();

			//Set variables with information from DB.
			while(rs.next()) {
				int ram = rs.getInt("ram");
				int storage = rs.getInt("storage");
				int cpu = rs.getInt("cpu");
				String status = rs.getString("status");
				
				//Build short htmltable
				String htmlResponse = "<!DOCTYPE html><html><head>";
				 htmlResponse += "<link href='css/style.css' rel='stylesheet' type='text/css' media='all'/>";
				 htmlResponse += "<style> table, th, td {border: 1px solid black; padding: 5px;}</style>";
				 htmlResponse +=  "</head><body>";
		         htmlResponse += "<table><tr><td><b>Current State of Server</b></td><td>" + status +"</td></tr>";
		         htmlResponse += "<tr><td><b>The amount of CPU's</b></td><td>" + cpu +"</td></tr>"; 
		         htmlResponse += "<tr><td><b>The amount of RAM</b></td><td>" + ram +"   GB"+"</td></tr>";   
		         htmlResponse += "<tr><td><b>Amount of diskspace</b></td><td>" + storage +"   GB"+"</td></tr></table>"; 
		         htmlResponse += "<form method='post' action='personalpage.jsp'>";
		         htmlResponse += "<div class='buttons'><button type='submit' value='register' class='grey'>Go back to your personal page</button></div>";
		         htmlResponse += "</form>";
		         htmlResponse += "</html>";
		      
		         out.println(htmlResponse);
<<<<<<< HEAD
			} 
			JOptionPane.showMessageDialog(dialog, "Make a VM first please.");
			RequestDispatcher rss = request.getRequestDispatcher("personalpage.jsp");
	        rss.forward(request, response);
=======
			}
>>>>>>> 4a7f151bbc794bb69f0baf233ebc410b7b9d8297
			}
			
			catch(Exception e)
		     {
		         //making error handling easier (writes to javadoc)
		         e.printStackTrace();
		     }
	}
	
	}
}
