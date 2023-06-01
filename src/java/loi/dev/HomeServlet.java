/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import loi.dev.data.dao.DatabaseDao;
import loi.dev.data.model.Category;
import loi.dev.data.model.Product;
import loi.dev.util.Constants;

/**
 *
 * @author ACER NITRO
 */
public class HomeServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doGet(request, response);
        List<Product> productList = DatabaseDao.getInstance().getProductDao().findAll(Constants.VIEW_LIMIT);
        List<Product> hotProductList = DatabaseDao.getInstance().getProductDao().hot();
        List<Category> hotcategoryList = DatabaseDao.getInstance().getCategoryDao().hotCategory();
        request.setAttribute("productList", productList);
        request.setAttribute("hotProductList", hotProductList);
        request.setAttribute("hotcategoryList", hotcategoryList);
        request.getRequestDispatcher("home.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.print("Method POST");
    }

}
