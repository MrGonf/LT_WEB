package bt_01.configs;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBMySQLConnect {

	private static String USERNAME = "MrGonf";
	private static String PASSWORD = "140107";
	private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/bt_01";

	public static Connection getDatabaseConnection() throws SQLException, Exception {
		
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			new DBMySQLConnect();
			System.out.println(DBMySQLConnect.getDatabaseConnection());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
