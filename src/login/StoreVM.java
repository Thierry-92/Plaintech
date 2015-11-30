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
		PrintWriter out = response.getWriter();
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);    
		
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
					out.println(user);
				} else if (button == 2) {
					out.println("yeah2");
				} else if (button == 3) {
					out.println("yeah3");
				} else {
					JOptionPane.showMessageDialog(dialog, "Something went wrong. Please contact us.");
					RequestDispatcher rs = request.getRequestDispatcher("index.html");
					rs.forward(request, response);
				
				
		}}} else {
			JOptionPane.showMessageDialog(dialog, "You now will be redirected to the homepage.");
			RequestDispatcher rs = request.getRequestDispatcher("index.html");
			rs.forward(request, response);
		}
		
}
		
	}
	








