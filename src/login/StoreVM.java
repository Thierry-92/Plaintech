package login;

import java.io.IOException;
import java.sql.*;
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
		Statement statement = con.createStatement();
		
		
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
					String sql = "INSERT INTO vms (cpu, ram, storage, status) VALUES (1,2,50,running) WHERE email = "+ user +"";
					int updated = statement.executeUpdate(sql);
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
					String sql = "INSERT INTO vms (cpu, ram, storage, status) VALUES (2,4,200,running) WHERE email = "+ user +"";
					int updated = statement.executeUpdate(sql);
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
					String sql = "INSERT INTO vms (email, cpu, ram, storage, status) VALUES (thierry,4,8,500,running)";
					int update = statement.executeUpdate(sql);
					if (update > 0) { 
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
	








