/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev;

import com.mysql.cj.Session;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import loi.dev.data.dao.DatabaseDao;
import loi.dev.data.dao.OrderDao;
import loi.dev.data.model.Order;
import loi.dev.data.model.OrderItem;
import loi.dev.data.model.User;
import loi.dev.util.StringHelper;

/**
 *
 * @author ACER NITRO
 */
public class CheckoutServlet extends BaseServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            
        } else {
            processCheckout(request, user.getId());
        }
        response.sendRedirect("CartServlet");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    private void processCheckout(HttpServletRequest request, int userId) {
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        Order order = new Order(StringHelper.randomString(8), Order.PENDING, userId);
        orderDao.insert(order);
        
        order = orderDao.findByCode(order.getCode());
        HttpSession session = request.getSession();
        List<OrderItem> cart = (List<OrderItem>) session.getAttribute("cart");
        if(cart != null){
            for (OrderItem orderItem : cart) {
                orderItem.setOrderId(order.getId());
                DatabaseDao.getInstance().getOrderItemDao().insert(orderItem);
            }
        }
        
        session.removeAttribute("cart");
    }
    
}
