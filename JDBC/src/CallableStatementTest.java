import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CallableStatementTest {

	public static void main(String[] args) throws SQLException {
		final String DATABASE_URL = "jdbc:postgresql://localhost:5432/struts_db";
        final String USER = "postgres";
        final String PASSWORD = "passer";
        Connection conn = null;
		System.out.println("Connecting to the database");
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
			CallableStatement st = conn.prepareCall("call getEmployeeById(?,?,?)");
			st.setInt(1, 9);
			st.registerOutParameter(2, java.sql.Types.VARCHAR);
			st.registerOutParameter(3, java.sql.Types.INTEGER);
			int n = st.executeUpdate();
			System.out.println("Name:"+st.getString(2)+" Salary:"+st.getInt(3));
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}

	}

}
