package login;

import java.io.*;
import javax.servlet.*;
import javax.swing.*;

@WebFilter(UrlPatterns={ "/*"})

public class Loginfilter extends Filter {
	
	public void doFilter(ServletRequest req, ServletResponse resp,  
        FilterChain chain) throws IOException, ServletException {  
		
		HttpSession session = request.getSession(false);
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);  

	if (session == null || session.getAttribute("username") == null) {
		JOptionPane.showMessageDialog(dialog, "Please login first!");
		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
	            rs.forward(request, response);
	} else {
	chain.doFilter(request, respone);	
	
	}
}
	public void destroy(){}
	
}