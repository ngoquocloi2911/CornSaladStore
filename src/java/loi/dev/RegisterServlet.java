/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String repeatPass = request.getParameter("repeatPass");
        
        
//        Kiểm tra thông tin đăng ký 
        if(userName.isEmpty() || email.isEmpty() ||pass.isEmpty() ||repeatPass.isEmpty() )
        {
            // Xử lý lỗi khi thông tin đăng ký thiếu
            request.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin đăng ký");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else{
            // Xử lý thông tin đăng ký hợp lệ
            response.sendRedirect("LoginServlet");
        }
    }

}
