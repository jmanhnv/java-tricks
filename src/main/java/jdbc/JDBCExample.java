/*
 * FILENAME JDBCExample.java FILE LOCATION $Source$ VERSION $Id$
 * @version $Revision$ Check-Out Tag: $Name$ Locked By: $Lockers$ FORMATTING NOTES * Lines should be limited to 78
 * characters. * Files should contain no tabs. * Indent code using four-character increments. COPYRIGHT Copyright (C)
 * 2009 VietinBank Group. All rights reserved. This software is the confidential and proprietary information of
 * VietinBank Group ("Confidential Information"). You shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you entered into with VietinBank Group.
 */

package jdbc;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//
// IMPORTS
// NOTE: Import specific classes without using wildcards.
//

/**
 * <p>
 * Java JDBC connection example.
 * </p>
 * 
 * @author manhnv
 * @version 1.0
 **/
public final class JDBCExample {
	/**
	 * <p>
	 * Code snippets to use JDBC to connect a MS SQLServer database.
	 * </p>
	 * 
	 * @return SQLServer connection
	 */
	public static Connection getSQLServerConnection() {
		// ## Database Connection Settings (Uncomment the Maven Filters section
		// in rdbm.properties)
		// environment.build.hibernate.connection.driver_class=com.microsoft.sqlserver.jdbc.SQLServerDriver
		// environment.build.hibernate.connection.url=jdbc:sqlserver://<servername>:<port>;databaseName=<databasename>
		// environment.build.hibernate.connection.username=username
		// environment.build.hibernate.connection.password=password
		// environment.build.hibernate.dialect=org.hibernate.dialect.SQLServerDialect
		System.out.println("-------- SQLServer JDBC Connection Testing ------------");
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your SQLServer JDBC Driver? Include in your library path!");
			return null;
		}

		System.out.println("SQLServer JDBC Driver Registered!");

		Connection connection = null;
		try {
			/*
			 * Way 01 - Here is a code snippet that connects the user sa with password secret to the instance test on
			 * localhost
			 */
			// String dbURL =
			// "jdbc:sqlserver://localhost\\test;user=sa;password=secret";
			// connection = DriverManager.getConnection(dbURL);

			/*
			 * Way 02 - The following code passes username and password as arguments to the method getConnection()
			 */
			// String dbURL = "jdbc:sqlserver://localhost\\test";
			// String user = "sa";
			// String pass = "secret";
			// connection = DriverManager.getConnection(dbURL, user, pass);

			/*
			 * Way 03 - We can also use a java.util.Properties object to store connection properties, as in the
			 * following example
			 */
			// String dbURL = "jdbc:sqlserver://localhost\\test";
			// Properties properties = new Properties();
			// properties.put("user", "sa");
			// properties.put("password", "secret");
			// connection = DriverManager.getConnection(dbURL, properties);

			connection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost:1433;databaseName=test;integratedSecurity=true", "sa", "secret");
			// Following are some examples:
			// - Connect to default instance of SQL server running on the same
			// machine as the JDBC client, using Windows authentication:
			// jdbc:sqlserver://localhost;integratedSecurity=true;
			// - Connect to an instance named sqlexpress on the host dbServer,
			// using SQL Server authentication:
			// jdbc:sqlserver://dbHost\sqlexpress;user=sa;password=secret
			// - Connect to a named database test on localhost using Windows
			// authentication:
			// jdbc:sqlserver://localhost:1433;databaseName=test;integratedSecurity=true;

			if (connection != null) {
				System.out.println("You made it, take control your database now!");
				DatabaseMetaData dm = (DatabaseMetaData) connection.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
			} else System.out.println("Failed to make connection!");

		} catch (SQLException ex) {
			System.out.println("Connection Failed! Check output console");
			return null;
		} finally {
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return connection;
	}

	/**
	 * <p>
	 * Code snippets to use JDBC to connect a PostgreSQL database.
	 * </p>
	 * 
	 * @return PostgreSQL connection
	 */
	public static Connection getPostgreSQLConnection() {
		System.out.println("-------- PostgreSQL JDBC Connection Testing ------------");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			return null;
		}

		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "postgres");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			return null;
		}

		if (connection != null) System.out.println("You made it, take control your database now!");
		else System.out.println("Failed to make connection!");

		return connection;
	}

	/**
	 * <p>
	 * Code snippets to use JDBC to connect a Oracle database.
	 * </p>
	 * 
	 * @return Oracle connection
	 */
	public static Connection getOracleConnection() {
		System.out.println("-------- Oracle JDBC Connection Testing ------");
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			return null;
		}

		System.out.println("Oracle JDBC Driver Registered!");

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:sample", "c##admin", "123456");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			return null;
		}

		if (connection != null) System.out.println("You made it, take control your database now!");
		else System.out.println("Failed to make connection!");

		return connection;
	}

	/**
	 * <p>
	 * Code snippets to use JDBC to connect a MySQL database.
	 * </p>
	 * 
	 * @return MySQL connection
	 */
	public static Connection getMySQLConnection() {
		System.out.println("-------- MySQL JDBC Connection Testing ------");
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			return null;
		}

		System.out.println("MySQL JDBC Driver Registered!");

		// setup the connection with the DB.
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=root");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			return null;
		}

		if (connection != null) System.out.println("You made it, take control your database now!");
		else System.out.println("Failed to make connection!");

		return connection;
	}

	private JDBCExample() {
	}

	/**
	 * Creating JDBC Application.
	 */
	@SuppressWarnings("unused")
	private class MySQLAccess {
		private Connection connection = null;
		private Statement statement = null;
		private ResultSet resultSet = null;
		private PreparedStatement preparedStatement = null;

		@SuppressWarnings("deprecation")
		public void readDataBase() throws Exception {
			try {
				// this will load the MySQL driver, each DB has its own driver
				Class.forName("com.mysql.jdbc.Driver");
				// setup the connection with the DB.
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=root");

				// statements allow to issue SQL queries to the database
				statement = connection.createStatement();
				// resultSet gets the result of the SQL query
				resultSet = statement.executeQuery("select * from FEEDBACK.COMMENTS");
				writeResultSet(resultSet);

				// preparedStatements can use variables and are more efficient
				preparedStatement = connection
						.prepareStatement("insert into  FEEDBACK.COMMENTS values (default, ?, ?, ?, ? , ?, ?)");
				// "myuser, webpage, datum, summary, COMMENTS from
				// FEEDBACK.COMMENTS");
				// parameters start with 1
				preparedStatement.setString(1, "Test");
				preparedStatement.setString(2, "TestEmail");
				preparedStatement.setString(3, "TestWebpage");
				preparedStatement.setDate(4, new Date(2015, 02, 04));
				preparedStatement.setString(5, "TestSummary");
				preparedStatement.setString(6, "TestComment");
				preparedStatement.executeUpdate();

				preparedStatement = connection
						.prepareStatement("SELECT myuser, webpage, datum, summary, COMMENTS from FEEDBACK.COMMENTS");
				resultSet = preparedStatement.executeQuery();
				writeResultSet(resultSet);

				// remove again the insert comment
				preparedStatement = connection.prepareStatement("delete from FEEDBACK.COMMENTS where myuser= ? ; ");
				preparedStatement.setString(1, "Test");
				preparedStatement.executeUpdate();

				resultSet = statement.executeQuery("select * from FEEDBACK.COMMENTS");
				writeMetaData(resultSet);

			} catch (Exception e) {
				throw e;
			} finally {
				close();
			}

		}

		private void writeMetaData(ResultSet resultSet) throws SQLException {
			// now get some metadata from the database
			System.out.println("The columns in the table are: ");
			System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
			for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
				System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
			}
		}

		private void writeResultSet(ResultSet resultSet) throws SQLException {
			// resultSet is initialised before the first data set
			while (resultSet.next()) {
				// it is possible to get the columns via name
				// also possible to get the columns via the column number
				// which starts at 1
				// e.g., resultSet.getSTring(2);
				String user = resultSet.getString("myuser");
				String website = resultSet.getString("webpage");
				String summary = resultSet.getString("summary");
				Date date = resultSet.getDate("datum");
				String comment = resultSet.getString("comments");
				System.out.println("User: " + user);
				System.out.println("Website: " + website);
				System.out.println("Summary: " + summary);
				System.out.println("Date: " + date);
				System.out.println("Comment: " + comment);
			}
		}

		// you need to close all three to make sure
		private void close() {
			// close(resultSet);
			// close(statement);
			// close(connection);
		}

		private void close(final Closeable c) {
			try {
				if (c != null) {
					c.close();
				}
			} catch (Exception e) {
				// don't throw now as it might leave following closables in
				// undefined state
			}
		}
	}

	/**
	 * Creating JDBC Application.
	 */
	@SuppressWarnings("unused")
	private static class FirstExample {
		// JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost:3306/test";

		// Database credentials
		static final String USER = "root";
		static final String PASS = "root";

		public static void main(final String[] args) {
			Connection conn = null;
			Statement stmt = null;
			try {
				// STEP 2: Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				// STEP 3: Open a connection
				System.out.println("Connecting to database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);

				// STEP 4: Execute a query
				System.out.println("Creating statement...");
				stmt = conn.createStatement();
				String sql;
				sql = "SELECT id, first, last, age FROM Employees";
				ResultSet rs = stmt.executeQuery(sql);

				// STEP 5: Extract data from result set
				while (rs.next()) {
					// Retrieve by column name
					int id = rs.getInt("id");
					int age = rs.getInt("age");
					String first = rs.getString("first");
					String last = rs.getString("last");

					// Display values
					System.out.print("ID: " + id);
					System.out.print(", Age: " + age);
					System.out.print(", First: " + first);
					System.out.println(", Last: " + last);
				}
				// STEP 6: Clean-up environment
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			} finally {
				// finally block used to close resources
				try {
					if (stmt != null) stmt.close();
				} catch (SQLException se2) {
				} // nothing we can do
				try {
					if (conn != null) conn.close();
				} catch (SQLException se) {
					se.printStackTrace();
				} // end finally try
			} // end try
			System.out.println("Goodbye!");
		}// end main
	}// end FirstExample
}
