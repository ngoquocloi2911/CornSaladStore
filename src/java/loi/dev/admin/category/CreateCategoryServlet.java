/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev.admin.category;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import loi.dev.BaseServlet;
import loi.dev.data.dao.DatabaseDao;
import loi.dev.data.model.Category;

/**
 *
 * @author ACER NITRO
 */

public class CreateCategoryServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("admin/category/create.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String thumbnail = request.getParameter("thumbnail");
        Category category = new Category(name, thumbnail);
        
        DatabaseDao.getInstance().getCategoryDao().insert(category);
        
        response.sendRedirect("IndexCategoryServlet");
    }

}
