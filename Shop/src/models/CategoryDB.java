package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import connectDB.DBConnection;
import objects.Category;

public class CategoryDB {

	public ArrayList<Category> getListCategory() throws SQLException {
		
		Connection connection = DBConnection.getConnect();
		String sql = "SELECT * FROM category";
		PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery(sql);
	
		ArrayList<Category> list = new ArrayList<>();
		
		while(rs.next()) {
			Category category = new Category();
			category.setCategoryId(rs.getInt("category_id"));
			category.setCategoryName(rs.getString("category_name"));
			list.add(category);
		}
		return list;
	}
	
	public static void main(String []argv) throws SQLException {
		CategoryDB categoryDB = new CategoryDB();
		
		for (Category cate : categoryDB.getListCategory()) {
			System.out.println(cate.getCategoryName());
		}
		
	}
	
}
