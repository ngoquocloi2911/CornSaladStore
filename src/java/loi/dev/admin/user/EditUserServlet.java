/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev.admin.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loi.dev.BaseServlet;
import loi.dev.data.dao.DatabaseDao;
import loi.dev.data.dao.UserDAO;
import loi.dev.data.model.User;

/**
 *
 * @author ACER NITRO
 */
public class EditUserServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user1 = DatabaseDao.getInstance().getUserDao().find(userId);
        session.setAttribute("user1", user1);
        request.getRequestDispatcher("admin/user/edit.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO userDao = DatabaseDao.getInstance().getUserDao();
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter("userId"));
        User user = userDao.find(userId);
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

//        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        if (email.isEmpty() || password.isEmpty() || role.isEmpty()) {
            session.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin");
            request.getRequestDispatcher("admin/user/edit.jsp").forward(request, response);
            // Xử lý lỗi khi thay đổi email
        } else if (!email.equals(user.getEmail())) {
            session.setAttribute("errorMessage", "Không được thay đổi Email");
            request.getRequestDispatcher("admin/user/edit.jsp").forward(request, response);

        } else {
            userDao.update(user);
            response.sendRedirect("IndexUserServlet");
        }

    }

}
