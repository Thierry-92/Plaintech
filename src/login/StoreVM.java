package login;

import java.io.*;
import java.sql.*;
import javax.swing.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
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
				
				//Update the database
				if(button == 1) {
					ps.setString(1, user);
					ps.setString(2, "running");
					ps.setInt(3, 2);
					ps.setInt(4, 4);
					ps.setInt(5, 50);
					int updated =ps.executeUpdate();
					
					//Make vm from the command line
					List <String> command = new ArrayList<String>();
					command.add("sudo");
					command.add("-S");
					command.add("virt-install \\");
					command.add("--name "+ user + " \\");
					command.add("--ram 4 \\");
					command.add("--disk path=/images/"+user+".img,size=50 \\");
					command.add("--vcpus 2 \\");
					command.add("--os-type linux \\");
					command.add("--os-variant generic \\");
					command.add("--network bridge=br0 \\");
					command.add("--graphics none \\");
					command.add("--noautoconsole \\ ");
					command.add("--location http://archive.ubuntu.com/ubuntu/dists/trusty/main/installer-amd64/ \\");
					command.add("--extra-args \"console=ttyS0, 115200 auto=true hostname="+user+" url=http://192.168.31.128/\"$preseedFile\"\"");
					ProcessBuilder pb = new ProcessBuilder(command);
					pb.redirectErrorStream(true);
					Process p =pb.start();
					System.out.println(""+pb.command());
							
					Reader reader = new InputStreamReader(p.getInputStream());
				       int ch;
				       while ((ch = reader.read()) != -1) {
				           System.out.print((char) ch);
				       }
				       reader.close();

					//Check if it worked
					if (updated > 0 ) {
					JOptionPane.showMessageDialog(dialog, "Succesfull registered a VM! Redirecting you to your personal page.");
					RequestDispatcher rs = request.getRequestDispatcher("personalpage.jsp");
					rs.forward(request, response);		
					} else {
					JOptionPane.showMessageDialog(dialog, "Something went wrong! Please contact us.");
					RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
					rs.forward(request, response);
					}
				} else if (button == 2) {
					ps.setString(1, user);
					ps.setString(2, "running");
					ps.setInt(3, 4);
					ps.setInt(4, 8);
					ps.setInt(5, 200);
					int updated =ps.executeUpdate();
					//Check if query is executed
					//If query is executed then show a message and send to their page.
					if (updated > 0) {
					JOptionPane.showMessageDialog(dialog, "Succesfull registered a VM! Redirecting you to your personal page.");
					RequestDispatcher rs = request.getRequestDispatcher("personalpage.jsp");
					rs.forward(request, response);		
					} else {
					JOptionPane.showMessageDialog(dialog, "Something went wrong. Please contact us");
					RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
					rs.forward(request, response);						
						}
				} else if (button == 3) {
					ps.setString(1, user);
					ps.setString(2, "running");
					ps.setInt(3, 8);
					ps.setInt(4, 16);
					ps.setInt(5, 500);
					int updated =ps.executeUpdate();
					if (updated > 0) { 
					JOptionPane.showMessageDialog(dialog, "Succesfull registered a VM! Redirecting you to your personal page.");
					RequestDispatcher rs = request.getRequestDispatcher("personalpage.jsp");
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








