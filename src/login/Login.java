package login;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;
import javax.swing.*;

/***
 * Servlet implementation class Login
 */

@WebServlet("/login")
public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Called by the server (via the service method) to allow a servlet to
	// handle a POST request.
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			// gives an exception to the servlet which it can throw it
			// encounters difficulty. Problem I/O is with reading/writing data
			// from url.
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		System.getProperty("java.awt.headless");
		// Declare some things
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);

		String emaillogin = request.getParameter("emaillogin");
		String passlogin = request.getParameter("passlogin");

		// asks the Validate.checkUser if the login is valid.
		if (Validate.checkUser(emaillogin, passlogin)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", emaillogin);
			session.setMaxInactiveInterval(30 * 60);

			// Name and value of the cookie.
			Cookie ck = new Cookie("email", emaillogin);
			response.addCookie(ck);
			// Cookie stays 30 minutes.
			ck.setMaxAge(1800);
			// Request the welcome.java file and forward client to that file.
			JOptionPane.showMessageDialog(dialog, "Successfull logged in!");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.forward(request, response);
		} else {
			// User isnt in database. Then show message and send again to
			// login.html with clean fields.
			JOptionPane.showMessageDialog(dialog, "Username or password incorrect!");
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.forward(request, response);
		}

	}
}