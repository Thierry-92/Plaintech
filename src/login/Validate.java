package login;
 
import java.sql.*;
 
/**
 * Servlet implementation class Validate
 */
 
public class Validate
{   //Gets  values for email and pass in welcome method validate.CheckUser(email, pass). set standard value to false so nobody can login without requested values.
    public static boolean checkUser(String emaillogin,String passlogin) 
    {
     boolean st =true;
     try{
          
 		Database dbcon = new Database();
 		Connection con = dbcon.returnConnection();
 		
        PreparedStatement ps =con.prepareStatement
                            ("select * from users where email=? and pass=?");
        ps.setString(1, emaillogin);
        ps.setString(2, passlogin);
     //Points the cursor on the first row of the results.
        ResultSet rs =ps.executeQuery();
     //Returns true if there is a row in the database. The cursor goes down one row and if there is 1 --> true
        st = rs.next();
        
     }catch(Exception e)
     {
         //making error handling easier (writes to javadoc)
         e.printStackTrace();
     }
        return st;                 
 }   
}