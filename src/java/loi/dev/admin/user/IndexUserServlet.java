/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package loi.dev.admin.user;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import loi.dev.BaseServlet;
import loi.dev.data.dao.DatabaseDao;
import loi.dev.data.model.User;

/**
 *
 * @author ACER NITRO
 */
public class IndexUserServlet extends BaseServlet {

    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       List<User> userList = DatabaseDao.getInstance().getUserDao().findAll();
       request.setAttribute("userList", userList);
       request.getRequestDispatcher("admin/user/index.jsp").include(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   

}
