package loi.dev.data.dao;

import loi.dev.data.impl.CategoryImpl;
import loi.dev.data.impl.GalleryImpl;
import loi.dev.data.impl.OrderImpl;
import loi.dev.data.impl.OrderItemImpl;
import loi.dev.data.impl.ProductImpl;
import loi.dev.data.impl.UserImpl;

public class Database extends DatabaseDao {

    @Override
    public ProductDao getProductDao() {
        // TODO Auto-generated method stub
        return new ProductImpl();
    }

    @Override
    public CategoryDao getCategoryDao() {
        // TODO Auto-generated method stub
        return new CategoryImpl();
    }

    @Override
    public GalleryDao getGalleryDao() {
        // TODO Auto-generated method stub
        return new GalleryImpl();
    }

    @Override
    public OrderItemDao getOrderItemDao() {
        // TODO Auto-generated method stub
        return new OrderItemImpl();
    }

    @Override
    public OrderDao getOrderDao() {
        // TODO Auto-generated method stub
        return new OrderImpl();
    }

    @Override
    public UserDAO getUserDao() {
        // TODO Auto-generated method stub
        return new UserImpl();
    }

}
