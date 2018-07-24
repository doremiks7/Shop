package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import connectDB.DBConnection;
import objects.User;

public class UserDB {
	
	public boolean checkEmail(String email) throws SQLException {
		
		Connection connection = DBConnection.getConnect();
		String sql = "SELECT * FROM user WHERE user_email='" + email +"'";
		PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery(sql);
		
		while(rs.next()) {
			connection.close();
			return true;
		}
		return false;
		
	}
	
	public boolean checkPass(String pass) {
		
		if(pass.length() < 6)
		{
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean checkUsername(String username) {
			
		int l = username.length();
		for(int i=0;i<l;i++)
		{
			if((username.charAt(i) <= 'a' || username.charAt(i) >= 'z') && (username.charAt(i) <= 'A' || username.charAt(i) >= 'Z'))
			{
				return false;
			}
		}
		return true;
	}

	public boolean checkPhone(String phone) {
	
		int l = phone.length();
		if(phone.length() < 6)
		{
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean insertUser(User u) {
		
		Connection connection = DBConnection.getConnect();
		String sql = "INSERT INTO user (user_id, user_email, user_pass, user_role, user_username, user_phone)"
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps;
		try {
			ps = (PreparedStatement) connection.prepareCall(sql);
			ps.setLong(1, u.getUserId());
			ps.setString(2, u.getUserEmail());
			ps.setString(3, u.getUserPass());
			ps.setBoolean(4, u.isUserRole());
			ps.setString(5, u.getPhoneNumber());
			ps.setString(6, u.getUserEmail());
			ps.executeUpdate();
			return true;
			
		} catch (Exception e) {
			
			Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, e);
			
		}
	
		return false;
	}
	
	public static void main(String []args) throws SQLException {
		
		UserDB userDB = new UserDB();
//		User u = new User();
//		u.setPhoneNumber("0984832");
//		u.setUserEmail("anhthaiw124@gmail.com");
//		u.setUserId(5);
//		u.setUsername("Nothing");
//		u.setUserPass("123456");
//		u.setUserRole(true);
//	
//		System.out.println(userDB.insertUser(u));
		System.out.println(userDB.checkEmail("anhthaiw124@gmail.com"));
		
	}

	

}
