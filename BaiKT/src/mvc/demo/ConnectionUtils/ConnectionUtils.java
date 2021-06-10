package mvc.demo.ConnectionUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
	public static Connection getConnection() throws SQLException {
		String hostName = "localhost";
		String databaseName = "QLNV";
		String userName = "root";
		String password = "tagiang2302*";
		return getMysqlConnection(hostName, databaseName, userName, password);
	}
	
	public static Connection getMysqlConnection(
			String hostName,
			String dbName,
			String userName,
			String password) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //java cu thi can dong nay
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		Connection conn = DriverManager.getConnection(connectionURL, userName, password);
		return conn;
	}
}
