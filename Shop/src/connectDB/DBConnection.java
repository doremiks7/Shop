package connectDB;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;

public class DBConnection {

	public static Connection getConnect(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Shop", "root", "");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return conn;
		
	}
	
	public static void main(String []args)
	{
		System.out.println(getConnect());
	}
	
}
