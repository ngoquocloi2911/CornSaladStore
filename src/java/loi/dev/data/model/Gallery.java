package loi.dev.data.model;

import loi.dev.data.dao.DatabaseDao;

public class Gallery {

    private int id;
    private String url;
    private int productId;

    public Gallery(String url, int productId) {
        super();
        this.url = url;
        this.productId = productId;
    }

    public Gallery(int id, String url, int productId) {
        super();
        this.id = id;
        this.url = url;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return DatabaseDao.getInstance().getProductDao().find(productId);
    }

}
