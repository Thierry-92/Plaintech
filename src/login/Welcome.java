package login;
 
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.Cookie;
 
/**
 * Servlet implementation class Welcome
 */
@WebServlet("/Welcome")
public class Welcome extends HttpServlet {
 
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //Array with all the cookies a client haves.
        Cookie ck[]=request.getCookies();
        //If cookie is not equal to null
        if(ck!=null){
        //Add first cookie of the email to a string email
         String email=ck[0].getValue();
        //IF email isnt empty or isnt null, then display the message.
        if(!email.equals("")||email!=null){
            out.print("<b>Welcome to Profile</b>");
            out.print("<br>Welcome, "+email);
        }
        }else{
        //Else send back to login.html because no user is logged in.
            out.print("Please login first");
            request.getRequestDispatcher("index.html").include(request, response);
        }
        out.close();
      }  
}