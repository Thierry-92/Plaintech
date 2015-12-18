package login;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
 * Servlet implementation class Startstopvm
 */
@WebServlet("/Startstopvm")
public class Startstopvm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html;charset=UTF-8");

		// Variables and shorter and JOption always on front
		HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute("username");
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);
		int button = Integer.parseInt(request.getParameter("startstop"));

		try {
			// Connect database
			Database dbcon = new Database();
			Connection conn = dbcon.returnConnection();

			// Make statement
			PreparedStatement ps = conn.prepareStatement("UPDATE vms SET status=? WHERE user_email=?");

			// Try to start vm
			if (button == 1) {
				// update the database
				ps.setString(1, "running");
				ps.setString(2, user);
				int result = ps.executeUpdate();

				List<String> command = new ArrayList<String>();
				command.add("sudo");
				command.add("-S");
				command.add("virtsh");
				command.add("start");
				command.add(user);
				ProcessBuilder pb = new ProcessBuilder(command);
				Process p = pb.start();
				System.out.println("" + pb.command());

				Reader reader = new InputStreamReader(p.getInputStream());
				int ch;
				while ((ch = reader.read()) != -1) {
					System.out.print((char) ch);
				}
				reader.close();
				
				if (result == 1) {
					JOptionPane.showMessageDialog(dialog, "VM is started");
					RequestDispatcher rs = request.getRequestDispatcher("personalpage.jsp");
					rs.forward(request, response);
				}

				// Stop the vm
			} else if (button == 2) {
				// update the database
				ps.setString(1, "stopped");
				ps.setString(2, user);
				int result = ps.executeUpdate();

				List<String> command = new ArrayList<String>();
				command.add("sudo");
				command.add("-S");
				command.add("virtsh");
				command.add("shutdown");
				command.add(user);
				ProcessBuilder pb = new ProcessBuilder(command);
				Process p = pb.start();
				System.out.println("" + pb.command());

				Reader reader = new InputStreamReader(p.getInputStream());
				int ch;
				while ((ch = reader.read()) != -1) {
					System.out.print((char) ch);
				}
				reader.close();
				
				if (result == 1) {
					JOptionPane.showMessageDialog(dialog, "VM is stopped");
					RequestDispatcher rs = request.getRequestDispatcher("personalpage.jsp");
					rs.forward(request, response);

				}

			} else if (button == 3) {

				// update the database
				ps.setString(1, user);
				int result = ps.executeUpdate();

				if (result == 1) {
					JOptionPane.showMessageDialog(dialog, "VM is Deleted");
					RequestDispatcher rs = request.getRequestDispatcher("personalpage.jsp");
					rs.forward(request, response);

				}
			} else {
				JOptionPane.showMessageDialog(dialog, "Something went wrong! Please contact us");
				RequestDispatcher rs = request.getRequestDispatcher("personalpage.jsp");
				rs.forward(request, response);
			}
		} catch (Exception e) {
			// making error handling easier (writes to javadoc)
			e.printStackTrace();
		}

	}
}
