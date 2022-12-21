package dao;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import org.apache.commons.lang3.StringUtils;

import dbutil.DBUtil;
import pojo.Product;

public class ProductManagementDAO {
	
	
	public static List<Product> getAllProducts(String productName, String productCategory, LocalDate createdDate)
	{
		List<Product> productList = new ArrayList<Product>();
		StringBuilder whereClause = new StringBuilder(" where prod_id != ''");
		int count = 1;
		int proCateg = 0, creaDat = 0;
		if(!StringUtils.isEmpty(productName)) {
			whereClause.append(" and prod_name=?");
			count += 1;
		}
		if(!StringUtils.isEmpty(productCategory)) {
			whereClause.append(" and prod_category=?");
			if(count >1) proCateg =2;
			else proCateg = 1;
			count += 1;
		}
		if(createdDate!=null) {
			if(count >2) creaDat =3;
			else if(count>1) creaDat =2;
			else creaDat = 1;
			whereClause.append(" and created_date=?");
		}
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("SELECT * FROM product"+whereClause.toString());
			if(!StringUtils.isEmpty(productName)) ps.setString(1, productName);
			if(!StringUtils.isEmpty(productCategory)) ps.setString(proCateg, productCategory);
			if(createdDate!=null) ps.setDate(creaDat, Date.valueOf(createdDate));
			System.out.println("query==="+"SELECT * FROM product"+whereClause.toString());
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				Product product = new Product(rs.getString("prod_id"),rs.getString("prod_name"),
						rs.getString("prod_category"),rs.getInt("prod_price"), rs.getDate("created_date").toLocalDate());
				productList.add(product);
			}
			
			DBUtil.closeConnection(conn);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return productList;
	}
	
	
	public static Product getProductById(String productId)
	{
		Product product = null;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("SELECT * FROM product WHERE prod_id = ?");
			ps.setString(1, productId);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				product = new Product(rs.getString("prod_id"),rs.getString("prod_name"),
						rs.getString("prod_category"),rs.getInt("prod_price"), rs.getDate("created_date").toLocalDate());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return product;
	}
	
	
	public static int addProduct(Product product)
	{
		int status = 0;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("INSERT INTO product VALUES(?,?,?,?,?)");
			ps.setString(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getProductCategory());
			ps.setInt(4, product.getProductPrice());
			System.out.println("date==="+Date.valueOf(product.getCreatedDate()));
			ps.setDate(5, Date.valueOf(product.getCreatedDate()));
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static int updateProduct(Product product)
	{
		int status = 0;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("UPDATE product SET prod_name=?, prod_category=?, prod_price=? WHERE prod_id=?");
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductCategory());
			ps.setInt(3, product.getProductPrice());
			ps.setString(4, product.getProductId());
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public static int deleteProduct(String productId)
	{
		int status = 0;
		try
		{
			Connection conn = DBUtil.getConnection();
			PreparedStatement ps= conn.prepareStatement("DELETE FROM product where prod_id = ?");
			ps.setString(1, productId);
			status = ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
}
