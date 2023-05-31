/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev.admin.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import loi.dev.BaseServlet;
import loi.dev.data.dao.DatabaseDao;

/**
 *
 * @author ACER NITRO
 */
public class DeleteUserServlet extends BaseServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int userId = Integer.parseInt(request.getParameter("userId"));
        DatabaseDao.getInstance().getUserDao().delete(userId);
        
        response.sendRedirect("IndexUserServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

 

}
