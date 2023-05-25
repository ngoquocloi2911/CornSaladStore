/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
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
public class LoginServlet extends BaseServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            response.sendRedirect("HomeServlet");
        }
        
        request.getRequestDispatcher("login.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDAO userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(email, password);

        if (user == null) {
            response.sendRedirect("LoginServlet");
            session.setAttribute("errors", "Login Failed");

        } else {
            session.setAttribute("user", user);
            String url = request.getHeader("referer");
            String referer = request.getParameter("referer");
            getServletContext().getRequestDispatcher(referer).forward(request, response);
        }
    }

}
