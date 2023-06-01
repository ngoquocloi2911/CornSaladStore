/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import loi.dev.data.dao.DatabaseDao;
import loi.dev.data.dao.UserDAO;
import loi.dev.data.model.User;

/**
 *
 * @author ACER NITRO
 */
public class RegisterServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("register.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repeatPass = request.getParameter("repeatPass");
        String role = request.getParameter("role");
        UserDAO userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(email);
        //        Kiểm tra thông tin đăng ký 
        // Xử lý lỗi khi nhập thông tin thiếu
        if (email.isEmpty() || password.isEmpty() || repeatPass.isEmpty() || role.isEmpty()) {

            session.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin đăng ký");
            session.setAttribute("email", email);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            // Xử lý lỗi khi emai trùng
        } else if (user != null) {
            session.setAttribute("errorMessage", "Email trùng");
            session.setAttribute("email", email);
            request.getRequestDispatcher("register.jsp").forward(request, response);
            // Xử lý lỗi khi mật khẩu nhập lại không đúng
        } else if (!password.equals(repeatPass)) {
            session.setAttribute("errorMessage", "Mật khẩu nhập lại không trùng");
            session.setAttribute("email", email);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            // Xử lý thông tin đăng ký hợp lệ
            user = new User(email, password, role);
            userDao.insert(user);
            response.sendRedirect("LoginServlet");
        }
    }

}
