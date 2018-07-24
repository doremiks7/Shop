package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import connectDB.DBConnection;
import objects.Product;

public class ProductDB {

	public ArrayList<Product> getListProduct() throws SQLException{
		
		Connection connection = DBConnection.getConnect();
		String sql = "SELECT * FROM product ORDER BY RAND() LIMIT 4";
		PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery(sql);
		
		ArrayList<Product> list = new ArrayList<>();
		while (rs.next()) {
			
			Product product = new Product();
			product.setProductId(rs.getInt("product_id"));
			product.setCategoryId(rs.getInt("category_id"));
			product.setProductDescription(rs.getString("product_description"));
			product.setProductImage(rs.getString("product_image"));
			product.setProductName(rs.getString("product_name"));
			product.setProductPrice(rs.getDouble("product_price"));
			
			list.add(product);
		}
		
		return list;
	}
	
	public Product getProductById(int product_id) throws SQLException {
		
		Connection connection = DBConnection.getConnect();
		String sql = "SELECT * FROM product WHERE product_id = '" + product_id + "'";
		PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery(sql);
		
		Product product = new Product();
		
		while (rs.next()) {
			
			product.setCategoryId(rs.getInt("category_id"));
			product.setProductImage(rs.getString("product_image"));
			product.setProductDescription(rs.getString("product_description"));
			product.setProductImage(rs.getString("product_image"));
			product.setProductName(rs.getString("product_name"));
			product.setProductPrice(rs.getDouble("product_price"));
		}
		
		return product;
		
	}
	
	public ArrayList<Product> getListProductByCategory(long category_id) throws SQLException{
			
		Connection connection = (Connection) DBConnection.getConnect();
		String sql = "SELECT * FROM product WHERE category_id='" + category_id + "'";
		PreparedStatement ps = (PreparedStatement) connection.prepareCall(sql);
		ResultSet rs = ps.executeQuery(sql);
		ArrayList<Product> list = new ArrayList<>();
		while(rs.next()) {
			Product product = new Product();
			product.setProductId(rs.getLong("product_id"));
			product.setCategoryId(rs.getLong("category_id"));
			product.setProductName(rs.getString("product_name"));
			product.setProductDescription("product_description");
			product.setProductImage(rs.getString("product_image"));
			product.setProductPrice(rs.getDouble("product_price"));
			list.add(product);
		}
		return list;
	}
	
	public static void main(String []args) throws SQLException {
		ProductDB productDB = new ProductDB();
		Product product = new Product();
		product = productDB.getProductById(1);
		System.out.println(product.getProductName());
	}
	
}
