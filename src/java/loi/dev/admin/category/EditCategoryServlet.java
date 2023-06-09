/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev.admin.category;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loi.dev.BaseServlet;
import loi.dev.data.dao.CategoryDao;
import loi.dev.data.dao.DatabaseDao;
import loi.dev.data.model.Category;

/**
 *
 * @author ACER NITRO
 */
public class EditCategoryServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category = DatabaseDao.getInstance().getCategoryDao().find(categoryId);

        session.setAttribute("category", category);
        request.getRequestDispatcher("admin/category/edit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        HttpSession session = request.getSession();

        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        Category category = categoryDao.find(categoryId);

        String name = request.getParameter("name");
        String thumbnail = request.getParameter("thumbnail");

        category.setName(name);
        category.setThumbnail(thumbnail);
        if (name.isEmpty() || thumbnail.isEmpty()) {
            session.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin");
            request.getRequestDispatcher("admin/category/edit.jsp").forward(request, response);
        } else {
            categoryDao.update(category);

            response.sendRedirect("IndexCategoryServlet");
        }

    }

}
