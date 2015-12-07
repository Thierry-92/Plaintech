package login;

import java.io.IOException;
import java.sql.*;
import java.sql.PreparedStatement;
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
		PreparedStatement ps = con.prepareStatement("INSERT INTO vms VALUES(?,?,?,?,?)");
		
		if (JOptionPane.showConfirmDialog(dialog, "Are you sure?", "WARNING",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			//Make some variables and shorter things.
			int button = Integer.parseInt(request.getParameter("vmstore"));

			//Check if session is set.
			if(session == null || session.getAttribute("username") == null) {
				JOptionPane.showMessageDialog(dialog, "Please login first before ordering.");
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
	            rs.forward(request, response);
			} else {
				
				if(button == 1) {
					ps.setString(1, user);
					ps.setString(2, "running");
					ps.setInt(3, 1);
					ps.setInt(4, 2);
					ps.setInt(5, 50);
					int updated =ps.executeUpdate();
					
					String [] command = {"virt-install", "-n"+user+"", "-s 50", "--vcpus=2", "-r 1024", "--accelerate", "-f path/to/image", " '\' ", "--cdrom debian.iso"};
					ProcessBuilder pb = new ProcessBuilder(command);
					
					if (updated > 0 ) {
					JOptionPane.showMessageDialog(dialog, "Succesfull registered a VM! Check the status at your personal page.");
					RequestDispatcher rs = request.getRequestDispatcher("hosting.jsp");
					rs.forward(request, response);		
					} else {
					JOptionPane.showMessageDialog(dialog, "Something went wrong! Please contact us.");
					RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
					rs.forward(request, response);
					}
				} else if (button == 2) {
					ps.setString(1, user);
					ps.setString(2, "running");
					ps.setInt(3, 1);
					ps.setInt(4, 2);
					ps.setInt(5, 50);
					int updated =ps.executeUpdate();
					//Check if query is executed
					//If query is executed then show a message and send to their page.
					if (updated > 0) {
					JOptionPane.showMessageDialog(dialog, "Succesfull registered a VM!.");
					RequestDispatcher rs = request.getRequestDispatcher("hosting.jsp");
					rs.forward(request, response);		
					} else {
					JOptionPane.showMessageDialog(dialog, "Something went wrong. Please contact us");
					RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
					rs.forward(request, response);						
						}
				} else if (button == 3) {
					ps.setString(1, user);
					ps.setString(2, "running");
					ps.setInt(3, 1);
					ps.setInt(4, 2);
					ps.setInt(5, 50);
					int updated =ps.executeUpdate();
					if (updated > 0) { 
					JOptionPane.showMessageDialog(dialog, "Succesfull registered a VM!.");
					RequestDispatcher rs = request.getRequestDispatcher("hosting.jsp");
					rs.forward(request, response);		
					} else {
					JOptionPane.showMessageDialog(dialog, "Something went wrong. Please contact us");	
					RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
					rs.forward(request, response);
					}
				} else {
					JOptionPane.showMessageDialog(dialog, "Something went wrong. Please contact us.");
					RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
					rs.forward(request, response);
				
				
		}}} else {
			JOptionPane.showMessageDialog(dialog, "You now will be redirected to the homepage.");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.forward(request, response);
		}
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
}
		
	}
	








