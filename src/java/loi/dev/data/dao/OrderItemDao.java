package loi.dev.data.dao;

import java.util.List;
import loi.dev.data.model.OrderItem;

public interface OrderItemDao {

    public boolean insert(OrderItem order_Item);

    public boolean update(OrderItem order_Item);

    public boolean delete(int id);

    public OrderItem find(int id);

    public List<OrderItem> findAll();

    public List<OrderItem> findByOder(int id);

    public List<OrderItem> findByProduct(int id);

}
