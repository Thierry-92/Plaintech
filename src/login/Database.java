package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Database {
	// Global connection for returning
	private Connection connection;

	public Connection returnConnection() {
		try {

			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/virtualization","root","12345");
		}

		/**
		 * Catch sql exception
		 */
		catch (SQLException e) {

			// Could not connect to the database
			System.err.print("Could not connect to db!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Eventually return the connection
		return connection;
	}

	/**
	 * Close connection when done
	 * 
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		connection.close();
	}
}
