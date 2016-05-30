package pl.edu.agh.tai.recipeme.selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class Database {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/recipe_me_db";
	
	public static void clean() throws SQLException {
		executeUpdate("DELETE FROM users;");
	}
	
	private static void executeUpdate(String query) throws SQLException {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = createConnection();
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			throw e;
		} finally {
			if (connection != null) connection.close();
			if (statement != null) statement.close();
		}
	}

	private static Connection createConnection() throws SQLException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Could not find driver: " + DRIVER);
		}
		return DriverManager.getConnection(URL, "root", "root");
	}
	
}