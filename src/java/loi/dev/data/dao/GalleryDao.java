package loi.dev.data.dao;

import java.util.List;

import loi.dev.data.model.Gallery;

public interface GalleryDao {
	public boolean insert(Gallery gallery);
	public boolean update(Gallery gallery);
	public boolean delete(int id);
	public Gallery find(int galleryId);
	public List<Gallery> findAll();
	public List<Gallery> findByProduct(int id);
	

}
