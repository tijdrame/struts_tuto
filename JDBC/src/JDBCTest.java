
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) throws SQLException {
		final String DATABASE_URL = "jdbc:postgresql://localhost:5432/struts_db";
        final String USER = "postgres";
        final String PASSWORD = "passer";
        Connection conn = null;
		System.out.println("Connecting to the database");
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			Statement statement = conn.createStatement();
			int n = deleteEmployee(conn);
			System.out.println("number of rows affected :"+n);
			//conn.close();
			/*ResultSet rs = statement.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println(rs.getInt(1)+" --> "+rs.getString(2));
				
			}*/
			System.out.println("Connection establish");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			System.out.println("in finally");
			conn.close();
		}
		
	}
	public static int createTable(Statement st) throws SQLException {
		return st.executeUpdate
				("CREATE TABLE employee(emp_id bigint, emp_name character varying(30), emp_salary integer)");
	}
	
	public static int createRecordsEmp(Statement st) throws SQLException {
		return st.executeUpdate("INSERT INTO employee (emp_name,emp_salary) values ('employeeE', 2500)");
	}
	
	public static int updateEmployee(Statement st) throws SQLException {
		return st.executeUpdate("UPDATE employee SET emp_salary=3100 where emp_id=4");
	}
	public static int deleteEmployee(Statement st) throws SQLException {
		return st.executeUpdate("DELETE FROM employee ");
	}
	
	public static int createRecordsEmp(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO employee (emp_name,emp_salary) values (?, ?)");
		ps.setString(1, "Nafi");
		ps.setInt(2, 1500);
		return ps.executeUpdate();
	}
	public static int updateEmployee(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(
				"UPDATE employee SET emp_salary=? where emp_id=?");
		ps.setInt(1, 20000);
		ps.setInt(2, 7);
		return ps.executeUpdate();
	}
	public static int deleteEmployee(Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(
				"DELETE FROM employee WHERE emp_id=?");
		ps.setInt(1, 7);
		return ps.executeUpdate();
	}
}
