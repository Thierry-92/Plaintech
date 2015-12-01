package login;
 
import java.sql.*;
 
/**
 * Servlet implementation class Validate
 */
 
public class Validateregister
{   //Gets  values for email and pass in welcome method validate.insertUser(email, pass). set standard value to false so nobody can login without requested values.
    public static boolean insertUser(String email, String pass, String name, String address, String  city, String country, String telnumber, String company) 
    {
     boolean st =false;
     try{
          //make connection
    	 
 		Database dbcon = new Database();
 		Connection con = dbcon.returnConnection();
        PreparedStatement ps =con.prepareStatement
                            ("INSERT INTO users (email,pass,name,address,city,country,telnumber,company) VALUES (?,?,?,?,?,?,?,?)");
ps.setString(1, email);
ps.setString(2, pass);
ps.setString(3, name);
ps.setString(4, address);
ps.setString(5, city);
ps.setString(6, country);
ps.setString(7, telnumber);
ps.setString(8, company);
 
     //Points the cursor on the first row of the results.
        int result =ps.executeUpdate();
     //Returns true if there is a row in the database. The cursor goes down one row and if there is 1 --> true
        if(result==1){
        	st = true;
        	 
        }
        
     }catch(Exception e)
     {
         //making error handling easier (writes to javadoc)
         e.printStackTrace();
     }
        return st;                 
 }   
}