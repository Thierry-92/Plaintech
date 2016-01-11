package login;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class changeVM
 */
@WebServlet("/changeVM")
public class changeVM extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");

		// Connect database
		Database dbcon = new Database();
		Connection conn = dbcon.returnConnection();

		// Variables and shorter and JOption always on front
		HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute("username");
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		String cpu = request.getParameter("CPU");
		String ram = request.getParameter("RAM");
		String storage = request.getParameter("STORAGE");

		// Check if logged in
		if (session == null || session.getAttribute("username") == null) {
			JOptionPane.showMessageDialog(dialog, "Please login first.");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.forward(request, response);
		} else {

			try {				
				//Update the vm itself. First set the system to use more memory for the vm.
				List<String> command = new ArrayList<String>();
				command.add("sudo");
				command.add("-S");
				command.add("virsh \\");
				command.add("setmaxmem \\");
				command.add(user +" \\");
				command.add(ram + " \\");
				command.add("--config \\");
				
				//Execute the command
				ProcessBuilder pb = new ProcessBuilder(command);
				pb.redirectErrorStream(true);
				Process p = pb.start();
				System.out.println("" + pb.command());

				//Show me the results of what happens.
				Reader reader = new InputStreamReader(p.getInputStream());
				int ch;
				while ((ch = reader.read()) != -1) {
					System.out.print((char) ch);
				}
				reader.close();
				
				//Update the vm ITSElf
				List<String> command1 = new ArrayList<String>();
				command.add("sudo");
				command.add("-S");
				command.add("virsh \\");
				command.add("setmem \\");
				command.add(user +" \\");
				command.add(ram + " \\");
				command.add("--config \\");
				
				//Execute the command
				ProcessBuilder pb1 = new ProcessBuilder(command1);
				pb.redirectErrorStream(true);
				Process p1 = pb1.start();
				System.out.println("" + pb1.command());

				//Show me the results of what happens.
				Reader reader1 = new InputStreamReader(p1.getInputStream());
				int ch1;
				while ((ch1 = reader1.read()) != -1) {
					System.out.print((char) ch1);
				}
				reader1.close();
				
				// update the database
				PreparedStatement ps = conn.prepareStatement("UPDATE vms SET cpu=?,ram=?,storage=? WHERE user_email=?");
				ps.setString(1, cpu);
				ps.setString(2, ram);
				ps.setString(3, storage);
				ps.setString(4, user);
				int result = ps.executeUpdate();
				
				//If its als good show message
				if (result == 1) {
					JOptionPane.showMessageDialog(dialog, "VM is updated successfull.");
					RequestDispatcher rs = request.getRequestDispatcher("personalpage.jsp");
					rs.forward(request, response);
				} else {
					JOptionPane.showMessageDialog(dialog,
							"Something failed. Do you have a VM already? If so please contact us.");
					RequestDispatcher rs = request.getRequestDispatcher("personalpage.jsp");
					rs.forward(request, response);
				}
			} catch (Exception e) {
				// making error handling easier (writes to javadoc)
				e.printStackTrace();
			}
		}

	}
}
