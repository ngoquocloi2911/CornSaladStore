/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loi.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import loi.dev.data.dao.Database;
import loi.dev.data.dao.DatabaseDao;

/**
 *
 * @author ACER NITRO
 */
public class BaseServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        DatabaseDao.init(new Database());
    }
    
}
