package dbutil;

import java.sql.*;

public class DBUtil {

	public static Connection getConnection()
	{
		final String DATABASE_URL = "jdbc:postgresql://localhost:5432/struts_db";
        final String USER = "postgres";
        final String PASSWORD = "passer";
		Connection conn = null;
		try 
		{
			System.out.println("Début connection!");
			Class.forName("org.postgresql.Driver");
		    conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
		    System.out.println("Connection réussie!!!!");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
	}
	public static void closeConnection(Connection conn)
	{
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
