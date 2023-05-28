/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev.admin.order;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import loi.dev.BaseServlet;
import loi.dev.data.dao.DatabaseDao;
import loi.dev.data.dao.OrderDao;
import loi.dev.data.model.Order;

/**
 *
 * @author ACER NITRO
 */
public class EditOrderServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        Order order = orderDao.find(orderId);

        request.setAttribute("order", order);
        request.getRequestDispatcher("admin/order/edit.jsp").include(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        
        Order order = orderDao.find(orderId);
        
        String code = request.getParameter("code");
        String status = request.getParameter("status");
        
        order.setCode(code);
        order.setStatus(status);
        
        orderDao.update(order);
        response.sendRedirect("IndexOrderServlet");
    }

}
