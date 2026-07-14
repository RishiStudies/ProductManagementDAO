package com.productdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		
		try {
			
			con=DBConnection.getConnection();
			String sql="INSERT INTO product VALUES (?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getQuantity());
			
			int i=ps.executeUpdate();
			
			if(i>0) {
				System.out.println("Product added successfully!!!");
			}
			else {
				System.out.println("Operation failed!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		
		try {
			
			con=DBConnection.getConnection();
			String sql="UPDATE product SET name=?,price=?,quantity=? WHERE id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(4, p.getId());
			ps.setString(1, p.getName());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getQuantity());
			
			int i=ps.executeUpdate();
			
			if(i>0) {
				System.out.println("Product updated successfully!!!");
			}
			else {
				System.out.println("Operation failed!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		
		try {
			
			con=DBConnection.getConnection();
			String sql="DELETE FROM product WHERE id=?";
			
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("Product deleted successfully!!!");
			} else {
				System.out.println("Operation failed!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Product searchProduct(int id) {
		// TODO Auto-generated method stub
		
		Product p=null;
		try {
			
			con=DBConnection.getConnection();
			String sql="SELECT * FROM product WHERE id=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				p=new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setQuantity(rs.getInt("quantity"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Product> displayAllProducts() {
		// TODO Auto-generated method stub
		
		List<Product> list=new ArrayList<Product>();
		try {
		
			con=DBConnection.getConnection();
			String sql="SELECT * FROM product";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
		
			while(rs.next()) {
				Product p=new Product();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getDouble("price"));
				p.setQuantity(rs.getInt("quantity"));
			
				list.add(p);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
