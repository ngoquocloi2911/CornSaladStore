/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev.admin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import loi.dev.data.dao.DatabaseDao;
import loi.dev.data.dao.OrderDao;
import loi.dev.data.dao.ProductDao;
import loi.dev.data.dao.UserDAO;
import loi.dev.data.model.Order;
import loi.dev.data.model.OrderItem;
import loi.dev.data.model.Product;
import loi.dev.util.Constants;
import loi.dev.util.GetDateTime;

/**
 *
 * @author ACER NITRO
 */
public class DashboardServlet extends BaseAdminServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        UserDAO userDao = DatabaseDao.getInstance().getUserDao();
        int numberUser = userDao.findAll().size();

        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = productDao.findAll();
        int numberProduct = productDao.findAll().size();

        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        int numberOrder = orderDao.findAll().size();
        double total = getTotal();

        request.setAttribute("numberUser", numberUser);
        request.setAttribute("numberProduct", numberProduct);
        request.setAttribute("numberOrder", numberOrder);
        request.setAttribute("total", total);
        request.setAttribute("productList", productList);

        List<Order> orderPendingList = orderDao.findByStatus("pending");
        request.setAttribute("orderPendingList", orderPendingList);
        request.setAttribute("countOrderPending", orderPendingList.size());

        List<Order> orderFinishList = orderDao.findByStatus("finished");
        request.setAttribute("countOrderFinish", orderFinishList.size());

        // Chart
        List<String> dateList = GetDateTime.getDates(Constants.NUMBER_DAY);
        request.setAttribute("dateList", dateList);
        List<Double> earningEachDay = new ArrayList<>();
        for (int i = 0; i < Constants.NUMBER_DAY; i++) {
            earningEachDay.add(orderDao.earningOrderByDay(dateList.get(i)));
        }
        request.setAttribute("earningEachDay", earningEachDay);
        request.getRequestDispatcher("admin/dashboard.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private double getTotal() {
        double total = 0;
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        List<Order> orderList = orderDao.findByStatus("finished");
        for (Order order : orderList) {
            List<OrderItem> orderItemList = DatabaseDao.getInstance().getOrderItemDao().findByOder(order.getId());
            total += sum(orderItemList);
        }
        return total;
    }

    private double sum(List<OrderItem> orderItemList) {
        double s = 0;
        for (OrderItem orderItem : orderItemList) {
            s += orderItem.getQuantity() * orderItem.getPrice();
        }

        return s;
    }

}
