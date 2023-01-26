package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {

	public static Connection getDBConnection() {
		Connection connection = null;			

		String username = DBAccounts.DBUSERNAME;  
		String password = DBAccounts.DBPASSWORD;
		String url = DBAccounts.DBURL;

		try {
			Class.forName("org.sqlite.JDBC");  
			connection = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return connection;
	}

	public static void closeDBConnection(Statement stmt, Connection connection) {
		closeDBConnection(null, stmt, connection);
	}

	public static void closeDBConnection(ResultSet rs, Statement stmt, Connection conn) {

		try {
			if (rs != null) { 
				
				rs.close();
			}
			if (stmt != null) { 
				
				stmt.close();
			}
			if (conn != null) { 
				conn.close();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}