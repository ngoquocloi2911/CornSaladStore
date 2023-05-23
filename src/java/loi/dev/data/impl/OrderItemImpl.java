package loi.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import loi.dev.data.dao.OrderItemDao;
import loi.dev.data.driver.MySQLDriver;
import loi.dev.data.model.OrderItem;

public class OrderItemImpl implements OrderItemDao {
	Connection con = MySQLDriver.getInstance().getConnection();

	@Override
	public boolean insert(OrderItem order_Item) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO ORDER_ITEMS VALUES(NULL, ?, ?, ?, ?,)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, order_Item.getQuantity());
			stmt.setDouble(2, order_Item.getPrice());
			stmt.setInt(3, order_Item.getOrderId());
			stmt.setInt(4, order_Item.getProductId());
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(OrderItem order_Item) {
		// TODO Auto-generated method stub
		String sql = "UPDATE ORDER_ITEMS SET quatity = ?, price = ?, order_id = ?, product_id = ? WHERE id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,order_Item.getQuantity());
			stmt.setDouble(2, order_Item.getPrice());
			stmt.setInt(3, order_Item.getOrderId());
			stmt.setInt(4, order_Item.getProductId());
			return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM ORDER-ITEMS WHERE ID = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			
			return stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public OrderItem find(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ORDER-ITEMS" ;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				int orderId = rs.getInt("order_id");
				int productId = rs.getInt("product_id");
				
				return new OrderItem(quantity, price, orderId, productId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<OrderItem> findAll() {
		// TODO Auto-generated method stub
		List<OrderItem> orList = new ArrayList<>();
		String sql = "SELECT * FROM CATEGORIES" ;
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				int quantity = rs.getInt("quantity");
				double price = rs.getDouble("price");
				int orderId = rs.getInt("order_id");
				int productId = rs.getInt("product_id");
				
				orList.add(new OrderItem(quantity, price, orderId, productId));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orList;
	}

	@Override
	public List<OrderItem> findByOder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderItem> findByProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
