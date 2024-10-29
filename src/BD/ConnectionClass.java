package BD;

import java.sql.*;

public class ConnectionClass {

	static String bd = "bdserracines";
	static String login = "root";
	static String password = "12345";
	static String url = "jdbc:mysql://localhost:3306/" + bd;
	static Connection connection = null;

	public ConnectionClass() {
		try {
			// String url = " jdbc : mysql :// hostname / database - name ";
			connection = DriverManager.getConnection(url, login, password);
		} catch (SQLException ex) {
			connection = null;
			ex.printStackTrace();
			System.out.println(" SQLException : " + ex.getMessage());
			System.out.println(" SQLState : " + ex.getSQLState());
			System.out.println(" VendorError : " + ex.getErrorCode());
		}
	}

	public static Connection getConnection() {
		
		if(connection == null) new ConnectionClass();
		
		return connection;
	}

	public void desconectar() {
		connection = null;
	}
}
