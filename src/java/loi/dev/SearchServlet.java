/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import loi.dev.data.dao.DatabaseDao;
import loi.dev.data.dao.ProductDao;
import loi.dev.data.model.Product;

/**
 *
 * @author ACER NITRO
 */
public class SearchServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        String key = request.getParameter("key");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));

//        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        // Tránh trường hợp rỗng-- báo lỗi 
        List<Product> productList = new ArrayList<Product>();

        if (categoryId == 0) {
            productList = productDao.findByName(key);
        } else {
            productList = productDao.findByCategoryOfName(categoryId, key);
        }

        request.setAttribute("productList", productList);
        request.getRequestDispatcher("category.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
