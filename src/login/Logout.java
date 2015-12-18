package login;

import java.io.IOException;

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
 * Servlet implementation class LogoutSession
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);

		if (JOptionPane.showConfirmDialog(dialog, "Are you sure?", "WARNING",
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			if (session == null || session.getAttribute("username") == null) {
				JOptionPane.showMessageDialog(dialog, "Not logged in mate.");
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				rs.forward(request, response);
			} else {
				session.removeAttribute("username");
				session.getMaxInactiveInterval();
				JOptionPane.showMessageDialog(dialog, "Succesfull logged out.");
				RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
				rs.forward(request, response);
			}
		} else {
			JOptionPane.showMessageDialog(dialog, "Redirecting you to home page. If you want to logout try again.");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.forward(request, response);

		}
	}
}