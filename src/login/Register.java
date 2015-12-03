package login;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.swing.*;

/**
 * Servlet implementation class Login
 */
 
@WebServlet("/register")
public class Register extends HttpServlet {
 
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    //Called by the server (via the service method) to allow a servlet to handle a POST request.
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    //gives an exception to the servlet which it can throw it encounters difficulty. Problem I/O is with reading/writing data from url. 
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        	
        //Declare some things
        	final JDialog dialog = new JDialog();
        	dialog.setAlwaysOnTop(true);    
            
        	String email = request.getParameter("email");
            String pass = request.getParameter("pass");
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String country = request.getParameter("country");
            String telnumber = request.getParameter("telnumber");
            String company = request.getParameter("company");
 
        //asks the Validate.insertUser if the login is valid. 
        if(Validateregister.insertUser(email, pass, name, address, city, country, telnumber, company))
        {
        //Name and value of the cookie.
            Cookie ck=new Cookie("email",email);
            response.addCookie(ck);
        //Cookie stays 30 minutes.
            ck.setMaxAge(1800);
        //Request the registered.java file and forward client to that file.
       
            JOptionPane.showMessageDialog(dialog, "Successfully registered.");
            HttpSession session = request.getSession();
        	session.setAttribute("username", email);
        	session.setMaxInactiveInterval(30*60);
            RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
            rs.forward(request, response);
        }
        else
        {
        //User isnt registered in database. Then show message and send again to register.html with clean fields.
        	JOptionPane.showMessageDialog(dialog, "Not all fields are filled in correctly!");
           RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
           rs.forward(request, response);
        }
        
    }  
}