package login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;
/**
 * Servlet implementation class Hosting
 */
@WebServlet("/Hosting")
public class Hosting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
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
    	
    	//Check if logged in.
    	if(session == null || session.getAttribute("username") == null) {
			JOptionPane.showMessageDialog(dialog, "Please login first before ordering.");
			RequestDispatcher rs = request.getRequestDispatcher("index.html");
            rs.forward(request, response);
    	} else {
    		try {
    		//Get info from DB.
    		Statement st = conn.createStatement();
    		st.executeQuery("SELECT status, ram, storage, cpu FROM vm WHERE email = '"+ user +"';");
    		ResultSet rs = (ResultSet) st.getResultSet();
    		
    		//Set variables with information from DB.
    		while(rs.next()) {
    			int ram = rs.getInt("ram");
    			int storage = rs.getInt("storage");
    			int cpu = rs.getInt("cpu");
    			String status = rs.getString("status");
    			
    			//Build short htmltable
    			String htmlResponse = "<!DOCTYPE html><html><head>";
    			 htmlResponse += "<style> table, th, td {border: 1px solid black;}</style></head><body>";
 		         htmlResponse += "<table><tr><td><b>Current State of Server</b></td><td>&nbsp&nbsp&nbsp&nbsp&nbsp</td><td>" + status +"</td></tr>";
 		         htmlResponse += "<tr><td><b>The amount of RAM</b></td><td></td><td>" + ram +"</td></tr>";   
 		         htmlResponse += "<tr><td><b>The amount of CPU's</b></td><td></td><td>" + cpu +"</td></tr>"; 
 		         htmlResponse += "<tr><td><b>Amount of diskspace</b></td><td></td><td>" + storage +"</td></tr></table>"; 
		         htmlResponse += "</html>";
		         
		         System.out.println(htmlResponse);
    		}
    		
    		}catch(Exception e)
    	     {
    	         //making error handling easier (writes to javadoc)
    	         e.printStackTrace();
    	     }
	}

	}
}
