/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loi.dev;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import loi.dev.data.dao.Database;
import loi.dev.data.dao.DatabaseDao;
import loi.dev.data.model.Category;

/**
 *
 * @author ACER NITRO
 */
public class BaseServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        DatabaseDao.init(new Database());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = DatabaseDao.getInstance().getCategoryDao().findAll();
        req.setAttribute("categoryList", categoryList);
    }

}
