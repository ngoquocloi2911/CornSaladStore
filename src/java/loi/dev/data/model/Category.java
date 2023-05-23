package loi.dev.data.model;

import java.util.List;

import loi.dev.data.dao.DatabaseDao;

public class Category {

    private int id;
    private String name;
    private String thumbnail;

    //  insert vào 
    public Category(String name, String thumbnail) {
        super();
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public Category(int id, String name, String thumbnail) {
        super();
        this.id = id;
        this.name = name;
        this.thumbnail = thumbnail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<Product> getProducts() {
        return DatabaseDao.getInstance().getProductDao().findByCategory(id);
    }
}
