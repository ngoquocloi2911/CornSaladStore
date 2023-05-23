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
import loi.dev.data.dao.Database;
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
        request.getRequestDispatcher("login.jsp").include(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDAO userDAO = DatabaseDao.getInstance().getUserDao();
        User user = userDAO.find(email, password);
        PrintWriter out = response.getWriter();
        if( user == null)
        {
            out.println("login fail");
        }else{
            out.println("login success");
        }
    }

}
