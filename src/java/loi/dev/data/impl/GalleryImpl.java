package loi.dev.data.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import loi.dev.data.dao.GalleryDao;
import loi.dev.data.driver.MySQLDriver;
import loi.dev.data.model.Gallery;

public class GalleryImpl implements GalleryDao {

    Connection con = MySQLDriver.getInstance().getConnection();

    @Override
    public boolean insert(Gallery gallery) {
        String sql = "INSERT INTO GALLERIES VALUES(NULL, ?, ?)";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, gallery.getUrl());
            stmt.setInt(2, gallery.getProductId());

            stmt.execute();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Gallery gallery) {
        // TODO Auto-generated method stub
        String sql = "UPDATE GALLERIES SET url = ?, product_id = ? WHERE id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, gallery.getUrl());
            stmt.setInt(2, gallery.getProductId());
            stmt.setInt(3, gallery.getId());
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
        String sql = "DELETE FROM GALLERIES WHERE ID = ?";
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
    public Gallery find(int id) {
        // TODO Auto-generated method stub
        String sql = "SELECT * FROM GALLENIES";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String url = rs.getString("url");
                int productId = rs.getInt("product_id");

                return new Gallery(id, url, productId);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Gallery> findAll() {
        // TODO Auto-generated method stub
        List<Gallery> galleryList = new ArrayList<>();
        String sql = "SELECT * FROM GALLERIES";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String url = rs.getString("url");
                int productId = rs.getInt("product_id");

                galleryList.add(new Gallery(id, url, productId));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return galleryList;
    }

    @Override
    public List<Gallery> findByProduct(int productId) {
        List<Gallery> galleryList = new ArrayList<>();
        String sql = "SELECT * FROM GALLERIES WHERE product_id = ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, productId);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String url = rs.getString("url");
                int id = rs.getInt("id");

                galleryList.add(new Gallery(id, url, productId));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return galleryList;
    }

}
