package login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import javax.swing.*;

@WebFilter(urlPatterns = "/support")

public class loginFilter implements Filter {

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		final JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);

		HttpSession session = req.getSession(false);

		if (session == null || session.getAttribute("username") == null) {
			this.context.log("Unauthorized access request");
			res.sendRedirect("login.jsp");
		} else {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}

	}

	public void destroy() {
		// close any resources here
	}

}