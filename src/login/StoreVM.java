package login;

import java.io.IOException;
import java.sql.*;
<<<<<<< HEAD
import java.sql.PreparedStatement;
=======
>>>>>>> 818061de85655ac1b48a33bd1fd66ae8182f6372
import javax.swing.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class storeVM
 */
@WebServlet("/storeVM")
public class StoreVM extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreVM() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		//Declare some things.
		HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute("username");
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);  
		
		try { 
		//Connect database
		Database dbcon = new Database();
		Connection con = dbcon.returnConnection();
<<<<<<< HEAD
		PreparedStatement ps = con.prepareStatement("INSERT INTO vms VALUES(?,?,?,?,?)");
=======
		Statement statement = con.createStatement();
		
>>>>>>> 818061de85655ac1b48a33bd1fd66ae8182f6372
		
		if (JOptionPane.showConfirmDialog(dialog, "Are you sure?", "WARNING",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			//Make some variables and shorter things.
			int button = Integer.parseInt(request.getParameter("vmstore"));

			//Check if session is set.
			if(session == null || session.getAttribute("username") == null) {
				JOptionPane.showMessageDialog(dialog, "Please login first before ordering.");
				RequestDispatcher rs = request.getRequestDispatcher("index.html");
	            rs.forward(request, response);
			} else {
				
				if(button == 1) {
<<<<<<< HEAD
					ps.setString(1, user);
					ps.setString(2, "running");
					ps.setInt(3, 1);
					ps.setInt(4, 2);
					ps.setInt(5, 50);
					int updated =ps.executeUpdate();
=======
					String sql = "INSERT INTO vms (cpu, ram, storage, status) VALUES (1,2,50,running) WHERE email = "+ user +"";
					int updated = statement.executeUpdate(sql);
>>>>>>> 818061de85655ac1b48a33bd1fd66ae8182f6372
					if (updated > 0 ) {
					JOptionPane.showMessageDialog(dialog, "Succesfull registered a VM!.");
					RequestDispatcher rs = request.getRequestDispatcher("hosting.jsp");
					rs.forward(request, response);		
					} else {
					JOptionPane.showMessageDialog(dialog, "Something went wrong! Please contact us.");
					RequestDispatcher rs = request.getRequestDispatcher("index.html");
					rs.forward(request, response);
					}
				} else if (button == 2) {
<<<<<<< HEAD
					ps.setString(1, user);
					ps.setString(2, "running");
					ps.setInt(3, 1);
					ps.setInt(4, 2);
					ps.setInt(5, 50);
					int updated =ps.executeUpdate();
=======
					String sql = "INSERT INTO vms (cpu, ram, storage, status) VALUES (2,4,200,running) WHERE email = "+ user +"";
					int updated = statement.executeUpdate(sql);
>>>>>>> 818061de85655ac1b48a33bd1fd66ae8182f6372
					if (updated > 0) {
					JOptionPane.showMessageDialog(dialog, "Succesfull registered a VM!.");
					RequestDispatcher rs = request.getRequestDispatcher("hosting.jsp");
					rs.forward(request, response);		
					} else {
					JOptionPane.showMessageDialog(dialog, "Something went wrong. Please contact us");
					RequestDispatcher rs = request.getRequestDispatcher("index.html");
					rs.forward(request, response);						
						}
				} else if (button == 3) {
<<<<<<< HEAD
					ps.setString(1, user);
					ps.setString(2, "running");
					ps.setInt(3, 1);
					ps.setInt(4, 2);
					ps.setInt(5, 50);
					int updated =ps.executeUpdate();
					if (updated > 0) { 
=======
					String sql = "INSERT INTO vms (email, cpu, ram, storage, status) VALUES (thierry,4,8,500,running)";
					int update = statement.executeUpdate(sql);
					if (update > 0) { 
>>>>>>> 818061de85655ac1b48a33bd1fd66ae8182f6372
					JOptionPane.showMessageDialog(dialog, "Succesfull registered a VM!.");
					RequestDispatcher rs = request.getRequestDispatcher("hosting.jsp");
					rs.forward(request, response);		
					} else {
					JOptionPane.showMessageDialog(dialog, "Something went wrong. Please contact us");	
					RequestDispatcher rs = request.getRequestDispatcher("index.html");
					rs.forward(request, response);
					}
				} else {
					JOptionPane.showMessageDialog(dialog, "Something went wrong. Please contact us.");
					RequestDispatcher rs = request.getRequestDispatcher("index.html");
					rs.forward(request, response);
				
				
		}}} else {
			JOptionPane.showMessageDialog(dialog, "You now will be redirected to the homepage.");
			RequestDispatcher rs = request.getRequestDispatcher("index.html");
			rs.forward(request, response);
		}
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
}
		
	}
	








